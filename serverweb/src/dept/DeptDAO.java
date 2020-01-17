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
	
	
	
}
