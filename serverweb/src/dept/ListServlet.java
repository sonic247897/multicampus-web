package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "list", urlPatterns = { "/dept/list.do" })
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		System.out.println("서블릿");
		
		//1. 요청 정보 추출
		
		//2. 비지니스 메소드 call
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptDTO> deptlist = dao.getDeptList();
		//pw.print(deptlist);
		
		/*//3. 응답화면 생성
		pw.print("<h1>부서 목록보기</h1>");
		pw.print("<hr/>");
		pw.print("<table border='1' width='500px'><th>부서코드</th><th>부서명</th><th>부서위치</th><th>전화번호</th><th>관리자</th><th>삭제</th>");
		int size = deptlist.size();
		for(int i=0; i<size; ++i) {
			DeptDTO dept = deptlist.get(i);
			pw.print("<tr>");
			pw.print("<td>"+dept.getDeptNo()+"</td>");
			pw.print("<td>"+dept.getDeptName()+"</td>");
			pw.print("<td>"+dept.getLoc()+"</td>");
			pw.print("<td>"+dept.getTel()+"</td>");
			pw.print("<td>"+dept.getMgr()+"</td>");
			// form태그 안에 없는 값들(table안에 있음)을 하이퍼링크 클릭 했을 때 전송하는 방법
			pw.print("<td><a href ='/serverweb/dept/delete.do?deptNo="+dept.getDeptNo()+
					"&info=test'>삭제</a></td>");
			pw.print("</tr>");
		}
		pw.print("</table>");*/
		
		//3. 데이터 공유
		request.setAttribute("deptList", deptlist);
		
		//4. 응답화면으로 요청 재지정
		RequestDispatcher rd =
				request.getRequestDispatcher("/dept/list.jsp");
		rd.forward(request, response);
		
	}
}
