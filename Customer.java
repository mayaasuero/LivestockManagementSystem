/**
 * Customer class
 * Creates customer object
 * Add and query to customer table in database
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
public class Customer implements DBActions{
    private String corporateName;
    private String corporateAddress;
    private String customerID;
    private String customerContactNumber;

    /**
     * Constructor 
     * Assigns null values
     */
    public Customer() {
            this.corporateName = "";
            this.corporateAddress = "";
            this.customerID = "";
            this.customerContactNumber = "";
    }

    /**
     * Constructor
     * @param name Name of Customer's Company
     * @param address	Customer's Address
    * @param id		Unique ID Number
    * @param number	Contact Number 
    */
   public Customer(String name, String id, String address, String number){
           this.corporateName = name;
           this.corporateAddress = address;
           this.customerID = id;
           this.customerContactNumber = number;
   }

   /**
    * Adds new customer
    * @param conn	DB Connection
    */
   public boolean add(Connection conn) {
        Statement addNewCustomer;

        String newCustomer = "INSERT INTO customer VALUES('"+this.corporateName+"','"+this.customerID+"','"+this.corporateAddress+"','"+this.customerContactNumber+"')";
             try {
                     addNewCustomer = conn.createStatement();
                     addNewCustomer.executeUpdate(newCustomer);
                     return true;
             }
             catch(Exception e) {
                    e.printStackTrace();
                     return false;
             }
     }

    /**
     * Retrieves ALL info in CUSTOMER table
     * @param conn connection
     */
    public ResultSet getTableInfo(Connection conn) {
        ResultSet rs = null;
        try{
            Statement selectStatement = conn.createStatement();
            String select = "SELECT * FROM customer";
            rs = selectStatement.executeQuery(select);
        }
        catch(Exception e) {
            return null;
        }
        return rs;
    }
}