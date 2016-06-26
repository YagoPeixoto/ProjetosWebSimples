package model;

import java.util.List;

import dao.UserDao;

public class User {
	int id;
	String nome;
	String cpf;
	String email;
	
	public User(){
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String nome, String cpf, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public List<User> recuperarAll() {
		UserDao userdao = new UserDao();
		return userdao.recuperarAll();
	}
	
	public void atualizar(){
		UserDao userdao = new UserDao();
		userdao.atualizar(this);
	}
	
	public void cadastrar(){
		System.out.println("teste2");
		UserDao userdao = new UserDao();
		System.out.println("teste");
		userdao.adiciona(this);
	}
	
	public void excluir(String id){
		UserDao userdao = new UserDao();
		userdao.remove(id);
	}

}
