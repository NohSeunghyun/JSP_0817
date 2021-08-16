

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChoiceDogServlet
 */
@WebServlet("/choiceDog")
public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoiceDogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] dog = request.getParameterValues("dog");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body bgcolor='black'>");
		out.println("<table align='center bgcolor='yellow'>");
		/*
		 * dog배열에는 강아지 이미지 이름들이 저장되어 있으므로
		 * 배열 길이만큼 for문으로 반복하면서 각각의 이미지를 소스로 이미지를 출력
		 */
		out.println("<tr>");
		for (int i = 0 ; i < dog.length ; i++) {
			out.println("<td>");
			out.println("<img src='"+dog[i]+"'>");
			out.println("</td>");
		}
		out.println("</tr>");
		out.println("</table>");		
		out.println("</body>");
		out.println("</html>");
	}

}
