package se.member.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.member.model.vo.MemberService;
import se.member.model.vo.MemberVo;

/**
 * Servlet implementation class MyinfoController
 */
@WebServlet("/myinfo")
public class MyinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null;
		if(request.getSession().getAttribute("lgnss") != null) {
			id = ((MemberVo)(request.getSession().getAttribute("lgnss"))).getId();
		}
		if(id != null) {
			request.setAttribute("myinfo", new MemberService().myinfo(id));
			request.getRequestDispatcher("/WEB-INF/myinfo.jsp").forward(request, response);
		}
	}


}
