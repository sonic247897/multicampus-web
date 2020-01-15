package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �긦 �ٷ� �����ϸ�  �ּ�ǥ���ٿ� �Է��ؼ� �����ϴ� ���� �ǹǷ� get���� ��û�ϰ�
// method ="post"�� ���ǵǾ� �����Ƿ� ? doGet�� �����Ƿ� 405�������� ���.
public class PostFormServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		// 1. ��û���� ����
		req.setCharacterEncoding("euc-kr");
		// �ѱ�
		String id = req.getParameter("userId"); //name�� �ָ� �ȴ�.
		String name = req.getParameter("userName");
		String pass = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String[] favorites = req.getParameterValues("item");

		System.out.println("Customer");
		System.out.println("----------------");
		System.out.println("���̵�:"+id);
		System.out.println("����:"+name);
		System.out.println("�н�����:"+pass);
		System.out.println("����:"+gender);
		System.out.print("Favorites:");
		for (String fav : favorites) {
			System.out.print(fav+" ");
		}
		
	}
}
