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
		//서블릿이 공유해준 ArrayList<DeptDTO>객체 가져오기
		//서블릿을 거치지 않고 실행하면 서블릿이 공유해준 데이터가 없으므로
		// java.lang.NullPointerException이 발생한다.
		// => 응답 JSP페이지는 먼저 요청되지 않게 해야한다.
		
		
		// <디버깅 - MVC패턴>
		// 1. Servlet가서 공유 데이터명 맞는지 확인
		// 2. DeptDAO 가서 정말로 ArrayList<DeptDTO> 받았는지(DB조회)-list 사이즈 찍어보기
		// 3. Sql문 점검 - sql문 맞으면 while문 들어감(rs있음) - while문에서 sysout("while")
		// 4. DAO함수에서 서블릿이 넘겨준 파라미터가 있다면 출력해보기
		// 5. 파라미터가 안 넘어오면? -> view에서 input받는 곳에서 name, value 제대로 넘어오고 있는지 확인
				//PrintWriter , getParameter
		// 6. DButil에서 ip, id, passwd를 올바르게 입력했는지
		ArrayList<MemberDTO> memList = 
			(ArrayList<MemberDTO>)request.getAttribute("memList");
	%>
	
	<h1>멤버 목록보기~~~~^^</h1>
	<hr/>
	<table border='1' width='500px'><th>id</th><th>pass</th><th>name</th><th>addr</th><th>deptno</th><th>grade</th><th>point</th><th>삭제</th>
	<% int size = memList.size();
	for(int i=0; i<size; ++i) { 
		MemberDTO mem = memList.get(i);%>
		<tr>
		<!-- 대부분 primary key로  정보를 넘겨준다! -->
		<td><a href= '/serverweb/member/read.do?id=<%=mem.getId() %>'><%=mem.getId()%></a></td>
		<td><%=mem.getPass()%></td>
		<td><%=mem.getName()%></td>
		<td><%=mem.getAddr()%></td>
		<td><%=mem.getDeptno()%></td>
		<td><%=mem.getGrade()%></td>
		<td><%=mem.getPoint()%></td>
		<td><a href ='/serverweb/member/delete.do?id=<%=mem.getId()%>&info=test'>삭제</a></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>