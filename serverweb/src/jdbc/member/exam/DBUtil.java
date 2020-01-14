package jdbc.member.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DBMS에 접근하는 중복된 작업을 정의할 클래스
public class DBUtil {
	//1. 드라이버로딩은 클래스가 로딩될때 같이 로딩되도록 처리
	//static멤버들은 프로그램이 시작될때(클래스 로딩될 때) static영역에 한번만 올라간다.
	// => static{} 안의 명령문은 클래스가 로딩될 때 한번만 실행되는 코드
	// 1)static멤버변수 초기화 2)자원에 대한 접속, 설정 한번만 해야할 때
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. 커넥션하기 - DBMS와 접속 후에 접속정보를 저장하고 있는 Connection을 리턴
	//		객체마다 다른 값을 갖는 것이 아니므로 static
	public static Connection getConnect() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			// connection만 만들어주는 메소드
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	// 3. 자원반납 - ResultSet, Statement, Connection객체 사용을 해제
	//			=> 각각의 객체를 해제할 수 있도록 메소드를 정의해도 좋다.
	// PreparedStatement의 부모 클래스인 Statement로 선언하면 둘 다 받을 수 있다.
	//									(Statement와 Prepared~)
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
