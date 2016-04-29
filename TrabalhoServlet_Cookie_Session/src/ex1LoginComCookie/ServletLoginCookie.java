package ex1LoginComCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletLoginCookie")
public class ServletLoginCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sendLogin(response, false);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		if (login(nome, senha)) {
			Cookie user = new Cookie("nome", nome);
			Cookie pass = new Cookie("senha", senha);

			response.addCookie(user);
			response.addCookie(pass);

			RequestDispatcher reqDisp = request.getRequestDispatcher("/ServletLoginOK");
			reqDisp.include(request, response);

		} else {
			sendLogin(response, true);

		}
	}

	private boolean login(String nome, String senha) {
		return (nome != null && senha != null) && (!nome.isEmpty() && !senha.isEmpty());

	}

	private void sendLogin(HttpServletResponse response, boolean withErrorMessage)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Login Cookie</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Login</h1>");

		if (withErrorMessage)
			out.println("<h1>Tente novamente</h1>");
		out.println("<form method='post' action='ServletLoginCookie'>");
		out.println("Nome:");
		out.println("<input type='text' name='nome'/> <br>");
		out.println("Senha: ");
		out.println("<input type='password' name='senha'/>");
		out.println("<input type='submit' value='Enviar'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
