package br.yago.EX2;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginPostServlet",
        urlPatterns = "/LoginPostServlet")
public class LoginPostServlet extends javax.servlet.http.HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login Servlet Post</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Login Post</h1>");
        out.println("<form method='post' action='LoginPostServlet'>");
        out.println("<label>Nome:</label>");
        out.println("<input type='text' value='' name='user'>");
        out.println("<label>Senha:</label>");
        out.println("<input type='password' value='' name='senha'>");
        out.println("<input type='submit' value='Enviar'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");

        if ((user != null && !user.isEmpty() )&& ( senha != null && !senha.isEmpty())){
               RequestDispatcher rd = request.getRequestDispatcher("/LoginOkPost");
               rd.include(request, response);
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("/LoginErrorPost");
            rd.include(request, response);
        }
    }
}

