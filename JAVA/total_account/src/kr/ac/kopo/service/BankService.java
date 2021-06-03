package kr.ac.kopo.service;

import kr.ac.kopo.dao.BankDAODB;
import kr.ac.kopo.vo.BankVO;

public class BankService {
	private  BankDAODB dao;

	public BankService() {
		dao = new BankDAODB();
	}

	public boolean checkLastDayService(String session) throws Exception {
		return dao.checkLastDay(session);
	}
	
	public String enrollAccountService(BankVO newBank, String session, String pw) throws Exception {
		return dao.enrollAccount(newBank, session, pw);
	}
	
	public void searchByBankService(BankVO newBank, String session) throws Exception {
		dao.searchByBank(newBank, session);
		
	}


	
	
	
}
