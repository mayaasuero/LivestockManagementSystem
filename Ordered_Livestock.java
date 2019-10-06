/**
 * Assigns ordered items to livestock in the database
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
public class Ordered_Livestock implements DBActions{
    private String itemNo;
    private String livestockID;
    
    /**
     * Constructor
     */
    public Ordered_Livestock(){
        this.itemNo = "";
        this.livestockID = "";
    }
    
    /**
     * Constructor
     * @param itemNo Item number
     * @param livestockID Livestock number
     */
    public Ordered_Livestock(String itemNo, String livestockID){
        this.itemNo = itemNo;
        this.livestockID = livestockID;
    }
    
    /**
     * Adds the information to the database
     * @param conn connection to the database
     * @return 
     */
    public boolean add(Connection conn){
        Statement addNewOrder;
        String newOrderDetail = "INSERT INTO ordered_livestock VALUES('"+this.itemNo+"','"+this.livestockID+"')";
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
     * Gets the information of the table
     * @param conn connection
     * @return ResultSet
     */
    public ResultSet getTableInfo(Connection conn){
        ResultSet rs = null;
        try {
            Statement selectStatement = conn.createStatement();
            String select = "SELECT * FROM ordered_livestock";
            rs = selectStatement.executeQuery(select);
            return rs;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
