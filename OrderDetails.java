/**
 * OrderDetails
 * Creates orderDetail object
 * Accesses order_details in databases
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

public class OrderDetails implements DBActions{
	private String itemNo;
	private String itemName;
	private int quantity;
	private String orderNo;

        /**
         * Constructor
         */
	public OrderDetails() {
		this.itemNo = "";
		this.itemName = "";
		this.quantity = 0;
		this.orderNo = "";
	}
	
        /**Constructor
         * @param num item number
         * @param name item name
         * @param quant quantity
         * @param orderNo order number
         */
	public OrderDetails(String num, String name, int quant, String orderNo) {
		this.itemNo = num;
		this.itemName = name;
		this.quantity = quant;
		this.orderNo = orderNo;
	}
	
        /**
         * Add to order_details table
         * @param conn
         * @return true if successful, false if otherwise
         */
	public boolean add(Connection conn) {
                Statement addNewOrder;
		String newOrder = "INSERT INTO order_details (ItemName, Quantity, ItemNo, OrderNo) VALUES('"+this.itemName+"','"+this.quantity+"','"+this.itemNo+"','"+this.orderNo+"')";
		try {
			addNewOrder = conn.createStatement();
			addNewOrder.executeUpdate(newOrder);
                        return true;
		}
		catch(Exception e) {
                    e.printStackTrace();
                    return false;
		}
	}
	
        /**
         * Retrieves contents of order_details table
         * @param conn
         * @return ResultSet
         */
	public ResultSet getTableInfo(Connection conn) {
		try {
			Statement selectStatement = conn.createStatement();
			String select = "SELECT * FROM order_details";
			ResultSet rs = selectStatement.executeQuery(select);
			return rs;

		}
		catch(Exception e) {
			return null;
		}
	}
}
