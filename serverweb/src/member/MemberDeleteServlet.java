package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memDel", urlPatterns = { "/member/delete.do" })
public class MemberDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("������");
		
		//1. ��û ���� ����
		//form���� ���� �ʰ� �����۸�ũ�� �޾ƿ� ������ ?deptNo= <-�� �κ��� name�̴�.
		String id = request.getParameter("id");
		System.out.println("id:"+id); 
		
		//2. �����Ͻ� �޼ҵ� call
		MemberDAO dao = new MemberDAO();
		int result = dao.delete(id);
		
		//3. ����ȭ�� ����
		pw.print("<h1>��������</h1>");
		pw.print("<hr/>");
		pw.print("<h3>"+result+"�� �� ���� ����</h1>");
		pw.print("<a href='/serverweb/member/list.do'>��Ϻ���</a>");
		
		
	}
}