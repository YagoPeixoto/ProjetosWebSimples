package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;	
	
	public static Connection getConnection(){
		
		if(connection == null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/crudJSP", "root", "fdsa4321");
				System.out.println("Conexão realizada");
			}catch (SQLException e){
				System.out.println("Falha em realiazar a conexão");			
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		}
		return connection;
			
	}
}

  
