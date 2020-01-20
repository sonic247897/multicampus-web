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
		System.out.println("서블릿");
		
		//1. 요청 정보 추출
		String deptno = request.getParameter("deptno");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String addr = request.getParameter("addr");
		String point = request.getParameter("point");
		int intPoint = Integer.parseInt(point);
		String grade = request.getParameter("grade");
		MemberDTO mem = new MemberDTO(id, pass, name, addr, deptno, grade, intPoint);
		System.out.println(mem); // toString 오버라이딩
		
		//2. 비지니스 메소드 call
		MemberDAO dao = new MemberDAO();
		int result = dao.insert(mem);
		
		//3. 데이터 공유
		request.setAttribute("insertResult", result);
		
		//4. 응답화면으로 요청 재지정
		RequestDispatcher rd =
				request.getRequestDispatcher("/member/insertResult.jsp");
		rd.forward(request, response);
	}

}
