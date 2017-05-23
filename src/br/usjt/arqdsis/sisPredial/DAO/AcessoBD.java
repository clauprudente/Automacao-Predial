package br.usjt.arqdsis.sisPredial.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável pela conexão com banco de dados MySQL
 */
public abstract class AcessoBD {
	private static Connection conn;
	// -----------------------------------------------------------
	// Carrega driver JDBC
	//
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// -----------------------------------------------------------
	// Obtém conexão com o banco de dados
	public static Connection getInstance() throws SQLException {
		if (conn == null) {
				conn = DriverManager.getConnection(
						"jdbc:mysql://LocalHost:3306/sysPredial?user=root&password=1234"
				);
		}
		return conn;
	}
}