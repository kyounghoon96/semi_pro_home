package se.board.model.vo;

import java.sql.Connection;
import java.util.List;

import se.member.connection.JDBCTemplate;

public class BoardService {
	public List<BoardVo> getBoardList(){
		List<BoardVo> result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardList(conn);		
		JDBCTemplate.close(conn);
		return result;		
	}
	
	public int getCountBoard() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getCountBoard(conn);		
		JDBCTemplate.close(conn);		
		return result;	
		
	}

	public int getAddList(BoardVo vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getAddList(conn, vo);		
		JDBCTemplate.close(conn);		
		return result;	
	}
	
	public int getUpdateList(BoardVo vo) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getUpdateList(conn, vo);		
		JDBCTemplate.close(conn);			
		return result;
	}
	
	public BoardVo getBoardCheck(BoardVo vo) {
		BoardVo result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardCheck(conn, vo);		
		JDBCTemplate.close(conn);		
		return result;
	}

}
