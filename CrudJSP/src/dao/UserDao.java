package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import conection.ConnectionFactory;
import model.User;

public class UserDao {

	private Connection connection;

	public UserDao() {
		this.connection = ConnectionFactory.getConnection();
	}

	public List<User> recuperarAll() {
		ResultSet resultado = null;
		List<User> usuarios = new ArrayList<User>();
		String sql = "SELECT * FROM crudJSP.dados";

		try {
			Statement stmt = connection.createStatement();
			resultado = stmt.executeQuery(sql);

			System.out.println("Usuario foi recuperado");

			while (resultado.next()) {
				User usuario = new User();
				usuario.setId(Integer.parseInt(resultado.getString("id")));
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setCpf(resultado.getString("cpf"));

				usuarios.add(usuario);

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return usuarios;
	}

	public void adiciona(User user) {

		String sql = "INSERT INTO crudJSP.dados " + "(nome,cpf,email)" + " VALUES (?,?,?)";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getCpf());
			stmt.setString(3, user.getEmail());
			stmt.execute();
			stmt.close();

			System.out.println("Usuario foi adicionado");

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void atualizar(User user) {

		String sql = "UPDATE crudJSP.dados SET " + "id=?, nome=?, cpf=?, email=? " + "WHERE id=?";

		try {

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setLong(1, user.getId());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getCpf());
			stmt.setString(4, user.getEmail());
			stmt.setLong(5, user.getId());

			stmt.execute();
			stmt.close();

			System.out.println("Usuario atualizado");

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void remove(User user) {

		String sql = "DELETE FROM crudJSP.dados " + "WHERE id=?";

		try {

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setLong(1, user.getId());

			stmt.execute();
			stmt.close();

			System.out.println("Usuario foi removido");

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void remove(String id) {

		String sql = "DELETE FROM crudJSP.dados " + "WHERE id=?";

		try {

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setLong(1, Integer.parseInt(id));

			stmt.execute();
			stmt.close();

			System.out.println("Usuario foi removido");

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
