package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public static void executeProc(Connection _dbConnection,String sql) throws SQLException{
        Statement statement = _dbConnection.createStatement();
        CallableStatement ps=_dbConnection.prepareCall(sql);
        ps.executeQuery();
    }
    
    
    public static boolean validateCPF(String cpf){
        return (cpf.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})"));
    }
    
    public static boolean validateEmail(String email){
        return email.matches("^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.([a-z]+))?$");
    }
}
