<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 스크립트 요소: JAVA코드 ; JSP 서비스 메소드 안에서 작업하는 것과 같다. 
		javax.servlet.jsp.JspWriter out = null; :출력 객체 생성
 		out = pageContext.getOut();
	-->
	<% 
		out.print("<h2>안녕</h2>");
	%>
</body>
</html>