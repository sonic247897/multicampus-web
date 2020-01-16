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
		// @ response객체가 PrintWriter객체를 생성하므로 
		// reponse의 인코딩 설정을 PrintWriter 만들기 전에 해줘야 한다. 
		PrintWriter pw = response.getWriter();
		// 1. 요청정보 추출
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String method = request.getParameter("method"); // name을 주면 된다.
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// 2. 비즈니스 메소드 호출
		CalcLogic logic = new CalcLogic();
		double result = logic.calc(num1, method, num2); //계산결과를 저장할 변수
		
		// 3. 응답화면을 생성
		// <html>, <body>는 생략해도 된다.
		/*pw.print("<html>");
		pw.print("<body>");*/
		pw.print("<h1>계산결과("+method+")</h1>");
		pw.print("---------------------------------------------------------------<br/>");
		pw.print("<h1>num1의 "+ num1+"과 num2의 "+num2+"을 연산한 결과는 "+ result+"입니다.</h1>");

		/*pw.print("</body>");
		pw.print("</html>");*/
	}

}
