package kr.ac.kopo.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.account.AccountDAO;
import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.controller.Controller;

public class ModifyAccountPasswordProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String url;
		AccountVO accVO = new AccountVO();
		AccountDAO dao = new AccountDAO();
		
		String id = request.getParameter("id");
		String accNo = request.getParameter("accNo");
		
		String currentAccPassword = request.getParameter("currentAccPassword");
		
		
		
		accVO.setId(id);
		accVO.setAcc_no(accNo);
		accVO.setPassword(currentAccPassword);

		if(dao.checkPassword(accVO)) {
			String accPassword = request.getParameter("accPassword");
			String accPasswordConfirm = request.getParameter("accPasswordConfirm");
			
			if(accPassword.equals(accPasswordConfirm)) {
				accVO.setPassword(accPassword);
				dao.modifyAccountPassword(accVO);
				url = "redirect:/";
			}else {
				url = "redirect:/modifyAccountPassword.do";
				
			}
		}else {
			url = "redirect:/modifyAccountPassword.do";
		}
		
		
		return url;
	}

}
