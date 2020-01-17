<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//서블릿이 공유한 데이터 꺼내기
		// (톰캣 버전업)int에 대해서 기본형, 참조형 경계가 무너짐
		int result = (int)request.getAttribute("insertResult");
	%>

	<h1>응답결과</h1>
	<h2><%= result %>의 행 삽입성공</h2>
</body>
</html>