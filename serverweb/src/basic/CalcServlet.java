package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Calc", urlPatterns = { "/Calc.do" })
public class CalcServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		// @ response��ü�� PrintWriter��ü�� �����ϹǷ� 
		// reponse�� ���ڵ� ������ PrintWriter ����� ���� ����� �Ѵ�. 
		PrintWriter pw = response.getWriter();
		// 1. ��û���� ����
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String method = request.getParameter("method"); // name�� �ָ� �ȴ�.
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// 2. ����Ͻ� �޼ҵ� ȣ��
		CalcLogic logic = new CalcLogic();
		double result = logic.calc(num1, method, num2); //������� ������ ����
		
		// 3. ����ȭ���� ����
		// <html>, <body>�� �����ص� �ȴ�.
		/*pw.print("<html>");
		pw.print("<body>");*/
		pw.print("<h1>�����("+method+")</h1>");
		pw.print("---------------------------------------------------------------<br/>");
		pw.print("<h1>num1�� "+ num1+"�� num2�� "+num2+"�� ������ ����� "+ result+"�Դϴ�.</h1>");

		/*pw.print("</body>");
		pw.print("</html>");*/
	}

}
