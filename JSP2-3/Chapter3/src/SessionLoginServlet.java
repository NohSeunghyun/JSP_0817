

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/sessionLogin")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		//아이디(java)와 비밀번호(java)가 java이면 인증되었다고 가정
		if (id.equals("java") && passwd.equals("java")) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			//request요청을 처리하도록 Dispatcher방식으로 포워딩
			RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
			dispatcher.forward(request, response);
		} else {
			out.println("<script>");
			out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')"); // 주의 : alert(); 세미콜론 찍으면 안됨
			out.println("history.back()");
			out.println("</script>");
		}
	}

}
