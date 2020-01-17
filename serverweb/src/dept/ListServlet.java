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
		System.out.println("����");
		
		//1. ��û ���� ����
		
		//2. �����Ͻ� �޼ҵ� call
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptDTO> deptlist = dao.getDeptList();
		//pw.print(deptlist);
		
		/*//3. ����ȭ�� ����
		pw.print("<h1>�μ� ��Ϻ���</h1>");
		pw.print("<hr/>");
		pw.print("<table border='1' width='500px'><th>�μ��ڵ�</th><th>�μ���</th><th>�μ���ġ</th><th>��ȭ��ȣ</th><th>������</th><th>����</th>");
		int size = deptlist.size();
		for(int i=0; i<size; ++i) {
			DeptDTO dept = deptlist.get(i);
			pw.print("<tr>");
			pw.print("<td>"+dept.getDeptNo()+"</td>");
			pw.print("<td>"+dept.getDeptName()+"</td>");
			pw.print("<td>"+dept.getLoc()+"</td>");
			pw.print("<td>"+dept.getTel()+"</td>");
			pw.print("<td>"+dept.getMgr()+"</td>");
			// form�±� �ȿ� ���� ����(table�ȿ� ����)�� �����۸�ũ Ŭ�� ���� �� �����ϴ� ���
			pw.print("<td><a href ='/serverweb/dept/delete.do?deptNo="+dept.getDeptNo()+
					"&info=test'>����</a></td>");
			pw.print("</tr>");
		}
		pw.print("</table>");*/
		
		//3. ������ ����
		request.setAttribute("deptList", deptlist);
		
		//4. ����ȭ������ ��û ������
		RequestDispatcher rd =
				request.getRequestDispatcher("/dept/list.jsp");
		rd.forward(request, response);
		
	}
}
