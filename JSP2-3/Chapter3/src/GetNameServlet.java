

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetNameServlet
 */
@WebServlet("/getName")
public class GetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 6.서버는 요청에 전송되어오는 세션 아이디(예:#001)을 판별하여
		 * 두번째 요청을 한 클라이언트가 첫번째 요청을 한 클라이언트임을 확인하여
		 * 기존 생성된 세션 영역객체의 레퍼런스(=주소)를 반환하고
		 */
		HttpSession session = request.getSession();
		/*
		 * 7.getAttribute()메서드를 사용하여 기존 세션 영역에 존재하는name속성값"오정원"을 얻어온다.
		 * 이때, 리턴타입이 Object이므로 String로 캐스팅해서 String변수에 저장한다.
		 */
		String name = (String)session.getAttribute("name");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>name="+name+"</h1>");
	}

}
