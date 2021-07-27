<%@page import="kr.ac.kopo.board.vo.BoardFileVO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="kr.ac.kopo.util.KopoFileNamePolicy"%>

<%@page import="kr.ac.kopo.board.vo.BoardVO"%>
<%@page import="kr.ac.kopo.board.dao.BoardDAO"%>
<%@page import="kr.ac.kopo.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
	작업순서
	1. 파라미터(제목, 작성자, 내용)  추출
	2. 추출된 데이터를 DB(t_board)에 삽입
	3. 목록페이지 이동
 --%>
<%-- <%
request.setCharacterEncoding("utf-8");
String saveDirectory = "D:/KOPO/Total-Account-Web/WebContent/upload";
/* 바로바로 동기화가 되고있지 않기때문에 새로고침이 필요함, 실제 개발할때는 다른 폴더에 해야함 */

MultipartRequest multiRequest = new MultipartRequest(request, saveDirectory, 1024 * 1024 * 3, "utf-8",
		new KopoFileNamePolicy());

// 1. 게시글 저장(t_board)
String title = multiRequest.getParameter("title");
String writer = multiRequest.getParameter("writer");
String content = multiRequest.getParameter("content");

BoardDAO dao = new BoardDAO();
// 게시물 번호 추출

int boardNo = dao.selectNo();

BoardVO board = new BoardVO();
board.setTitle(title);
board.setWriter(writer);
board.setContent(content);
board.setNo(boardNo);

dao.insert(board);

// 2. 첨부파일 저장(t_board_file)
Enumeration files = multiRequest.getFileNames();
while (files.hasMoreElements()) { // 다음 데이터가 존재하는지
	String fileName = (String) files.nextElement();
	File f = multiRequest.getFile(fileName);

	if (f != null) {
		String fileOriName = multiRequest.getOriginalFileName(fileName);
		String fileSaveName = multiRequest.getFilesystemName(fileName);
		int fileSize = (int) f.length();

		BoardFileVO fileVO = new BoardFileVO();
		fileVO.setFileOriName(fileOriName);
		fileVO.setFileSaveName(fileSaveName);
		fileVO.setFileSize(fileSize);
		fileVO.setBoardNo(boardNo);

		dao.insertFile(fileVO);

	}
}
%> --%>
<script>
	alert('새글 등록이 완료되었습니다')
	location.href = "list.jsp"
</script>