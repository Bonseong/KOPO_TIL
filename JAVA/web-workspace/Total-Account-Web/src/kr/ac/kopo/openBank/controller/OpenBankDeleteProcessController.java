package kr.ac.kopo.openBank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.openBank.OpenBankDAO;
import kr.ac.kopo.openBank.OpenBankVO;

public class OpenBankDeleteProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String msg = "";
		String url = "";
		OpenBankVO OBvo = new OpenBankVO();
		OpenBankDAO OBdao = new OpenBankDAO();

		String id = request.getParameter("id");
		String openAcc = request.getParameter("openAcc");
		String rrn = request.getParameter("rrn");
			
		String[] openAcc_split = openAcc.split(" : ");

		OBvo.setId(id);
		OBvo.setOpenBankName(openAcc_split[0]);
		OBvo.setOpenAccNo(openAcc_split[1]);
		OBvo.setRrn(rrn);

		
		if (OBdao.checkOpenBankAcc(OBvo)) {
			OBdao.deleteOpenBank(OBvo);
			
			url = "redirect:/";
			msg = "삭제되었습니다.";
			
		} else {
			url = "redirect:/openBankDelete.do";
			msg = "입력하신 정보가 올바르지 않습니다.";
		}
		request.setAttribute("msg", msg);
		return url;

	}
}