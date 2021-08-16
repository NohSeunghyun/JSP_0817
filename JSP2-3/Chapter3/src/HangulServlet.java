

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HangulServlet
 */
@WebServlet("/hangul")
public class HangulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HangulServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /*
     * get 방식으로 요청이 전송되어올 경우 : 요청 파라미터값이 요청 URL에 붙어서 전송되므로
     * 								클라이언트의 URL Encoding방식과 서버의 URL Encoding방식을 동일하게 지정하기만 하면
     * 								한글이 제대로 처리
     * 								보안이 취약.
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("hangul Process = " + name);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/*
	 * post 방식으로 요청이 전송되어올 경우 : 요청 파라미터값이 요청 body영역에 따로 인코딩되어 넘어오기 때문에
	 * 								URLEncoding 설정 만으로는 한글이 제대로 처리되지 않는다.
	 * 								보안성이 좋다.
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 따라서 requset객체의 setCharacterEncoding메서드를 사용하여
		 * request객체의 body영역의 인코딩 방식을 UTF-8로 변경해줘야한다.
		 */
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("hangul Process = " + name);
	}

}
