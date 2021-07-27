package kr.ac.kopo.transfer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.account.AccountDAO;
import kr.ac.kopo.account.AccountVO;
import kr.ac.kopo.bank.BankDAO;
import kr.ac.kopo.bank.BankVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.login.LoginVO;

public class TransferController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountDAO dao = new AccountDAO();

		HttpSession session = request.getSession();
		LoginVO vo = (LoginVO) session.getAttribute("userVO");

		List<AccountVO> accList = dao.selectAllAccount(vo.getId());

		session.setAttribute("accList", accList);
		
		
		
		BankDAO bankDAO = new BankDAO();
		
		List<BankVO> bankList = bankDAO.selectAllBank();
		
		session.setAttribute("bankList", bankList);
		
		
		return "/transfer/transfer.jsp";
	}

}
