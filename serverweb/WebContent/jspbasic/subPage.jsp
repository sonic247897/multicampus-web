<%@page import="dept.DeptDTO"%>
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
		//������ ������ ������ ��������
		// ���� �ߴ� ����? ������
		// - Object�� �����´�.
		DeptDTO dept = (DeptDTO)request.getAttribute("mydata");
	%>
	<h1>��û���������� ����� ������</h1>
	<hr/>
	<!-- sendRedirect: nullPtrException �߻� -->
	<h2>���������� :<%= dept.getDeptName() %></h2>
</body>
</html>