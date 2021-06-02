package kr.ac.kopo.ui.user;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.BankVO;

public class EnrollUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		BankVO newBank = new BankVO();
		String bankname = null;
		
		if(BankService.checkLastDayService(session)) {
			System.out.println("고객님은 30일 이내에 개설한 계좌가 없습니다.");
			System.out.println("계좌생성 서비스 입니다.");
			System.out.println("원하는 은행명을 입력해주세요 : ");
			int num = scanInt("1. 하나  2. 신한  3. KB  4. 우리");
			
			switch(num) {
			case 1:
				bankname = "HANA";
				break;
			case 2:
				bankname = "SHINHAN";
				break;
			case 3:	
				bankname = "KB";
				break;
			case 4:
				bankname = "WOORI";
				break;
			default:
				System.out.println("다시 확인해주세요"); 
			}
			
			String pw = scanStr("원하는 비밀번호를 입력해주세요 : ");
			
			if(pw.equals(scanStr("다시 한번 입력해주세요"))) {
				newBank.setBankName(bankname);
				
				
				
				String arr = BankService.enrollAccountService(newBank, session, pw);
				System.out.println("고객님의 계좌번호는 [ " +  arr + " ] 입니다." );
				
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}else {
			System.out.println("고객님의 최근 30일 이내에 개설한 계좌가 존재합니다.");
			System.out.println("서비스를 이용할 수 없습니다.");
		}
		
		

		
		
		
	}
	

}
