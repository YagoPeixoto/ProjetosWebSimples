package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import model.User;

public class Main {

	public static void main(String[] args) throws SQLException {

		// UserDao listadao = new UserDao();

		// ResultSet resultado = listadao.recuperarAll();

		// while (resultado.next()) {
		// System.out.println(resultado.getInt("id") + " " +
		// resultado.getString("nome") + " " + resultado.getString("cpf") + " "
		// + resultado.getString("email"));
		// }

		User user = new User(5, "Bambam", "78903233223", "Birr@jaula.com");
		UserDao userDao = new UserDao();
		userDao.adiciona(user);

		// User user = new User(2 ,"stronda", "21122112211", "brhuehue@birr");
		// UserDao userDao = new UserDao();
		// userDao.atualizar(user);

		// User user = new User(2 ,"stronda", "21122112211", "brhuehue@birr");
		// UserDao userDao = new UserDao();
		// userDao.remove(user);

		// UserDao userDao = new UserDao();
		// User user = userDao.remove(1);;

	}

}
