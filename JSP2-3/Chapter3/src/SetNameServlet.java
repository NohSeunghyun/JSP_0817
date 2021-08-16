

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetNameServlet
 */
@WebServlet("/setName")
public class SetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.서버에서 첫번째 요청이면 세션영역 생성
		HttpSession session= request.getSession();
		
		//2.setAttribute()메서드 사용하여 해당 섹션영역에 name이라는 이름으로 "오정원"값을 지정
		session.setAttribute("name", "오정원");
		
		//3.요청에 대한 응답할 때 세션 아이디도 함께 보낸다. (예:응답 + #001(세션아이디))
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>이름저장</h1>");
		
		/*
		 * 4.클라이언트로 보내진 세션아이디는 클라이언트의 쿠키 저장소에 저장 되고
		 * 클라이언트가 다시 요청하면 이 세션아이디가 요청에 같이 전송된다.(예: 요청 + #001(세션아이디))
		 * 
		 * 5. 서버는 요청에 전송되어오는 세션 아이디(예:#001)를 판별하여
		 * 두번째 요청을 한 클라이언트가 첫번째 요청을 한 클라이언트임을 확인할 수 있다.
		 * GetNameservlet.java에서 이어진다.
		 */
	}

}
