package br.yago;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Transicao")
public class Transicao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Transicao</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Transicao</h1>");
		out.println("<form method='post' action='Transicao'>");
		out.println("Estilo Musical: <br>");
		out.println("<input type='checkbox' name='estilo' value='rock'/>Rock <br>");
		out.println("<input type='checkbox' name='estilo' value='sertanejo'/>Sertanejo <br>");
		out.println("<input type='checkbox' name='estilo' value='internacional'/>Internacional <br>");
		out.println("<input type='submit' value='Enviar'/><br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] values = request.getParameterValues("estilo");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("CabecalhoHostHTTP");
		
		
		if(values != null){
			int tamanho = values.length;
			out.println("Estilos Selecionados: <br>");
			
			for(int i=0;i<tamanho;i++){
				out.println(values[i]+"<br>");
			}
		}
	}

}