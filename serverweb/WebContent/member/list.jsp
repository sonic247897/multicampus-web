<%@page import="member.MemberDTO"%>
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
		//������ �������� ArrayList<DeptDTO>��ü ��������
		//������ ��ġ�� �ʰ� �����ϸ� ������ �������� �����Ͱ� �����Ƿ�
		// java.lang.NullPointerException�� �߻��Ѵ�.
		// => ���� JSP�������� ���� ��û���� �ʰ� �ؾ��Ѵ�.
		
		
		// <����� - MVC����>
		// 1. Servlet���� ���� �����͸� �´��� Ȯ��
		// 2. DeptDAO ���� ������ ArrayList<DeptDTO> �޾Ҵ���(DB��ȸ)-list ������ ����
		// 3. Sql�� ���� - sql�� ������ while�� ��(rs����) - while������ sysout("while")
		// 4. DAO�Լ����� ������ �Ѱ��� �Ķ���Ͱ� �ִٸ� ����غ���
		// 5. �Ķ���Ͱ� �� �Ѿ����? -> view���� input�޴� ������ name, value ����� �Ѿ���� �ִ��� Ȯ��
				//PrintWriter , getParameter
		// 6. DButil���� ip, id, passwd�� �ùٸ��� �Է��ߴ���
		ArrayList<MemberDTO> memList = 
			(ArrayList<MemberDTO>)request.getAttribute("memList");
	%>
	
	<h1>��� ��Ϻ���~~~~^^</h1>
	<hr/>
	<table border='1' width='500px'><th>id</th><th>pass</th><th>name</th><th>addr</th><th>deptno</th><th>grade</th><th>point</th><th>����</th>
	<% int size = memList.size();
	for(int i=0; i<size; ++i) { 
		MemberDTO mem = memList.get(i);%>
		<tr>
		<!-- ��κ� primary key��  ������ �Ѱ��ش�! -->
		<td><a href= '/serverweb/member/read.do?id=<%=mem.getId() %>'><%=mem.getId()%></a></td>
		<td><%=mem.getPass()%></td>
		<td><%=mem.getName()%></td>
		<td><%=mem.getAddr()%></td>
		<td><%=mem.getDeptno()%></td>
		<td><%=mem.getGrade()%></td>
		<td><%=mem.getPoint()%></td>
		<td><a href ='/serverweb/member/delete.do?id=<%=mem.getId()%>&info=test'>����</a></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>