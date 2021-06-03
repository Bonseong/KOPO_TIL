package kr.ac.kopo.ui.total;

import kr.ac.kopo.ui.user.UserMainUI;
import kr.ac.kopo.vo.User_InfoVO;

public class LoginUI extends TotalUI{
	
	
	
	@Override
	public void execute() throws Exception {
		
		User_InfoVO newUser = new User_InfoVO();
		
		String id = scanStr("아이디를 입력하세요 : ");
		String pw = scanStr("패스워드를 입력하세요 : ");
		
		newUser.setId(id);
		newUser.setPw(pw);
		
		
		User_InfoService.loginService(newUser);
		
		if(newUser.getId() == null) {
			System.out.println("로그인 실패");
		}else {
			System.out.println("로그인 성공");
			UserMainUI userui = new UserMainUI();
			session = newUser.getId();
			userui.execute();
		}
		
		
		
		
		
		
	}
	
}
