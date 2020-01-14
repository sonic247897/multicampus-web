package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {
	
	@Override
	public int insert(MemberDTO user) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="insert into MEMBER values(?,?,?,?,?,sysdate,1000)";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getPass());
			ptmt.setString(3, user.getName());
			ptmt.setString(4, user.getAddr());
			ptmt.setString(5, user.getDeptno());
			result = ptmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="update MEMBER set addr = ? where id = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, addr);
			ptmt.setString(2, id);
			result = ptmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		String sql ="delete MEMBER where id = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			result = ptmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs= null;
		String sql = "select * from MEMBER";
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1),
						 rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getDate(6), rs.getInt(7));
				memberlist.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memberlist;
		
	}

	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs= null;
		String sql = "select * from MEMBER where addr like ?";
		ArrayList<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, "%"+addr+"%");
			rs = ptmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1),
						 rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getDate(6), rs.getInt(7));
				memberlist.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return memberlist;
	}

	@Override
	public MemberDTO login(String id, String pass) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs= null;
		String sql = "select * from MEMBER where id =? and pass =?";
		MemberDTO member = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			rs = ptmt.executeQuery();
			if(rs.next()) {
				member = new MemberDTO(rs.getString(1),
						 rs.getString(2), rs.getString(3), rs.getString(4),
						 rs.getString(5), rs.getDate(6), rs.getInt(7));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return member;
	}

}
