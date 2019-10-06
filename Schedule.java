/**
 * Class for Schedule table in DB
 */
/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.time.LocalDate;

public class Schedule extends StringToDate implements DBActions{
	private String batchNo;
	private LocalDate startDate;
	private int period;

	
	/**
	 * Constructor with null value assignments.
	 */
	public Schedule() {
		super();
		this.batchNo = "";
		this.startDate = null;
		this.period = 0;
	}
	
	/**
	 * Constructor
	 * 
	 * @param batchNo batch number
	 * @param startDate start date
	 * @param period period
	 */
	public Schedule(String batchNo, LocalDate startDate, int period) {
		this.batchNo = batchNo;
		this.period = period;
		this.startDate = startDate;
	}

	/**
	 * Adds a new row to the table
	 * @param conn connection to the database
         * @return true if successful, false if otherwise
	 */
	public boolean add(Connection conn) {
		Statement addNewSchedule;

		String newSchedule = "INSERT INTO schedule (schedule.Start_Date, schedule.Period, schedule.BatchNo) VALUES('"+this.startDate+"','"+this.period+"','"+this.batchNo+"')";
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
	 * Retrieves all the info in a table
	 * @param conn the connection to the database
         * @return ResultSet
	 */
	public ResultSet getTableInfo(Connection conn) {
		try {
			Statement selectStatement = conn.createStatement();
			String select = "SELECT schedule.BatchNo, schedule.Start_Date, schedule.Period FROM Schedule";
			ResultSet rs = selectStatement.executeQuery(select);
			return rs;
		}
		catch(Exception e) {
			e.printStackTrace();
                        return null;
		}
	}
}
