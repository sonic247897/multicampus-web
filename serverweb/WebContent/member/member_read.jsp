<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	MemberDTO mem = (MemberDTO)request.getAttribute("memInfo");
	System.out.println(mem);
	%>

	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/action?id=<%= mem.getId() %>&state=UPDATE" method="POST" 
				name="myform">
				<fieldset>
					<div id="legend">
						<legend>�Ʒ� ����� �ۼ����ּ���.</legend>
					</div>
					<div class="form-group">
						<!-- �μ��ڵ� -->
						<label class="control-label col-sm-2" for="orgcode">�μ��ڵ�</label>
						<div class="col-sm-3">
							<%--���⿡ �μ��ڵ带 ����ϼ��� --%>
							<%= mem.getDeptno() %>
						</div>
					</div>

					
					
					<div class="form-group">
						<!-- ����-->
						<label class="control-label col-sm-2" for="orgname">����</label>
						<div class="col-sm-3">
							<%--���⿡ ������ ����ϼ��� --%>
							<%= mem.getName() %>
						</div>
					</div>
					<div class="form-group">
						<!-- ���-->
						<label class="control-label col-sm-2" for="id">���</label>
						<div class="col-sm-3">
							<%--���⿡ ���(id)�� ����ϼ��� --%>
							<%= mem.getId() %>
						</div>
						<span id="checkVal"></span>
					</div>



				


					
					<div class="form-group">
						<!-- �н�����-->
						<label class="control-label col-sm-2" for="pass">�н�����</label>
						<div class="col-sm-3">
							<%--���⿡ �н����带 ����ϼ��� --%>
							<%= mem.getPass() %>
						</div>
					</div>
					<div class="form-group">
						<!-- �ּ�-->
						<label class="control-label col-sm-2" for="addr">�ּ�</label>
						<div class="col-sm-3">
						<%--���⿡ �ּҸ� ����ϼ��� --%>
						<%= mem.getAddr() %>
						</div>
					</div>
					<div class="form-group">
						<!-- ����Ʈ-->
						<label class="control-label col-sm-2" for="point">����Ʈ</label>
						<div class="col-sm-3">
						<%--���⿡ ����Ʈ�� ����ϼ��� --%>
						<%= mem.getPoint()%>
						</div>
					</div>
					<div class="form-group">
						<!-- ���-->
						<label class="control-label col-sm-2" for="grade">���</label>
						<div class="col-sm-3">
							<%--���⿡ ����� ����ϼ��� --%>
							<%= mem.getGrade() %>
						</div>
					</div>
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="�����ϱ�" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>