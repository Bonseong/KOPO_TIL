package kr.ac.kopo.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.account.AccountDAO;
import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.transfer.TransferDAO;
import kr.ac.kopo.transfer.TransferVO;

public class CheckAccountTransferLogProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String url = "";
		AccountVO accVO = new AccountVO();
		AccountDAO dao = new AccountDAO();

		String id = request.getParameter("id");
		String accNo = request.getParameter("accNo");

		String currentAccPassword = request.getParameter("currentAccPassword");
		accVO.setId(id);
		accVO.setAcc_no(accNo);
		accVO.setPassword(currentAccPassword);
		dao.checkPassword(accVO);

		if (dao.checkPassword(accVO)) {
			
			TransferVO trVO = new TransferVO();
			TransferDAO trDAO = new TransferDAO();
			
			trVO.setReceivingAccNO(accNo);
			trVO.setSendingAccNO(accNo);
			
			List<TransferVO> logList = trDAO.selectTransferLog(trVO);
			
			HttpSession session = request.getSession();
			
			
			session.setAttribute("logList", logList);
			
			url = "redirect:/checkAccountTransferLogResult.do";
			// 페이지 넘기기 하기@@@@@@@@@@@@@@


		} else {
			// 비밀번호 오류
			url = "redirect:/checkAccountDetail.do";
		}

		return url;

	}
}
