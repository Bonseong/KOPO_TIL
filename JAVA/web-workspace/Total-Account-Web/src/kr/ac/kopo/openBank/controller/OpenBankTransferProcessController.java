
package kr.ac.kopo.openBank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.openBank.OpenBankDAO;
import kr.ac.kopo.openBank.OpenBankVO;

public class OpenBankTransferProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String sendingAccList = request.getParameter("openAccList");

		String[] openAcc_split = sendingAccList.split(" : ");
		String sendingBankName = openAcc_split[0];
		String sendingAccNo = openAcc_split[1];

		String AccPassword = request.getParameter("AccPassword");
		String rrn = request.getParameter("rrn");

		int remittance = Integer.parseInt(request.getParameter("remittance"));

		String receivingBankName = request.getParameter("receivingBankName");
		String receivingAccNo = request.getParameter("receivingAccNo");

		OpenBankVO sendingVO = new OpenBankVO();
		OpenBankVO receivingVO = new OpenBankVO();
		OpenBankDAO obDAO = new OpenBankDAO();

		sendingVO.setOpenBankName(sendingBankName);
		sendingVO.setOpenAccNo(sendingAccNo);
		sendingVO.setRrn(rrn);
		sendingVO.setId(id);
		sendingVO.setPassword(AccPassword);

		receivingVO.setOpenBankName(receivingBankName);
		receivingVO.setOpenAccNo(receivingAccNo);

		if (obDAO.checkUserInfo(sendingVO)) {
			int sendingAccBalance = obDAO.getOpenBankBalance(sendingVO);
			int receivingAccBalance = obDAO.getOpenBankBalance(receivingVO);

			
			sendingVO.setBalance(sendingAccBalance);
			receivingVO.setBalance(receivingAccBalance);
			
			if (receivingAccBalance >= 0) {

				if (sendingAccBalance >= remittance) {
					
					obDAO.transferOpenBank(sendingVO, remittance, receivingVO);
					
					return "redirect:/";
					
				} else {
					System.out.println("잔액부족");
					return "redirect:/openBankTransfer.do"; // 잔액부족
				}
			} else {
				System.out.println("받는 계좌가 없음");
				return "redirect:/openBankTransfer.do"; // 받는 계좌가 존재하지 않음
			}

		} else {
			System.out.println("보내는 계좌의 정보가 올바르지 않음");
			return "redirect:/openBankTransfer.do"; // 보내는 계좌의 정보가 올바르지 않음

		}

	}
}