<%@page import="model.User"%>
<jsp:useBean id="userBean" class="model.User" scope="page" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:setProperty property="*" name="userBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CrudJSP</title>
</head>
<body>
<h1>CRUD JSP</h1>
	<%
		if (request.getMethod().equalsIgnoreCase("POST")) {
			if (request.getParameter("salvar") != null) {
				userBean.cadastrar();
				System.out.println(userBean.getEmail());
				response.sendRedirect("Crud.jsp");
			}
			if (request.getParameter("mudar") != null) {
				System.out.println(userBean.getId());
				userBean.atualizar();
			}

			if (request.getParameter("excluir") != null) {
				userBean.excluir(request.getParameter("excluir"));
				response.sendRedirect("Crud.jsp");
			}
		}
	%>
	<form action="Crud.jsp" method="post">
		<input type="hidden" name="salvar" value="true"> <label>Nome:</label>
		<input type="text" name="nome" /><br> <label>E-mail:</label> <input
			type="text" name="email" /><br> <label>CPF:</label> <input
			type="text" name="cpf" /><br> <br> <input type="submit"
			value="Salvar">
	</form>
	<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>CPF</th>
			<th>Alterar</th>
			<th>Excluir</th>
		</tr>
		<%
			for (User user : userBean.recuperarAll()) {
		%>

		<tr>
			<td>
				<%
					out.println(user.getId());
				%>
			</td>
			<td>
				<%
					out.println(user.getNome());
				%>
			</td>
			<td>
				<%
					out.println(user.getEmail());
				%>
			</td>
			<td>
				<%
					out.println(user.getCpf());
				%>
			</td>

			<td>
				<form action="Crud.jsp" method="post">
					<input type="hidden" name="atualizar" value="<%=user.getId()%>" />
					<button>Alterar</button>
				</form>
			</td>
			<td>
				<form action="Crud.jsp" method="post">
					<input type="hidden" name="excluir" value="<%=user.getId()%>" />
					<button>Excluir</button>
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>