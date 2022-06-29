package examples;

import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.catalina.ssi.SSICommand;

/**
 * Servlet implementation class LifecycleServlet
 */

public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//	없으니까 처음으로 생성됨
    public LifecycleServlet() {
        super();
        System.out.println("servlet made!");        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//    초기화 한 번 실행
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init on!");
	}

	/**
	 * @see Servlet#destroy()
	 */
//	서블릿이 수정되면 파괴됨
	public void destroy() {
		System.out.println("destroy on!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/first/LifecycleServlet'>");
		out.println("name: <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	새로고침하면 다시 호출됨
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service on!");
//	}

}
