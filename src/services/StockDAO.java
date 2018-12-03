package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(this.stockList,new Comparator<Stock>(){
            public int compare(Stock s1, Stock s2){
                return s1.getBeer().getCod_beer() - s2.getBeer().getCod_beer();
            }
        });
        return this.stockList;        
    }

    public Double getAmount(int beerCode) throws SQLException {
        String sql = "SELECT * FROM estoque WHERE cod_cerveja = " + beerCode + "";
        this.rs = Utils.executeSQLquery(this._dbConnection, sql);
        Double amount = null;
        while(this.rs.next())
            amount = this.rs.getDouble("quantidade");
        return amount;
    }
    
    public void updateBeerAmount(int beerCode,double newAmount) throws SQLException {
        String sql = "UPDATE estoque SET quantidade = " + newAmount + " where cod_cerveja = " + beerCode;
        Utils.executeSQLDml(this._dbConnection, sql);
        this.getStockItems();
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
