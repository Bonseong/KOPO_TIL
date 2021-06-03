package kr.ac.kopo.service;

import kr.ac.kopo.dao.AccountDAODB;
import kr.ac.kopo.vo.AccountVO;
import kr.ac.kopo.vo.User_InfoVO;

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

	public int depositService(AccountVO newAcc, int depositAmount) throws Exception {
		return dao.deposit(newAcc.getAccNo(), depositAmount);
	}

	public int BalanceCheckService(AccountVO newAcc) throws Exception {
		return dao.checkBalance(newAcc);
	}

	public int withdrawService(AccountVO newAcc, int withdrawAmount) throws Exception {
		return dao.withdraw(newAcc.getAccNo(), withdrawAmount);
	}

	public int transferService(AccountVO newAcc, String acc, int transferAmount) throws Exception {
		return dao.transfer(newAcc.getAccNo(), acc, transferAmount);
	}

	public void searchTransferLogService(AccountVO newAcc, String session) throws Exception {
		dao.searchTransferLog(newAcc, session);
	}

	public boolean searchOneService(User_InfoVO newUser, AccountVO newAcc) throws Exception {
		return dao.searchOne(newUser, newAcc);
	}

	public void searchAllService(User_InfoVO newUser) throws Exception {
		dao.searchAll(newUser);

	}

	public void updatePasswordService(AccountVO newAcc) throws Exception {
		dao.updatePassword(newAcc);
	}

	public void updateNicknameService(AccountVO newAcc) throws Exception {
		dao.updateNickname(newAcc);
	}

	public void deleteAccountService(AccountVO newAcc) throws Exception {
		dao.deleteAccount(newAcc);
	}

}
