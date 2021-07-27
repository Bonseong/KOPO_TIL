
package kr.ac.kopo.transfer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.account.AccountDAO;
import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.bank.BankVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.transfer.TransferDAO;
import kr.ac.kopo.transfer.TransferVO;

public class TransferProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		AccountVO accVO = new AccountVO();
		AccountDAO accDAO = new AccountDAO();

		String id = request.getParameter("id");
		String accNo = request.getParameter("accNo");
		String AccPassword = request.getParameter("AccPassword");

		accVO.setId(id);
		accVO.setAcc_no(accNo);
		accVO.setPassword(AccPassword);

		TransferVO trVO = new TransferVO();
		TransferDAO trDAO = new TransferDAO();

		String sendingBankName = request.getParameter("sendingBankName");
		String sendingAccNo = accNo; // 보내는 계좌
		String receivingBankName = request.getParameter("receivingBankName"); // 받는 은행
		String receivingAccNo = request.getParameter("receivingAccNo"); // 받는 계좌

		int remittance = Integer.parseInt(request.getParameter("remittance")); // 이체액
		trVO.setSendingBankName(sendingBankName);
		trVO.setSendingAccNO(sendingAccNo);
		int balance = accDAO.checkBalance(accVO);
		trVO.setBeforeBalance(balance);
		trVO.setRemittance(remittance);
		trVO.setAfterBalance(balance - remittance);
		trVO.setReceivingAccNO(receivingAccNo);
		trVO.setReceivingBankName(receivingBankName);

		if (accDAO.checkPassword(accVO)) {
			if (balance > 0) {
				if (balance > remittance) {

					if (receivingBankName.equals("세진저축은행")) { // 세진저축은행일때 (동행입금)
						if (!sendingAccNo.equals(receivingAccNo)) { // 에러 : 동행입금일떄 보내는 계좌랑 받는 계좌랑 같음
							if (accDAO.checkDuplicated(receivingAccNo)) { // 계좌 존재

								trDAO.transferSameBank(trVO);
								return "redirect:/";

							} else {
								System.out.println("에러 : 계좌존재하지 않음 (지금은 내 은행에 대해서만 하기)");
								return "redirect:/transfer.do"; // 에러 : 계좌존재하지 않음 (지금은 내 은행에 대해서만 하기)
							}
						} else {
							System.out.println("에러 : 동행입금일떄 보내는 계좌랑 받는 계좌랑 같음");
							return "redirect:/transfer.do";// 에러 : 동행입금일떄 보내는 계좌랑 받는 계좌랑 같음
						}
					} else {

						BankVO receivingBankInfo = trDAO.getBankInfo(trVO);
						TransferVO receivingVO = trDAO.checkAccountOtherBank(receivingBankInfo, trVO);
						
						if (!(receivingVO.equals(null))) {
							receivingVO.setRemittance(remittance);
							receivingVO.setAfterBalance(balance+remittance);
							trDAO.transferOtherBank(receivingBankInfo, receivingVO, trVO);
							return "redirect:/"; // 타행입금
						} else {
							System.out.println("// 에러 : 타행에 계좌가 존재하지 않음");
							return "redirect:/transfer.do";// 에러 : 타행에 계좌가 존재하지 않음
						}

					}

				} else {
					System.out.println("// 에러 : 잔액 > 송금액");
					return "redirect:/transfer.do"; // 에러 : 잔액 > 송금액
				}

			} else {
				System.out.println("에러 : 잔액 : 0원 미만");
				return "redirect:/transfer.do"; // 에러 : 잔액 : 0원 미만
			}

		} else {
			System.out.println("비밀번호오류");
			return "redirect:/transfer.do"; // 에러 : 비밀번호 오류
		}

	}
}