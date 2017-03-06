package RegisterPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	/*
	 * Required constants for database connections
	 */
	public static final String Driver_Class = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/Assign";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "vinod213";
	public static Connection conn = null;

	public void connection() throws ClassNotFoundException, SQLException {
		Class.forName(Driver_Class);
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

	}

}
