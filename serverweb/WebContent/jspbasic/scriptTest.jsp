<!-- 지시자@ = container들에게 정보를 알려주기 위해서 정의하는 스크립트 요소 -->
<%@page import="java.util.Date"%>
<%@page import="dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" 
    import="java.util.Random, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML주석문 (클라이언트에 전송된다.): 사용X  -->
	<%-- JSP주석문 (서블릿으로 변환되기 때문에 클라이언트에 전송되지 않는다.) --%>
	<h2>1. 스크립트릿 - 자바코드를 정의할 수 있다.</h2>
	<%
		// 자바주석 - 클라이언트에 전송이 되지 않는다. 
		String str = new String("java");
		out.print("<h3>문자열의 길이:"+str.length()+"</h3>");
		/* JAVA의 단축키를 사용할 수 X */
		Random rand = null;
		ArrayList list = null;
		DeptDTO dto = null; // 데이터 타입을 자동생성 하면 import가 자동으로 된다.
	%>
	<h2>중간작업</h2>
	<%
		int num = 100;
	%>
	<!-- 위에는 service메소드의 지역변수로, 아래는 전역변수로 선언 -->
	<h2>2. 선언문</h2>
	<%! int num = 100000; %>
	<%! public void test(){
			System.out.println("test");
		}
	%>
	<h2>3. 표현식</h2> <%-- Sysout 안에 쓸 수 있는것은 다 쓸 수 있다. --%>
	<h4><%= 10000 %></h4>
	<h4><%= 10.5 %></h4>
	<h4><%= "문자열의 길이"+str.length() %></h4>
	<h4><%= new Date().toString() %></h4>
	<h4><%= 100/3 %></h4>
	<h4><%= str.charAt(0) %></h4> <!-- out.print( str.charAt(0) );으로 변환된다 -->
</body>
</html>