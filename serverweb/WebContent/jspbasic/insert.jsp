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
		//요청정보 추출
		request.setCharacterEncoding("euc-kr"); 
		/* MIME타입은 맨 위에 설정되어 있으므로 할 필요x  */
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
	<h1>삽입성공</h1>
	<hr/>
	<h1><%=result %>개의 행 삽입성공</h1>

</body>
</html>