package kr.ac.kopo.service;

import kr.ac.kopo.dao.AccountDAODB;
import kr.ac.kopo.vo.AccountVO;

public class AccountService {
	private AccountDAODB dao;

	public AccountService() {
		dao = new AccountDAODB();
	}

	
	public boolean AccountCheckService(AccountVO newAcc) throws Exception{
		
		return dao.AccountCheck(newAcc);
	}


}
