package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memInsert", urlPatterns = { "/member/insert.do" })
public class MemberInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("����");
		
		//1. ��û ���� ����
		String deptno = request.getParameter("deptno");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String addr = request.getParameter("addr");
		String point = request.getParameter("point");
		int intPoint = Integer.parseInt(point);
		String grade = request.getParameter("grade");
		MemberDTO mem = new MemberDTO(id, pass, name, addr, deptno, grade, intPoint);
		System.out.println(mem); // toString �������̵�
		
		//2. �����Ͻ� �޼ҵ� call
		MemberDAO dao = new MemberDAO();
		int result = dao.insert(mem);
		
		//3. ������ ����
		request.setAttribute("insertResult", result);
		
		//4. ����ȭ������ ��û ������
		RequestDispatcher rd =
				request.getRequestDispatcher("/member/insertResult.jsp");
		rd.forward(request, response);
	}

}
