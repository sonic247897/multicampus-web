package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;	

public class MemberDAO {
	//��ü ��� ���
	public ArrayList<MemberDTO> getMemList() {
		System.out.println("getDeptList() ȣ��");
		ArrayList<MemberDTO> memlist = new ArrayList<MemberDTO>();
		MemberDTO mem = null;
		String sql = "select * from member";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs= null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				mem = new MemberDTO(rs.getString(1),
						 rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6), rs.getInt(7));
				memlist.add(mem);
			}
			System.out.println("dao=>"+memlist.size());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memlist;
		
	}
	
	//������
	public int insert(MemberDTO mem) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="insert into member values(?,?,?,?,?,?,?)";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, mem.getId());
			ptmt.setString(2, mem.getPass());
			ptmt.setString(3, mem.getName());
			ptmt.setString(4, mem.getAddr());
			ptmt.setString(5, mem.getDeptno());
			ptmt.setString(6, mem.getGrade());
			ptmt.setInt(7, mem.getPoint());
			result = ptmt.executeUpdate(); 
			System.out.println("result=>"+result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	
	//��� ����
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="delete from member where id = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
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
	
	// where���� primary key -> ������ ���ڵ� �ϳ� ��� = DTO����
	public MemberDTO read(String id) {
		MemberDTO mem = null;
		String sql = "select * from member where id = ?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs= null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery(); // select����
			if(rs.next()) {
				mem = new MemberDTO(rs.getString(1),
						 rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getString(6), rs.getInt(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return mem;
	}
	
	
}
