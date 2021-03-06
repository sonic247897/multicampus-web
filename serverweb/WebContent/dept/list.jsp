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
		<!-- 대부분 primary key로  정보를 넘겨준다! -->
		<td><a href= "/serverweb/dept/read.do?deptNo=<%=dept.getDeptNo() %>&info=한글데이터"><%=dept.getDeptName()%></a></td>
		<td><%=dept.getLoc()%></td>
		<td><%=dept.getTel()%></td>
		<td><%=dept.getMgr()%></td>
		<td><a href ='/serverweb/dept/delete.do?deptNo=<%=dept.getDeptNo()%>&info=test'>삭제</a></td>
		</tr>
		<%}%>
	</table>
	
</body>
</html>