/**
 * INTERFACE
 * DBActions
 * Methods that a class can do to access the database
 */

/**
 * @author Raphael Trocino
 * @author Maya 
 * Date: Oct 6 2019
 * Final Project
 */

import java.sql.Connection;
import java.sql.ResultSet;
public interface DBActions {
    /**
     * Adds a tupple to a table
     * Returns true if successful, false otherwise
     * @param conn
     * @return 
     */
    public boolean add(Connection conn);
    /**
     * Retrieves all information in a table
     * Does JOIN function if necessary
     * @param conn
     * @return 
     */
    public ResultSet getTableInfo(Connection conn);
}
