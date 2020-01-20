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
		//�������� �������� ArrayList<DeptDTO>��ü ��������
		//�������� ��ġ�� �ʰ� �����ϸ� �������� �������� �����Ͱ� �����Ƿ�
		// java.lang.NullPointerException�� �߻��Ѵ�.
		// => ���� JSP�������� ���� ��û���� �ʰ� �ؾ��Ѵ�.
		
		
		// <����� - MVC����>
		// 1. Servlet���� ���� �����͸� �´��� Ȯ��
		// 2. DeptDAO ���� ������ ArrayList<DeptDTO> �޾Ҵ���(DB��ȸ)-list ������ ����
		// 3. Sql�� ���� - sql�� ������ while�� ��(rs����) - while������ sysout("while")
		// 4. DAO�Լ����� �������� �Ѱ��� �Ķ���Ͱ� �ִٸ� ����غ���
		// 5. �Ķ���Ͱ� �� �Ѿ����? -> view���� input�޴� ������ name, value ����� �Ѿ���� �ִ��� Ȯ��
				//PrintWriter , getParameter
		// 6. DButil���� ip, id, passwd�� �ùٸ��� �Է��ߴ���
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
		<!-- ��κ� primary key��  ������ �Ѱ��ش�! -->
		<td><a href= "/serverweb/dept/read.do?deptNo=<%=dept.getDeptNo() %>&info=�ѱ۵�����"><%=dept.getDeptName()%></a></td>
		<td><%=dept.getLoc()%></td>
		<td><%=dept.getTel()%></td>
		<td><%=dept.getMgr()%></td>
		<td><a href ='/serverweb/dept/delete.do?deptNo=<%=dept.getDeptNo()%>&info=test'>����</a></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>