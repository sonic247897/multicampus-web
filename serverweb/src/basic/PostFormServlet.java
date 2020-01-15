package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 얘를 바로 실행하면  주소표시줄에 입력해서 접속하는 것이 되므로 get으로 요청하고
// method ="post"로 정의되어 있으므로 ? doGet이 없으므로 405페이지가 뜬다.
public class PostFormServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		// 1. 요청정보 추출
		req.setCharacterEncoding("euc-kr");
		// 한글
		String id = req.getParameter("userId"); //name을 주면 된다.
		String name = req.getParameter("userName");
		String pass = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String[] favorites = req.getParameterValues("item");

		System.out.println("Customer");
		System.out.println("----------------");
		System.out.println("아이디:"+id);
		System.out.println("성명:"+name);
		System.out.println("패스워드:"+pass);
		System.out.println("성별:"+gender);
		System.out.print("Favorites:");
		for (String fav : favorites) {
			System.out.print(fav+" ");
		}
		
	}
}
