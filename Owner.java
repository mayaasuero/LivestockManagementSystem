/**
 * Owner
 * Creates Owner object
 * accesses owner table in DB
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Owner implements DBActions{
	private String firstName;
	private String lastName;
	private String companyName;
	private String companyAddress;
	private String id;
	
	/**
	 * Constructor with null values
	 */
	public Owner() {
		this.firstName = "";
		this.lastName = "";
		this.companyAddress = "";
		this.companyName = "";
		this.id = "";
	}
	
	/**
	 * Constructor
	 * @param firstName first name
	 * @param lastName last name
	 * @param companyName company name
	 * @param companyAddress company address
	 * @param id customer ID
	 */
	public Owner(String firstName, String lastName, String companyName, String companyAddress, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyAddress = companyName;
		this.companyName = companyAddress;
		this.id = id;
	}
	
	/**
	 * Adds new owner to DB
	 * @param conn connection to database
         * @return true if successful, false if otherwise
	 */
	public boolean add(Connection conn){ 
            try {
                    String addTupple = "INSERT INTO owner VALUES(?,?,?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(addTupple);
                    stmt.setString(1, this.firstName);
                    stmt.setString(2, this.companyName);
                    stmt.setString(3, this.companyAddress);
                    stmt.setString(4, this.lastName);
                    stmt.setString(5, this.id);
                    int i = stmt.executeUpdate();
                    return true;
            }
            catch(Exception e) {
                    e.printStackTrace();
                    return false;
            }
	}
	
	/**
	 * Retrieves ALL content of OWNER table from the DB and prints it
	 * @param conn
         * @return ResultSet
	 */
	public ResultSet getTableInfo(Connection conn) {
            ResultSet rs = null;
            try {
                Statement selectStatement = conn.createStatement();
                String select = "SELECT * FROM owner";
                rs = selectStatement.executeQuery(select);	
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            return rs;
	}
	
}