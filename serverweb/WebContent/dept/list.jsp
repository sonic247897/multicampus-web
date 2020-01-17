<%@page import="dept.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<DeptDTO> deptList = 
			(ArrayList<DeptDTO>)request.getAttribute("deptList");
	%>
	
	<h1>부서 목록보기~~~~^^</h1>
	<hr/>
	<table border='1' width='500px'><th>부서코드</th><th>부서명</th><th>부서위치</th><th>전화번호</th><th>관리자</th><th>삭제</th>
	<% int size = deptList.size();
	for(int i=0; i<size; ++i) { 
		DeptDTO dept = deptList.get(i);%>
		<tr>
		<td><%=dept.getDeptNo()%></td>
		<td><%=dept.getDeptName()%></td>
		<td><%=dept.getLoc()%></td>
		<td><%=dept.getTel()%></td>
		<td><%=dept.getMgr()%></td>
		<td><a href ='/serverweb/dept/delete.do?deptNo=<%=dept.getDeptNo()%>&info=test'>삭제</a></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>