package ex2LoginComSession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Administracao")
public class Administracao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Administracao() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

	String usuario = (String) session.getAttribute("nome");
		String senha = (String) session.getAttribute("senha");

		boolean verificado = loginCheck(usuario, senha);

		if (verificado == true) {
			adminPage(response, usuario);
		} else {

			response.sendRedirect("LoginAdmin");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void adminPage(HttpServletResponse response, String usuario)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href=Logout><p>Sair</p></a>");
		out.println("<h1>Voce Logou</h1>");
		out.println("Usuario: " + usuario);
		out.println("</body>");
		out.println("</html>");

	}
	
	public boolean loginCheck(String usuario, String senha)
			throws NullPointerException{
		try {
			return usuario.equals("yago") && senha.equals("123456");
		} catch (Exception e) {
			return false;
		}
	}
}