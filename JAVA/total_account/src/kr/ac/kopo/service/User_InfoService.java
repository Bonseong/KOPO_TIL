package kr.ac.kopo.service;

import kr.ac.kopo.dao.User_InfoDAODB;
import kr.ac.kopo.vo.User_InfoVO;

public class User_InfoService{
	private User_InfoDAODB dao;
	
	public User_InfoService() {
		dao = new User_InfoDAODB();
	}
	
	public void loginService(User_InfoVO newUser) throws Exception{
		dao.login(newUser);
	}
	
	public boolean idCheckService(User_InfoVO newUser) throws Exception{
		return dao.idCheck(newUser);
	}
	
	public void register(User_InfoVO newUser) throws Exception{
		dao.register(newUser);
	}
	
	
	
	
	
	
}
