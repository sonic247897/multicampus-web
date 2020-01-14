package jdbc.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DBMS�� �����ϴ� �ߺ��� �۾��� ������ Ŭ����
public class DBUtil {
	//1. ����̹��ε��� Ŭ������ �ε��ɶ� ���� �ε��ǵ��� ó��
	//static������� ���α׷��� ���۵ɶ�(Ŭ���� �ε��� ��) static������ �ѹ��� �ö󰣴�.
	// => static{} ���� ��ɹ��� Ŭ������ �ε��� �� �ѹ��� ����Ǵ� �ڵ�
	// 1)static������� �ʱ�ȭ 2)�ڿ��� ���� ����, ���� �ѹ��� �ؾ��� ��
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. Ŀ�ؼ��ϱ� - DBMS�� ���� �Ŀ� ���������� �����ϰ� �ִ� Connection�� ����
	//		��ü���� �ٸ� ���� ���� ���� �ƴϹǷ� static
	public static Connection getConnect() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			// connection�� ������ִ� �޼ҵ�
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	// 3. �ڿ��ݳ� - ResultSet, Statement, Connection��ü ����� ����
	//			=> ������ ��ü�� ������ �� �ֵ��� �޼ҵ带 �����ص� ����.
	// PreparedStatement�� �θ� Ŭ������ Statement�� �����ϸ� �� �� ���� �� �ִ�.
	//									(Statement�� Prepared~)
	public static void close(ResultSet rs, Statement stmt, 
								Connection con) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
