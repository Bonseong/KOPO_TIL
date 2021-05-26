package kr.ac.kopo.ui;

public class BoardUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		while (true) { // try~catch 문을 넣어 SW의 종료를 넣는 것이 좋음
			try {
				IBoardUI ui = null; // execute 명령어를 interface가 알고있기 때문
				int type = menu();
				switch (type) {
				case 1:
					ui = new SearchAllUI();
					break;
				case 2:
					ui = new SearchOneUI();
					break;
				case 3:
					ui = new AddUI();
					break;
				case 4:
					ui = new UpdateUI();
					break;
				case 5:
					ui = new DeleteUI();
					break;
				case 0:
					ui = new ExitUI();
					break;
				}

				if (ui != null) {
					ui.execute(); // execute라는 공통의 메소드를 case 밖으로 -> 유지보수에 편리
				} else {
					System.out.println("잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				System.out.println("BoardUI Exception");
			}
		}
	}

	private int menu() {
		System.out.println("------------------------------------");
		System.out.println("\t게시판 관리 프로그램");
		System.out.println("------------------------------------");
		System.out.println("\t1. 전체게시글 조회");
		System.out.println("\t2. 글번호 조회");
		System.out.println("\t3. 새글등록");
		System.out.println("\t4. 게시글 수정");
		System.out.println("\t5. 게시글 삭제");
		System.out.println("\t0. 종료");
		System.out.println("------------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}

}
