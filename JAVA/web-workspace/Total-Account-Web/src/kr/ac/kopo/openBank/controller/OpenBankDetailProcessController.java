package kr.ac.kopo.openBank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.login.LoginDAO;
import kr.ac.kopo.login.LoginVO;
import kr.ac.kopo.openBank.OpenBankDAO;
import kr.ac.kopo.openBank.OpenBankVO;

public class OpenBankDetailProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String url = "";
		LoginVO loginVO = new LoginVO();
		LoginDAO loginDAO = new LoginDAO();

		String id = request.getParameter("id");
		String rrn = request.getParameter("rrn");

		loginVO.setId(id);
		loginVO.setRrn(rrn);

		LoginVO userInfo = loginDAO.checkOpenBankUserInfo(loginVO);
		if (!userInfo.getName().equals("NoData")) {

			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);

			String detailAccList = request.getParameter("detailAccList");
			String[] openAcc_split = detailAccList.split(" : ");

			OpenBankVO obVO = new OpenBankVO();
			OpenBankDAO obDAO = new OpenBankDAO();

			obVO.setId(id);
			obVO.setOpenBankName(openAcc_split[0]);
			obVO.setOpenAccNo(openAcc_split[1]);

			int balance = obDAO.getOpenBankBalance(obVO);
			obVO.setBalance(balance);
			
			session.setAttribute("obVO", obVO);
			System.out.println(obVO);
			
			url = "redirect:/openBankDetailResult.do";
		} else {
			url = "redirect:/openBankDetail.do";
		}

		return url;

	}
}
