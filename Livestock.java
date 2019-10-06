/**
 * Livestock
 * Creates livestock object
 * Accesses livestock table in db
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.*;
public class Livestock implements DBActions{
	private String livestockID;
	private String type;
	private double unitPrice;
	private String feeds;
	private LocalDate maturityDate;
	private LocalDate scheduledHarvestDate;
	private String batchNo;
	private String harvestNo;
	
        /**
         * Constructor
         */
	public Livestock() {
		this.livestockID ="";
		this.type = "";
		this.unitPrice = 0;
		this.feeds = "";
		this.batchNo = "";
		this.maturityDate = null;
		this.scheduledHarvestDate = null;
		this.harvestNo = "";
	}
	
        /**
         * Constructor
         * @param id Livestock ID
         * @param type Livestock Name
         * @param unitPrice Unit price
         * @param feeds Feeds
         * @param batchNo Batch number
         * @param maturityDate Maturity date
         * @param scheduledHarvestDate Scheduled Harvest Date
         * @param harvestNo Harvest number
         */
	public Livestock(String id, String type, double unitPrice, String feeds, String batchNo, LocalDate maturityDate, LocalDate scheduledHarvestDate, String harvestNo) {
		this.livestockID = id;
		this.type = type;
		this.unitPrice = unitPrice;
		this.feeds = feeds;
		this.batchNo = batchNo;
		this.maturityDate = maturityDate;
		this.scheduledHarvestDate = scheduledHarvestDate;
		this.harvestNo = harvestNo;
	}
	
        /**
         * Adds to livestock table
         * @param conn
         * @return returns true if successful, false if otherwise
         */
	public boolean add(Connection conn) {
		Statement addNewSchedule;			
		String newSchedule = "INSERT INTO livestock VALUES('"+this.type+"','"+this.unitPrice+"','"+this.livestockID+"','"+this.feeds+"','"+this.maturityDate+"','"+this.scheduledHarvestDate+"','"+this.batchNo+"','"+this.harvestNo+"')";
		try {
			addNewSchedule = conn.createStatement();
			addNewSchedule.executeUpdate(newSchedule);
                        return true;
		}
		catch(Exception e) {
			e.printStackTrace();
                        return false;
		}
        }
        
        /**
         * Retrieves all info from table
         * @param conn
         * @return ResultSet of table
         */
	public ResultSet getTableInfo(Connection conn) {
            try {
                    Statement selectStatement = conn.createStatement();
                    String select = "SELECT * FROM livestock JOIN schedule ON livestock.BatchNo = schedule.BatchNo";
                    ResultSet rs = selectStatement.executeQuery(select);
                    return rs;
            }
            catch(Exception e) {
                e.printStackTrace();
                    return null;
            }
	}
}
