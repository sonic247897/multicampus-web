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
		System.out.println("서블릿");
		
		//1. 요청 정보 추출
		//	-클라이언트가 직접 폼태그에 입력한 데이터를 필요에 의해서 넘긴 파라미터 추출
		String id = request.getParameter("id");
		System.out.println(id);
		
		//2. 비지니스 메소드 call
		//	-DeptDAO클래스에 메소드 추가하고 호출하기
		MemberDAO dao = new MemberDAO();
		MemberDTO mem = dao.read(id);
				
		//3. jsp로 넘겨줄 데이터 공유하기
		request.setAttribute("memInfo", mem);
		
		//4. 요청재지정(forward) - 응답할 jsp 요청하기
		RequestDispatcher rd =
				request.getRequestDispatcher("/member/member_read.jsp");
		rd.forward(request, response);
	}

}
