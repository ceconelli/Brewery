package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Beer;

/**
 *
 * @author gceconelli
 */
public class BeerDAO {
    
    private Connection _dbConnection;
    PreparedStatement pst;
    ResultSet rs;
    
    public BeerDAO(Connection con) throws SQLException{
        this._dbConnection = con;
//        ResultSet rs = this.getBeers();
//        while(rs.next()){
//            System.out.println(rs.getString(2));
//        }
    }
    
    public ResultSet getBeers() throws SQLException{
        ArrayList<Beer> beerList = new ArrayList<Beer>();
        String sql = "select * from cerveja";
        pst = this._dbConnection.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
