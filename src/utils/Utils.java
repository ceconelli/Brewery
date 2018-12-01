package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gceconelli
 */
public final class Utils {

    public static ResultSet executeSQLquery(Connection _dbConnection,String sql) throws SQLException{
        PreparedStatement pst = _dbConnection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
    
    public static int executeSQLDml(Connection _dbConnection,String sql) throws SQLException{
        PreparedStatement pst = _dbConnection.prepareStatement(sql);
        return pst.executeUpdate();
    }
    
}
