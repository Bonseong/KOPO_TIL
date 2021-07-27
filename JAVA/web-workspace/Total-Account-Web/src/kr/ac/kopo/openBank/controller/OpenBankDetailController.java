package kr.ac.kopo.openBank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.login.LoginVO;
import kr.ac.kopo.openBank.OpenBankDAO;
import kr.ac.kopo.openBank.OpenBankVO;

public class OpenBankDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		OpenBankVO OBvo = new OpenBankVO();
		OpenBankDAO OBdao = new OpenBankDAO();

		HttpSession session = request.getSession();
		LoginVO vo = (LoginVO) session.getAttribute("userVO");

		OBvo.setId(vo.getId());

		List<OpenBankVO> detailAccList = OBdao.selectAllOpenAcc(OBvo);

		session.setAttribute("detailAccList", detailAccList);
		return "/openBank/openBankDetail.jsp";
	}
}
