package br.com.joaoclaudioribeiro.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception{
		try {
			//indica driver de comunicação
			Class.forName("com.mysql.jdbc.Driver");
			//conexão ao DB
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3306/DB_EXERCICIO_JAVA";
			return DriverManager.getConnection(url,login,senha);
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
