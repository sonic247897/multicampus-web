<%@page import="dept.DeptDAO"%>
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
<hr/>
	<%
		//��û���� ����
		request.setCharacterEncoding("euc-kr"); 
		/* MIMEŸ���� �� ���� �����Ǿ� �����Ƿ� �� �ʿ�x  */
		//response.setContentType("text/html;charset=euc-kr");
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String loc = request.getParameter("loc");
		String tel = request.getParameter("tel");
		String mgr = request.getParameter("mgr");
		DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
		
		DeptDAO dao = new DeptDAO();
		int result = dao.insert(dept);
		
	%>
	<h1>���Լ���</h1>
	<hr/>
	<h1><%=result %>���� �� ���Լ���</h1>

</body>
</html>