package kr.ac.kopo.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.account.AccountDAO;
import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.controller.Controller;

public class DeleteAccountProcessController implements Controller {

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
			if (dao.checkBalance(accVO) == 0) { // 0원이어야만 제거 가능
				dao.deleteAccount(accVO);
				url = "redirect:/";
			} else if (dao.checkBalance(accVO) == -1) {
				// 오류
				url = "redirect:/deleteAccount.do";
			}

		} else {
			// 비밀번호 오류
			url = "redirect:/deleteAccount.do";
		}

		return url;

	}
}
