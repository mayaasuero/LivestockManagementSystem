/**
 * Connects Java program to MySQL Database
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */

import java.sql.*;
public class DriverConnector {
	public Connection conn;
	private String password;
	/**
	 * Constructor
	 */
	public DriverConnector() {
                this.password = "admin";
		this.conn = connect();
	}
	
	/**
	 * Establish connection
	 * @return Connection
	 */
	public Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
                        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/LivestockManagementSystem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", this.password);
                        System.out.println("Password"+this.password);
			return conn;
		}
		catch(Exception e) {
                        e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the connection to the DB
	 * @return Connection
	 */
	public Connection getConnection(String pass) {
            if(pass.equals(this.password)){
                return connect();
            }
            else{
                return null;
            }
	}
	
	/**
	 * Closes connection after using.
	 */
	public void closeConnection() {
		try {
			this.conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
