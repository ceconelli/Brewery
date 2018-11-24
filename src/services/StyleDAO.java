package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import models.BeerStyle;

/**
 *
 * @author gceconelli
 */
public class StyleDAO {
    
    private Connection _dbConnection;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<BeerStyle> beerStyleList;
    
    public StyleDAO(Connection con){
        this._dbConnection = con;
        this.beerStyleList = new ArrayList<BeerStyle>();
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
    
    
    public ArrayList<BeerStyle> getStyles() throws SQLException{
        String sql = "select * from marca";
        this.beerStyleList.clear();
        this.rs = this.executeSQLquery(sql);
        while(rs.next()){
            this.beerStyleList.add(new BeerStyle(this.rs.getInt("cod_estilo"),this.rs.getString("nm_estilo")));
        }
        Collections.sort(this.beerStyleList,new Comparator<BeerStyle>(){
            public int compare(BeerStyle b1, BeerStyle b2){
                return b1.getBeerStyleCode() - b2.getBeerStyleCode();
            }
        });
        return this.beerStyleList;
    }
    
    
    public int removeStyle(int beerStyleCode) throws SQLException{
        String sql = "delete from estilo where cod_estilo = " + beerStyleCode;
        int dmlResult = this.executeSQLDml(sql);
        this.getStyles();
        return dmlResult;
    }
    
    public boolean addStyle(int beerStyleCode,String beerStyleName) throws SQLException{
        String sql = "INSERT INTO estilo(cod_estilo,nm_estilo) VALUES (" + beerStyleCode + ",'" + beerStyleName + "');";
        System.out.println(sql);
        this.executeSQLDml(sql);
        this.getStyles();
        return this.rs.rowInserted();
    }
    
    public void updateStyle(int beerStyleCode,String newBeerStyleName) throws SQLException {
        String sql = "UPDATE marca SET nm_marca = '" + newBeerStyleName + "' where cod_marca = " + beerStyleCode;
        this.executeSQLDml(sql);
        this.getStyles();
        
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

    public ArrayList<BeerStyle> getBeerStyleList() {
        return beerStyleList;
    }

    public void setBeerStyleList(ArrayList<BeerStyle> beerStyleList) {
        this.beerStyleList = beerStyleList;
    }
    
    
}
