/**
 * Harvest
 * Create object harvest
 * Accesses harvest table from DB
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */
import java.time.LocalDate;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class Harvest implements DBActions{
	private String harvestNo;
	private LocalDate harvestDate;
	private String custID;
	
        /**
         * Constructor
         */
	public Harvest(){
		this.harvestNo = "";
		this.harvestDate = null;
		this.custID = "";
	}
	
        /**
         * Constructor
         * @param id Harvest ID
         * @param date Harvest Date
         * @param cust Customer ID
         */
	public Harvest(String id, LocalDate date, String cust) {
		this.harvestNo = id;
		this.harvestDate = date;
		this.custID = cust;
	}
        
        /**
         * Adds to harvest table
         * @param conn connection
         * @return true if successful, false if otherwise
         */
	public boolean add(Connection conn){
		Statement addNewHarvest;
		
		String newHarvest = "INSERT INTO harvest (HarvestNo,HarvestDate,CustomerID) VALUES('"+this.harvestNo+"','"+this.harvestDate+"','"+this.custID+"')";
		try {
			addNewHarvest = conn.createStatement();
			addNewHarvest.executeUpdate(newHarvest);
                        return true;
		}
		catch(Exception e) {
			e.printStackTrace();
                        return false;
		}
	}
        /**
         * Retrieves all info in table
         * @param conn connection
         * @return ResultSet
         */
	public ResultSet getTableInfo(Connection conn) {
            try {
                    Statement selectStatement = conn.createStatement();
                    String select = "SELECT harvestID, harvestDate, customerID FROM harvest JOIN customer where harvest.customerID = customer.customerID";
                    ResultSet rs = selectStatement.executeQuery(select);
                    return rs;
            }
            catch(Exception e) {
                    e.printStackTrace();
                    return null;
            }
	}
}
