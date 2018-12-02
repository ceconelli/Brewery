package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Stock;
import utils.Utils;
/**
 *
 * @author gceconelli
 */
public class StockDAO {
    
    private Connection _dbConnection;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<Stock> stockList;
    private BeerDAO beerDAO;
    
    public StockDAO(Connection con,BeerDAO beerDAO) throws SQLException {
        this._dbConnection = con;
        this.stockList = new ArrayList<Stock>();
        this.beerDAO = beerDAO;
        this.getStockItems();
    }
    
    public ArrayList<Stock> getStockItems() throws SQLException{
        String sql = "SELECT * FROM estoque";
        this.stockList.clear();
        this.rs = Utils.executeSQLquery(this._dbConnection,sql);
        while(this.rs.next()){
            this.stockList.add(new Stock(this.beerDAO.getBeerByCode(this.rs.getInt("cod_cerveja")),this.rs.getDouble("quantidade")));
        }
        System.out.println(this.stockList.toString());
        return this.stockList;        
    }

    public Connection getDbConnection() {
        return _dbConnection;
    }

    public void setDbConnection(Connection _dbConnection) {
        this._dbConnection = _dbConnection;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ArrayList<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(ArrayList<Stock> stockList) {
        this.stockList = stockList;
    }

    public BeerDAO getBeerDAO() {
        return beerDAO;
    }

    public void setBeerDAO(BeerDAO beerDAO) {
        this.beerDAO = beerDAO;
    }
    
    
    
}
