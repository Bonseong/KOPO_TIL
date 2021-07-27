package kr.ac.kopo.account.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.account.AccountDAO;
import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.controller.Controller;

public class OpenAccountProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		AccountVO accVO = new AccountVO();
		AccountDAO dao = new AccountDAO();

		String accNo = makeRandomAccNo();
		while (dao.checkDuplicated(accNo)) {
			accNo = makeRandomAccNo();
		}
		
		String bankCode = "1000";
		String id = request.getParameter("id");
		int balance = 0;
		String accNickName = request.getParameter("accNickname");
		
		String accPassword = request.getParameter("accPassword");
		String accPasswordConfirm = request.getParameter("AccPasswordConfirm");
		String url = "";
		
		if(!accPassword.equals(accPasswordConfirm)){
			url = "redirect:/openAccount.do";
		}else {
			accVO.setAcc_no(accNo);
			accVO.setBank_code(bankCode);
			accVO.setBalance(balance);
			accVO.setNickname(accNickName);
			accVO.setPassword(accPassword);
			accVO.setId(id);
			
			dao.openAccount(accVO);
						
			url = "redirect:/success.do";
		}

		return url;

	}

	public String makeRandomAccNo() {
		Random random = new Random();
		StringBuilder sql = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			sql.append(random.nextInt(9));
		}
		sql.append('-');

		for (int i = 0; i < 3; i++) {
			sql.append(random.nextInt(9));
		}
		sql.append('-');

		for (int i = 0; i < 3; i++) {
			sql.append(random.nextInt(9));
		}
		return (sql.toString());
	}

}
