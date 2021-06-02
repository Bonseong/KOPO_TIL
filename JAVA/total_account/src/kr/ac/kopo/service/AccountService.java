package kr.ac.kopo.service;

import kr.ac.kopo.dao.AccountDAODB;
import kr.ac.kopo.vo.AccountVO;

public class AccountService {
	private AccountDAODB dao;

	public AccountService() {
		dao = new AccountDAODB();
	}

	public boolean AccountCheckService(AccountVO newAcc, String acc) throws Exception {
		return dao.checkAccount(newAcc, acc);
	}

	public boolean AccountCheckService(String acc) throws Exception {
		return dao.checkAccount(acc);
	}

	public int depositService(AccountVO newAcc, int depositAmount) {
		return dao.deposit(newAcc.getAccNo(), depositAmount);
	}

	public int BalanceCheckService(AccountVO newAcc) {
		return dao.checkBalance(newAcc);
	}

	public int withdrawService(AccountVO newAcc, int withdrawAmount) {
		return dao.withdraw(newAcc.getAccNo(), withdrawAmount);
	}

	public int transferService(AccountVO newAcc, String acc, int transferAmount) {
		return dao.transfer(newAcc.getAccNo(), acc, transferAmount);
	}
}
