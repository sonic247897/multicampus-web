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
		System.out.println("서블릿");
		
		//1. 요청 정보 추출
		//form으로 받지 않고 하이퍼링크로 받아올 때에는 ?deptNo= <-이 부분이 name이다.
		String deptNo = request.getParameter("deptNo");
		System.out.println("deptNo:"+deptNo); 
		
		//2. 비지니스 메소드 call
		DeptDAO dao = new DeptDAO();
		int result = dao.delete(deptNo);
		
		//3. 응답화면 생성
		pw.print("<h1>삭제성공</h1>");
		pw.print("<hr/>");
		pw.print("<h3>"+result+"개 행 삭제 성공</h1>");
		pw.print("<a href='/serverweb/dept/list.do'>목록보기</a>");
		
		
	}
}
