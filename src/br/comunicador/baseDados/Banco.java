package br.comunicador.baseDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Cledson Classe responsável por fazer a conexão com banco de dados
 *         ....
 * 
 */

//127.0.0.1:1521:XE;

/*	
* Classe cria a conexão com o banco de Dados 
* 
*/
public abstract class Banco {

	private final String driver = "org.sqlite.JDBC"; // DRIVER SQLITE
	private final String url = "jdbc:sqlite:C:\\Users\\c.santos\\Documents\\Comunicador";

	// método cria conexão ...
	public Connection criaConexao() {
		try {
			// conecta
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url);
			return conn;
		} catch (ClassNotFoundException e) {
  
		} catch (SQLException err) {

		}
		return null;

	}

}
