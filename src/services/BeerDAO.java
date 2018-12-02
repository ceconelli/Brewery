package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Beer;
import models.BeerStyle;
import utils.Utils;


public class BeerDAO {
    
    private Connection _dbConnection;
    PreparedStatement pst;
    ResultSet rs;
    private ArrayList<Beer> beerList;
    private BrandDAO brandDAO;
    private StyleDAO styleDAO;
    
    public BeerDAO(Connection con,BrandDAO brandDAO,StyleDAO styleDAO) throws SQLException{
        this._dbConnection = con;
        this.beerList = new ArrayList<Beer>();
        this.brandDAO = brandDAO;
        this.styleDAO = styleDAO;
        this.getBeers();
    }
    
    public ResultSet executeSQLquery(String sql) throws SQLException{
        this.pst = this._dbConnection.prepareStatement(sql);
        this.rs = this.pst.executeQuery();
        return this.rs;
    }
    
    public int executeSQLDml(String sql) throws SQLException{
        this.pst = this._dbConnection.prepareStatement(sql);
        return this.pst.executeUpdate();
    }
    
    public ArrayList<Beer> getBeers() throws SQLException{
        ArrayList<Beer> beerList = new ArrayList<Beer>();
        String sql = "select * from cerveja";
        this.beerList.clear();
        this.rs = this.executeSQLquery(sql);
        while(rs.next()){
            this.beerList.add(new Beer(this.rs.getInt("cod_cerveja"),this.rs.getDouble("graduacao"),this.rs.getDouble("preco"),this.brandDAO.getBrandByCode(this.rs.getInt("cod_marca")),this.styleDAO.getStyleByCode(this.rs.getInt("cod_estilo"))));
        }
        System.out.println(this.beerList.toString());
        return beerList;
    }
    
    public int addBeer(int brandCode,int styleCode,double alcoholContent,double price) {
        String sql = "INSERT INTO cerveja(cod_marca,cod_estilo,graduacao,preco)"
                + " VALUES (" + brandCode + "," + styleCode + "," + alcoholContent + "," + price + ")";
        
        try {
            int i = Utils.executeSQLDml(this._dbConnection, sql);
            this.getBeers();
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(BeerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Beer getBeerByCode(int beerCode){
        for(Beer beer:this.beerList){
            if (beer.getCod_beer() == beerCode) {
                return beer;
            }
        }
        return null;
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

    public ArrayList<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(ArrayList<Beer> beerList) {
        this.beerList = beerList;
    }

    public BrandDAO getBrandDAO() {
        return brandDAO;
    }

    public void setBrandDAO(BrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    public StyleDAO getStyleDAO() {
        return styleDAO;
    }

    public void setStyleDAO(StyleDAO styleDAO) {
        this.styleDAO = styleDAO;
    }
    
    
}
