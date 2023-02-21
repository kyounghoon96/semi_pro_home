package se.board.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.board.model.vo.BoardService;
import se.board.model.vo.BoardVo;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/boardupdate")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/boardupdate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		BoardVo vo = new BoardVo();
		vo.setBoardTitle(request.getParameter("title"));
		vo.setBoardWriter(request.getParameter("writer"));
		vo.setBoardContent(request.getParameter("content"));
		
		int result = new BoardService().getUpdateList(vo);
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/boardlist");		
		} else {
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/boardlist");
		}
		
	}

}
