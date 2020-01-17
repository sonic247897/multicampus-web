package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDTO;

@WebServlet(name = "include", urlPatterns = { "/include.do" })
public class IncludeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		pw.println("<h1>include화면</h1>");
		pw.println("<hr/><hr/><hr/><hr/>");
		
		//1. 데이터 공유하기 - request공유
		DeptDTO dept = new DeptDTO("001", "전산실", "", "","");
		//mydata라는 이름으로 dept객체를 공유(아무거나 공유할 수 있다.)
		request.setAttribute("mydata", dept); 
		System.out.println("IncludeServlet 실행완료");
		
		//2. 요청재지정 - forward
		// context path부분을 제외한다.
		RequestDispatcher rd = 
				request.getRequestDispatcher("/jspbasic/subPage.jsp");
		// request를 통째로 넘겨준다.
		rd.include(request, response);
	}

}
