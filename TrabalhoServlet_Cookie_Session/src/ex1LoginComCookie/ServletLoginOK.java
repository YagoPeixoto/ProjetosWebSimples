package ex1LoginComCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ServletLoginOK")
public class ServletLoginOK extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        if (nome == null || senha == null) {
            RequestDispatcher reqDisp = request.getRequestDispatcher("/LoginCookieServlet");
            reqDisp.include(request, response);
            
        }else {
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login OK</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login OK</h1>");
            out.println("<h2> Usuario:" + nome + "</h2>");
            out.println("<h2> Senha:" + senha + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
        
 }
}
