package br.yago;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="PrimeiroServlet",
		urlPatterns = {"/primeiro", "/helloworld"},
		initParams= {
				@WebInitParam(name="user",value="Yago"),
				@WebInitParam(name="email",value="asdf1234yago@gmail.com")	
		}
		)
public class CicloVida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	private int contador;
	
	public CicloVida(){
		
	}
	
	public void init(ServletConfig config) throws ServletException{
		System.out.println("inicializando...");
		String user = config.getInitParameter("user");
		String email = config.getInitParameter("email");
		
		System.out.println(user);
		System.out.println(email);
	}
	public void destroy(){
		System.out.println("Finalizando...Contador:"+contador);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Atendendo Requisiçoes"+ contador++);
	}

}
