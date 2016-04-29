package ex2LoginComSession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(response, false);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		boolean validacao = loginCheck(usuario, senha);

		if (validacao) {
			HttpSession session = request.getSession(true);
			session.setAttribute("nome", usuario);
			session.setAttribute("senha", senha);
			response.sendRedirect("Administracao");
		} else {
			login(response, false);
		}

	}

	protected void login(HttpServletResponse response, boolean withErrorMessage) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Login</h1>");
		out.println("<form method='post' action='LoginAdmin'>");
		out.println("Nome Usuário:");
		out.println("<input type='text' name='usuario'/> <br>");
		out.println("Senha: ");
		out.println("<input type='password' name='senha'/>");
		if (withErrorMessage) {
			out.println("<p>Informações de Login inválidas</p>");
		}
		out.println("<input type='submit' value='Enviar'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	public boolean loginCheck(String usuario, String senha) throws NullPointerException {

		try {
			return usuario.equals("yago") && senha.equals("123456");

		} catch (Exception e) {
			return false;

		}
	}
}