package br.yago.EX2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginErrorPost",
            urlPatterns = "/LoginErrorPost")
public class LoginErroPost extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Erro POST</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br><h1>Login Erro POST</h1></br>");
        out.println("<br></br>");
        out.println("<br><h1>Erro ao logar</h1></br>");
        out.println("</body>");
        out.println("</html>");
    }
}
