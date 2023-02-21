package se.board.model.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.board.model.vo.BoardService;
import se.board.model.vo.BoardVo;

/**
 * Servlet implementation class BoardaddController
 */
@WebServlet("/boardadd")
public class BoardaddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardaddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/boardadd.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		BoardVo vo = new BoardVo();
		vo.setBoardTitle(request.getParameter("title"));
		vo.setBoardWriter(request.getParameter("writer"));
		vo.setBoardContent(request.getParameter("content"));
		int result = new BoardService().getAddList(vo);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/boardlist");
		} else {
			request.setAttribute("msg", "게시글에 등록 실패하였습니다");
			request.getRequestDispatcher("/WEB-INF/Alertmsg.jsp").forward(request, response);
		}
		
	}

}
