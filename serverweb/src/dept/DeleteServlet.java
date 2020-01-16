package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "delete", urlPatterns = { "/dept/delete.do" })
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("����");
		
		//1. ��û ���� ����
		//form���� ���� �ʰ� �����۸�ũ�� �޾ƿ� ������ ?deptNo= <-�� �κ��� name�̴�.
		String deptNo = request.getParameter("deptNo");
		System.out.println("deptNo:"+deptNo); 
		
		//2. �����Ͻ� �޼ҵ� call
		DeptDAO dao = new DeptDAO();
		int result = dao.delete(deptNo);
		
		//3. ����ȭ�� ����
		pw.print("<h1>��������</h1>");
		pw.print("<hr/>");
		pw.print("<h3>"+result+"�� �� ���� ����</h1>");
		pw.print("<a href='/serverweb/dept/list.do'>��Ϻ���</a>");
		
		
	}
}
