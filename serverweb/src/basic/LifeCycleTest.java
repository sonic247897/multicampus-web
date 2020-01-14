package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTest extends HttpServlet {
	// ��� �޼ҵ� �������̵�..
	public LifeCycleTest() {
		System.out.println("���� ��ü ����...");
	}
	
	public void init() {
		System.out.println("���� ��ü�� �ʱ�ȭ init()...");
	}
	
	// f5 ������ ���񽺸� ��� ȣ��ȴ�.
	public void service(HttpServletRequest req, HttpServletResponse res)
					throws ServletException, IOException{
		System.out.println("Ŭ���̾�Ʈ�� ��û ó�� service()^^..." +req.getMethod());
		//��û����� GET�̸� doGetȣ��, POST�� doPostȣ��
		// getMethod�� GET�̳� POST�� string���� �����Ѵ�.
		if(req.getMethod().equals("GET")) {
			doGet(req, res);
		}
		else {
			doPost(req, res);
		}
	}
	
	public void destroy() {
		System.out.println("���� ��ü �Ҹ�.... destroy().. ");
	}
	
	// service �ּ� ó�� - doGet().. ȣ��� (�θ� service���� get, post ȣ����) 
	// service �ּ� ���� - �������̵� �� ����ȣ�� => sysout�ۿ� ��� doGet ȣ��X 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()....");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()....");
	}
	
	
}
