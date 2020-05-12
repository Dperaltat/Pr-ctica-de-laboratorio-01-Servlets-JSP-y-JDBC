package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextJDBC {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/agenda";
	private static final String USER = "root";
	private static final String PASS = "12345.a";
	private static ContextJDBC jdbc1 = null;
	private static ContextJDBC jdbc2 = null;
	private static ContextJDBC jdbc = null;
	private Statement statement = null;

	public ContextJDBC() throws SQLException {
		this.connect();
	}
	
	protected static ContextJDBC getJDBC(){
		if(jdbc == null)
			try {
				jdbc = new ContextJDBC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return jdbc;
	}

	public void connect() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASS);
			this.statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(">>>WARNING (JDBC:connect)...problemas con el driver\n" + e.getMessage());
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:connect)...problemas con la BD\n" + e.getMessage());
		}
	}
	
	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:query): ---" + sql + "---" + e);
		}
		return null;
	}

	public boolean update(String sql) {
		try {
			this.statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBC:update)... actualizacion: ---" + sql + "---" + e);
			return false;
		}
	}
	
	
	protected static ContextJDBC getJDBC1() {
		if (jdbc1 == null) {
			try {
				jdbc1 = new ContextJDBC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jdbc1;

	}
	
	protected static ContextJDBC getJDBC2() {
		if (jdbc2 == null) {
			try {
				jdbc2 = new ContextJDBC();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jdbc2;

	}
	
}
