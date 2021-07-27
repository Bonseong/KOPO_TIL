package kr.ac.kopo.openBank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.openBank.OpenBankDAO;
import kr.ac.kopo.openBank.OpenBankVO;

public class OpenBankEnrollSelectProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String url = "";
		OpenBankVO OBvo = new OpenBankVO();
		OpenBankDAO OBdao = new OpenBankDAO();

		String id = request.getParameter("id");
		String openAcc = request.getParameter("openAcc");

		String[] openAcc_split = openAcc.split(" : ");

		OBvo.setId(id);
		OBvo.setOpenBankName(openAcc_split[0]);
		OBvo.setOpenAccNo(openAcc_split[1]);

		if (!OBdao.checkOpenBankAcc(OBvo)) {
			OBdao.enrollOpenBank(OBvo);
			url = "redirect:/";
		} else {

			url = "redirect:/openBankEnrollSelect.do";
		}

		return url;

	}
}