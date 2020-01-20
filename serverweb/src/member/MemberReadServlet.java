package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memRead", urlPatterns = { "/member/read.do" })
public class MemberReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("����");
		
		//1. ��û ���� ����
		//	-Ŭ���̾�Ʈ�� ���� ���±׿� �Է��� �����͸� �ʿ信 ���ؼ� �ѱ� �Ķ���� ����
		String id = request.getParameter("id");
		System.out.println(id);
		
		//2. �����Ͻ� �޼ҵ� call
		//	-DeptDAOŬ������ �޼ҵ� �߰��ϰ� ȣ���ϱ�
		MemberDAO dao = new MemberDAO();
		MemberDTO mem = dao.read(id);
				
		//3. jsp�� �Ѱ��� ������ �����ϱ�
		request.setAttribute("memInfo", mem);
		
		//4. ��û������(forward) - ������ jsp ��û�ϱ�
		RequestDispatcher rd =
				request.getRequestDispatcher("/member/member_read.jsp");
		rd.forward(request, response);
	}

}
