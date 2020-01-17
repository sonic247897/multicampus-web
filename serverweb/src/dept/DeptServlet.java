package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "deptinsert", urlPatterns = { "/deptinsert.do" })
public class DeptServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("서블릿");
		
		//1. 요청 정보 추출
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		String loc = request.getParameter("loc");
		String tel = request.getParameter("tel");
		String mgr = request.getParameter("mgr");
		DeptDTO dept = new DeptDTO(deptNo, deptName, loc, tel, mgr);
		System.out.println(dept); // toString 오버라이딩
		
		//2. 비지니스 메소드 call
		DeptDAO dao = new DeptDAO();
		int result = dao.insert(dept);
		
		//3. 응답화면 생성
		/*pw.print("<h1>삽입성공</h1>");
		pw.print("<hr/>");
		pw.print("<h3>"+result+"개 행 삽입 성공</h1>");*/
		
		//3. 응답화면으로 요청 재지정
		//response.sendRedirect("/serverweb/dept/insertResult.html");
		
		//3. 데이터 공유
		request.setAttribute("insertResult", dept);
		
		//4. 응답화면으로 요청 재지정
		RequestDispatcher rd =
				request.getRequestDispatcher("/dept/insertResult.jsp");
		rd.forward(request, response);
	}

}
