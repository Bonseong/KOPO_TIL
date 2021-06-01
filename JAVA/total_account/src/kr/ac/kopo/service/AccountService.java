package kr.ac.kopo.service;

import kr.ac.kopo.dao.AccountDAODB;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.User_InfoVO;

public class AccountService {
	private AccountDAODB dao;

	public AccountService() {
		dao = new AccountDAODB();
	}

	
	public boolean AccountCheckService(AccountVO newAcc) throws Exception{
		System.out.println(newAcc.getAccNo());
		System.out.println(newAcc.getAccPw());
		
		return dao.AccountCheck(newAcc);
	}


}
