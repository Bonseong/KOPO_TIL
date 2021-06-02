package kr.ac.kopo.ui.total;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.User_InfoVO;

public class RegisterUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		User_InfoVO newUser = new User_InfoVO();

		System.out.println("회원가입 메뉴입니다.");
		String id = scanStr("원하는 아이디를 입력하세요 : ");

		newUser.setId(id);

		boolean bool = User_InfoService.idCheckService(newUser);

		if (bool == true) {
			System.out.println("이미 존재하는 아이디입니다.");
			System.out.println("다른 아이디를 입력해주세요");

		} else {
			String pw = scanStr("원하는 패스워드를 입력해주세요 : ");
			newUser.setPw(pw);
			if (newUser.getPw().length() > 10) {
				System.out.println("비밀번호는 10자 이내로 입력하세요");
			} else {
				String name = scanStr("이름을 입력하세요 : ");
				newUser.setUserName(name);
				String mobile = scanStr("핸드폰 번호를 입력하세요 : ");
				newUser.setMobileNo(mobile);
				User_InfoService.register(newUser);

			}

		}

	}

}
