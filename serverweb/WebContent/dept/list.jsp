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
		//������ ������ ������ ������
		ArrayList<DeptDTO> deptList = 
			(ArrayList<DeptDTO>)request.getAttribute("deptList");
	%>
	
	<h1>�μ� ��Ϻ���~~~~^^</h1>
	<hr/>
	<table border='1' width='500px'><th>�μ��ڵ�</th><th>�μ���</th><th>�μ���ġ</th><th>��ȭ��ȣ</th><th>������</th><th>����</th>
	<% int size = deptList.size();
	for(int i=0; i<size; ++i) { 
		DeptDTO dept = deptList.get(i);%>
		<tr>
		<td><%=dept.getDeptNo()%></td>
		<td><%=dept.getDeptName()%></td>
		<td><%=dept.getLoc()%></td>
		<td><%=dept.getTel()%></td>
		<td><%=dept.getMgr()%></td>
		<td><a href ='/serverweb/dept/delete.do?deptNo=<%=dept.getDeptNo()%>&info=test'>����</a></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>