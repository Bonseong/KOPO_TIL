package kr.ac.kopo.openBank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.login.LoginDAO;
import kr.ac.kopo.login.LoginVO;
import kr.ac.kopo.openBank.OpenBankDAO;
import kr.ac.kopo.openBank.OpenBankVO;

public class OpenBankEnrollProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String url = "";
		LoginVO accVO = new LoginVO();

		LoginDAO dao = new LoginDAO();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String rrn = request.getParameter("rrn");

		accVO.setId(id);
		accVO.setPassword(password);
		accVO.setRrn(rrn);

		LoginVO userInfo = dao.checkUserInfo(accVO);

		if(!userInfo.getName().equals("NoData")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);
			
			OpenBankVO OBvo = new OpenBankVO();		
			OpenBankDAO OBdao= new OpenBankDAO();
			OBvo.setRrn(rrn);
			OBvo.setId(id);
			System.out.println(rrn);
			List<OpenBankVO> accList = OBdao.selectAllMyAcc(OBvo);
			System.out.println(accList);
			session.setAttribute("accList", accList);
			
			url = "redirect:/openBankEnrollSelect.do";
		}else {
			url = "redirect:/openBankEnroll.do";
		}
		
			
		
		
		return url;
	}
}