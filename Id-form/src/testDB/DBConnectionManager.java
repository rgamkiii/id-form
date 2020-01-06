package testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {
	
	private Connection conn;
	private Statement stmt;
	private String url;
	private String user;
	private String password;
	
	public DBConnectionManager(String url, String user, String password) 
			throws SQLException {
		this.url = url;
		this.user = user;
		this.password = password;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//conn = DriverManager.getConnection(url, user, password);
			conn = DriverManager.getConnection("jdbc:mysql://localhost/student_project", "root", "");
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("excp en DBC ()");
			throw new SQLException(e);
		}
	}
	
	public void connect() throws SQLException {
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			System.out.println(e);
			System.out.println("excp en DBC connect()");
			throw(e);
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public boolean isConnected() throws SQLException {
		return conn != null;
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public boolean execute(String instruction) throws SQLException {
        return stmt.execute(instruction);
    }

    public int executeUpdate(String instruction) throws SQLException {
        return stmt.executeUpdate(instruction);
    }
	
	public void closeConnection() throws SQLException {
		try {
			conn.close();
		} catch(SQLException e) {
			System.out.println(e);
			throw(e);
		}
	}
}
