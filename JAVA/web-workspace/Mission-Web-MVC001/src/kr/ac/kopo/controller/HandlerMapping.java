package kr.ac.kopo.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		// url과 일치하는 이름을 갖는 jsp를 컨트롤러로 매핑
		mappings = new HashMap<>();
		mappings.put("/board/list.do", new BoardListController());
		mappings.put("/board/writeForm.do", new WriteFormController());
		mappings.put("/board/detail.do", new BoardDetailController());
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}

}
