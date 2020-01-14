package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTest extends HttpServlet {
	// 모든 메소드 오버라이딩..
	public LifeCycleTest() {
		System.out.println("서블릿 객체 생성...");
	}
	
	public void init() {
		System.out.println("서블릿 객체의 초기화 init()...");
	}
	
	// f5 누르면 서비스만 계속 호출된다.
	public void service(HttpServletRequest req, HttpServletResponse res)
					throws ServletException, IOException{
		System.out.println("클라이언트의 요청 처리 service()^^..." +req.getMethod());
		//요청방식이 GET이면 doGet호출, POST면 doPost호출
		// getMethod는 GET이나 POST를 string으로 리턴한다.
		if(req.getMethod().equals("GET")) {
			doGet(req, res);
		}
		else {
			doPost(req, res);
		}
	}
	
	public void destroy() {
		System.out.println("서블릿 객체 소멸.... destroy().. ");
	}
	
	// service 주석 처리 - doGet().. 호출됨 (부모 service에서 get, post 호출함) 
	// service 주석 해제 - 오버라이딩 된 서비스호출 => sysout밖에 없어서 doGet 호출X 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()....");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()....");
	}
	
	
}
