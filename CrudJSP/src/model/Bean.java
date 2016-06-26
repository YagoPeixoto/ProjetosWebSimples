package model;

import java.util.List;

import dao.UserDao;

public class Bean {


	public List<User> recuperarAll(User user) {
		UserDao userdao = new UserDao();
		return (List<User>) userdao.recuperarAll();
	}
	
	
	public void atualizar(User user){
		UserDao userdao = new UserDao();
		userdao.atualizar(user);
	}
	
	public void cadastrar(User user){
		UserDao userdao = new UserDao();
		userdao.adiciona(user);
	}
	
	public void excluir(String id){
		UserDao userdao = new UserDao();
		userdao.remove(id);
	}
	
}
