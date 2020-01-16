package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 - 컴파일러에게 알려주기 위해 정보를 압축해 놓은 것
// import javax.servlet.annotation.WebServlet;
// WebServlet클래스 내부에서 이 값을 그대로 읽어서 web.xml에 등록한 것처럼 작동하게 동작
// - 내부에서 XML형태로 만들어진다.
@WebServlet(name = "mypost2", urlPatterns = { "/mypost2.do" })
public class PostFormServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// @서버가 대부분 영어권에서 만들어졌으므로 요청과 응답 모두 한글 인코딩 적용해야 한다!
		request.setCharacterEncoding("euc-kr");
		// test/html과 같이 잘못 쓰면 무슨 내용인지 모르므로 다운받게 된다. 
		response.setContentType("text/html;charset=euc-kr");
		// 일반적으로 성능이 좋은 두가지 I/O 사용
		// 입력 - BufferedReader, 출력 - PrintWriter
		PrintWriter pw = response.getWriter();
		// 요청내용 추출
		String userId = request.getParameter("userId"); // name을 주면 된다.
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String[] item = request.getParameterValues("item");

		// 응답내용을 생성
		pw.print("<html>");
		pw.print("<body>");
		// 한글 깨짐(response 인코딩 안하면)
		pw.print("<h1>고객정보</h1>");
		pw.print("<h3>아이디:"+userId+"</h3>");
		pw.print("<h3>성명:"+userName+"</h3>");
		pw.print("<h3>Favorites:</h3>");
		for (String data : item) {
			pw.print(data +" ");
		}
		pw.print("</body>");
		pw.print("</html>");

	}

}
