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
		//������ ������ ������ ������
		// (��Ĺ ������)int�� ���ؼ� �⺻��, ������ ��谡 ������
		int result = (int)request.getAttribute("insertResult");
	%>

	<h1>������</h1>
	<h2><%= result %>�� �� ���Լ���</h2>
</body>
</html>