package br.yago.EX1;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServletGet", urlPatterns = {"/LoginServletGet"})
public class LoginServletGet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login Get</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Login Get</h1>");
        out.println("<form method='post' action='LoginServletGet'>");
        out.println("<label>Usuario:</label>");
        out.println("<input type='text' value='' name='user'/>");
        out.println("<br><label> Senha:</label>");
        out.println("<input type='password' name='senha'/>");
        out.println("<input type='submit' value='Enviar'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");

        if ((user != null && !user.isEmpty() )&& ( senha != null && !senha.isEmpty())){
            response.sendRedirect("/LoginOkGet?user=" + user + "&senha=" + senha);
        }else {
            response.sendRedirect("/LoginErroGet");
        }
    }
}