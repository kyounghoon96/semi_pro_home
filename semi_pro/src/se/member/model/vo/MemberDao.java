package se.member.model.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import se.member.connection.JDBCTemplate;

public class MemberDao {
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
		
		String query = "select id, pw from client_member where id= ? and pw = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberVo();
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		System.out.println("result : " + result);
		return result;		
	}
	
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		
		String query = "insert into client_member values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getUser_name());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getBirth());
			pstmt.setString(8, vo.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public MemberVo myinfo(Connection conn, String id) {
		MemberVo result = null;
		String query = "select * from client_member where id= ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberVo();
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setEmail(rs.getString("email"));
				result.setUser_name(rs.getString("user_name"));
				result.setPhone(rs.getString("phone"));
				result.setGender(rs.getString("gender"));
				result.setBirth(rs.getString("birth"));
				result.setAddress(rs.getString("address"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}		
		return result;
	}
	
}
