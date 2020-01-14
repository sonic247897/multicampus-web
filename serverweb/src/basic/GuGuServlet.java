package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuGuServlet extends HttpServlet{
	// HttpServlet의 service메소드를 오버라이딩할 때 접근제어자를 protected에서 public으로 바꿔준다.
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		for(int i=1; i<=9; ++i) {
			System.out.println("7 * " + i + " = " + 7*i);
		}
	}
}
