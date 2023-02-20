package se.member.model.vo;

import java.sql.Connection;

import se.member.connection.JDBCTemplate;

public class MemberService {
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().login(conn, vo);
		JDBCTemplate.close(conn);		
		return result;		
	}
	
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().enroll(conn, vo);
		JDBCTemplate.close(conn);		
		return result;
	}

	
	public MemberVo myinfo(String id) {
		MemberVo result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().myinfo(conn, id);
		JDBCTemplate.close(conn);	
		return result;
		
	}
}
