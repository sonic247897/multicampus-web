<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/serverweb/jspbasic/requestObjTest.jsp">
		아이디: <input type="text" name="id"><br/>
		<!-- type을 text로 바꾸면 한글도 패스워드로 사용할 수 있다.  -->
		패스워드: <input type="password" name="pass"><br/>
		<input type="submit" value = "로그인">
	</form>

</body>
</html>