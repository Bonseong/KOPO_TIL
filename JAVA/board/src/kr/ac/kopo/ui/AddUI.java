package kr.ac.kopo.ui;

import kr.ac.kopo.vo.BoardVO;

public class AddUI extends BaseUI {

	// private BoardService service; 모든 UI에 필요한 객체 -> 부모로 올림

	@Override
	public void execute() throws Exception {
		String title = scanStr("등록할 제목을 입력하세요 : ");
		String writer = scanStr("등록할 글쓴이를 입력하세요 : ");

	
		BoardVO newBoard = new BoardVO();

		newBoard.setTitle(title);
		newBoard.setWriter(writer);

		service.새글등록서비스(newBoard);

		System.out.println("게시글 등록을 완료하였습니다.");
	}

}
