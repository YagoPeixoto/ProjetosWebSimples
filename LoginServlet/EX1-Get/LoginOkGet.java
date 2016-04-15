package br.yago.EX1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginOkGet",
        urlPatterns = {"/LoginOkGet"})
public class LoginOkGet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String senha = request.getParameter("senha");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login Get</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Login Get</h1>");
        out.println("<h2>Usuario:"+user+"</h2>");
        out.println("<h2>Senha:"+senha+"</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}