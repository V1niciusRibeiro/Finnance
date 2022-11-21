package br.com.fiap.fintech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static ConnectionManager instance;
	
	private ConnectionManager() {}
	
	
    public static ConnectionManager getInstance(){
      if (instance == null){
        instance = new ConnectionManager();
      }
      return instance;
    }
    
    public Connection getConnection(){

		Connection conexao = null;
    	
    	try {	
    		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM93383","020803");
			
		} catch (Exception e) {
			System.err.println("Erro ao conectar ao Banco de Dados!");
			e.printStackTrace();
		}
    	
    	return conexao;	
    }
	    
	
}
