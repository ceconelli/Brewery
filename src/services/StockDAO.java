package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Stock;
/**
 *
 * @author gceconelli
 */
public class StockDAO {
    
    private Connection _dbConnection;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<Stock> stockList;
    
    public StockDAO(Connection con) {
        this._dbConnection = con;
        this.stockList = new ArrayList<Stock>();
//        this.getStockItems();
    }
    
    
}
