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

@WebServlet(name = "memlist", urlPatterns = { "/member/list.do" })
public class MemberListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("����");
		
		//1. ��û ���� ����
		
		//2. �����Ͻ� �޼ҵ� call
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memlist = dao.getMemList();
		
		//3. ������ ����
		request.setAttribute("memList", memlist);
		
		//4. ����ȭ������ ��û ������
		RequestDispatcher rd =
				request.getRequestDispatcher("/member/list.jsp");
		rd.forward(request, response);
		
	}
}
