package se.member.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import se.member.model.vo.MemberService;
import se.member.model.vo.MemberVo;

/**
 * Servlet implementation class EnrollController
 */
@WebServlet("/enroll")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/enroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setEmail(request.getParameter("email"));
		vo.setUser_name(request.getParameter("user_name"));
		vo.setPhone(request.getParameter("phone"));
		vo.setGender(request.getParameter("gender"));
		vo.setBirth(request.getParameter("birth"));
		vo.setAddress(request.getParameter("address"));
		
		int result = new MemberService().enroll(vo);
		if(result < 1) {
			System.out.println("회원가입 실패");
		} else
			System.out.println("회원가입 성공");
			response.sendRedirect(request.getContextPath() + "/login");
		}		
}
