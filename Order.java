/**
 * Order
 * Creates order object
 * Accesses orders table from the database
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */

import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
public class Order extends StringToDate implements DBActions{
	private String orderNo;
	private LocalDate dateOrdered;
	private String customerNo;
	
        /**
         * Constructor
         */
	public Order() {
		this.orderNo = "";
		this.dateOrdered = null;
		this.customerNo = "";
	}
	
        /**
         * Constructor
         * @param number order number
         * @param date date ordered
         * @param customerNo customer number
         */
	public Order(String number, LocalDate date, String customerNo) {
		this.orderNo = number;
		this.dateOrdered = date;
		this.customerNo = customerNo;
	}
	
        /**
         * Adds to orders table
         * @param conn
         * @return true if successful, false if otherwise
         */
	public boolean add(Connection conn) {
            Statement addNewOrder;
            String newOrderDetail = "INSERT INTO orders (OrderNo, DateOrdered, CustomerID) VALUES('"+this.orderNo+"','"+this.dateOrdered+"','"+this.customerNo+"')";
            try {
                    addNewOrder = conn.createStatement();
                    addNewOrder.executeUpdate(newOrderDetail);
                    return true;
            }
            catch(Exception e) {
                    return false;
            }
	}
	
	/**
         * Retrieves all info from table
         * @param conn
         * @return ResultSet
         */
	public ResultSet getTableInfo(Connection conn) {
            ResultSet rs = null;
            try {
                Statement selectStatement = conn.createStatement();
                String select = "SELECT * FROM orders JOIN customer ON orders.CustomerID = customer.CustomerID ";
                rs = selectStatement.executeQuery(select);
                return rs;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            return rs;
	}
}