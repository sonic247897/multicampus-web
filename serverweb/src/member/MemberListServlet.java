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
		System.out.println("서블릿");
		
		//1. 요청 정보 추출
		
		//2. 비지니스 메소드 call
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memlist = dao.getMemList();
		
		//3. 데이터 공유
		request.setAttribute("memList", memlist);
		
		//4. 응답화면으로 요청 재지정
		RequestDispatcher rd =
				request.getRequestDispatcher("/member/list.jsp");
		rd.forward(request, response);
		
	}
}
