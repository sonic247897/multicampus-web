<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>서블릿에서 처리했던 작업을 jsp에서 처리해보기</h1>
	<!-- 클래스를 정의하지 않으므로 간단하게 느껴진다. but 정해져있는 이름으로 접근해서 써야함 -->
	<hr/>
	<%
		//요청정보 추출
		request.setCharacterEncoding("euc-kr"); 
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
	%>
	<h3>아이디:<%=id %></h3>
	<h3>패스워드:<%=pass %></h3>
</body>
</html>