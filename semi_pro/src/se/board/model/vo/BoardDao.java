package se.board.model.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import se.member.connection.JDBCTemplate;

public class BoardDao {
	public int getCountBoard(Connection conn) {
		int result = 0;
		String sql = "select count(*) cnt from board";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {				
				result = rs.getInt("cnt");	
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public List<BoardVo> getBoardList(Connection conn){
		List<BoardVo> result = null;
		String sql = "select BOARD_NUM, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, BOARD_DATE from board";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<BoardVo>();
			while(rs.next()){	
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("board_Date"));
				vo.setBoardNum(rs.getInt("board_Num"));
				vo.setBoardTitle(rs.getString("board_Title"));
				vo.setBoardWriter(rs.getString("board_Writer"));				
				result.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	

}
