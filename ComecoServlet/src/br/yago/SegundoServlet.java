package br.yago;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "SegundoServlet", urlPatterns = { "/SegundoServlet" })
public class SegundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SegundoServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		String user = (String) contexto.getAttribute("user");
		String email = (String) contexto.getAttribute("email");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Segundo Servlet</title>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1> USER:"+ user+"</h1><br>");
		out.println("<h1> E-Mail:"+ email+"</h1>");
		out.println("</body>");
		out.println("</html>");	
	}
}



