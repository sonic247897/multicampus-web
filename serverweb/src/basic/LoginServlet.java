package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		// 1. 요청정보 추출
		// 깨진거 추출한 후 변환할 수 없다. 추출하기 전에 변환해야 함
		req.setCharacterEncoding("euc-kr");
		// 한글
		String id = req.getParameter("id"); //name을 주면 된다.
		String pass = req.getParameter("pass");
		
		System.out.println("아이디:"+id);
		System.out.println("패스워드:"+pass);
		
	}
}
