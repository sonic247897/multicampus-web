package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	// 원래 스펙인 protected에서 public으로 바꿔서 선언
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		System.out.println("서블릿 요청....");
	}
}
