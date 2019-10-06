/**
 * Payment
 * Creates payment object
 * accesses payment table
 */

/**
 * @author Raphael Trocino
 * @author Maya Asuero
 * Date: Oct 6 2019
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
public class Payment {
    private double finalCharge;
    private double tax;
    private String billNo;
    private LocalDate paymentDate;
    private String customerID;
    private String ownerID;
    
    /**
     * Constructor
     */
    public Payment(){
        this.finalCharge = 0;
        this.tax = 0;
        this.billNo = "";
        this.paymentDate = null;
        this.customerID = "";
        this.ownerID = "";
    }
    
    /**
     * Constructor
     * @param fC
     * @param tax
     * @param billNo
     * @param payDate
     * @param custID
     * @param ownID 
     */
    public Payment(double fC, double tax, String billNo, LocalDate payDate, String custID, String ownID){
        this.finalCharge = fC;
        this.tax = tax;
        this.billNo = billNo;
        this.paymentDate = payDate;
        this.customerID = custID;
        this.ownerID = ownID;
    }
    
    /**
     * Adds to payment table
     * @param conn
     * @return 
     */
    public boolean add(Connection conn) {
        Statement addPayment;

        String newPayment = "INSERT INTO payment (FinalCharge, Tax, BillNo, PaymentDate, CustomerID, OwnerID) VALUES("+this.finalCharge+","+this.tax+",'"+this.billNo+"','"+this.paymentDate+"','"+this.customerID+"','"+this.ownerID+"')";
        try {
                addPayment = conn.createStatement();
                addPayment.executeUpdate(newPayment);
                return true;
        }
        catch(Exception e) {
                e.printStackTrace();
                return false;
        }
    }
    
    /**
     * Retrieves all data from table payment
     * @param conn
     * @return ResultSet
     */
    public ResultSet getTableInfo(Connection conn) {
        try {
            Statement selectStatement = conn.createStatement();
            String select = "SELECT * FROM payment JOIN customer where payment.customerID = customer.customerID ";
            ResultSet rs = selectStatement.executeQuery(select);
            return rs;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
