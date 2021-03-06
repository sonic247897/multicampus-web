package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;	

public class DeptDAO {
	//전체 목록 출력
	public ArrayList<DeptDTO> getDeptList() {
		System.out.println("getDeptList() 호출");
		ArrayList<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		DeptDTO dept = null;
		String sql = "select * from MYDEPT";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs= null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				dept = new DeptDTO(rs.getString(1),
						 rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5));
				deptlist.add(dept);
			}
			System.out.println("dao=>"+deptlist.size());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return deptlist;
		
	}
	
	//부서등록
	public int insert(DeptDTO dept) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="insert into MYDEPT values(?,?,?,?,?)";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dept.getDeptNo());
			ptmt.setString(2, dept.getDeptName());
			ptmt.setString(3, dept.getLoc());
			ptmt.setString(4, dept.getTel());
			ptmt.setString(5, dept.getMgr());
			result = ptmt.executeUpdate(); 
			System.out.println("result=>"+result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	//부서삭제
	public int delete(String deptno) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="delete from MYDEPT where deptno = ?";
		try {
			System.out.println("deptno in delete: "+deptno);
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, deptno);
			result = ptmt.executeUpdate(); 
			System.out.println(sql);
			System.out.println("result=>"+result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	// where절에 primary key -> 무조건 레코드 하나 출력 = DTO매핑
	public DeptDTO read(String deptNo) {
		System.out.println("DeptDTO() 호출");
		DeptDTO dept = null;
		String sql = "select * from MYDEPT where deptNo = ?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs= null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, deptNo);
			rs = ptmt.executeQuery(); // select실행
			// while(rs.next()) -레코드 검색
			// 실행결과를 자바객체로 변환
			//  - 레코드가 여러 개: DTO로 레코드를 변환하고 ArrayList에 add
			//  - 레코드가 한 개: DTO로 레코드 변환
			// 보통 1개인 경우 while보다 if를 사용한다 = 있나?없나?
			if(rs.next()) {
				dept = new DeptDTO(rs.getString(1),
						 rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5));
			}
			System.out.println("dao=>"+dept);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return dept;
	}
	
	
}
