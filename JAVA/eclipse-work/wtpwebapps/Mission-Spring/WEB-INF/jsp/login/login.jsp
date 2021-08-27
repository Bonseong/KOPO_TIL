<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/layout.css" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board.css" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script><script src="<%= request.getContextPath() %>/resources/js/myJS.js"></script>


<script>

	if('${ msg }')
		alert('${ msg }')
/*
	function isNull(obj, msg) {
		if(obj.value == '') {
			alert(msg)
			obj.focus()
			return true
		}
		return false
	}
*/
	function checkForm() {
		
		let f = document.loginForm
		
		if(isNull(f.id, '아이디를 입력하세요'))
			return false
		if(isNull(f.password, '패스워드를 입력하세요'))
			return false
		
		/*
		if(f.id.value == '') {
			alert('아이디를 입력하세요')
			f.id.focus()
			return false
		}
		
		if(f.password.value == '') {
			alert('패스워드를 입력하세요')
			f.password.focus()
			return false
		}
		*/
		
		return true
	}
	
	$(document).ready(function() {
		$('#exampleModal').on('shown.bs.modal', function () {
			  $('#myInput').trigger('focus')
			})
	})

</script>
</head>
<body>


	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp" /> --%>
	</header>
	<section>
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

		<div align="center">
			<hr>
			<h2>로그인</h2>
			<hr>
			<br>
			
			<form method="post" 
				  name="loginForm" onsubmit="return checkForm()">
				<table style="width: 40%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="checkbox">아이디저장
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="로그인">
				
			</form>
		</div>
	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>













