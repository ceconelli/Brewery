package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import models.Brand;
import java.util.*;

/**
 *
 * @author gceconelli
 */
public class BrandDAO {
    
    private Connection _dbConnection;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<Brand> brandList;
    
    public BrandDAO(Connection con) throws SQLException{
        this._dbConnection = con;
        this.brandList = new ArrayList<Brand>();
        this.getBrands();
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
    
    /*updates brandList*/
    public ArrayList<Brand> getBrands() throws SQLException{
        String sql = "select * from marca";
        this.brandList.clear();
        this.rs = this.executeSQLquery(sql);
        while(rs.next()){
            this.brandList.add(new Brand(this.rs.getInt("cod_marca"),this.rs.getString("nm_marca")));
        }
        Collections.sort(this.brandList,new Comparator<Brand>(){
            public int compare(Brand b1, Brand b2){
                return b1.getBrandCode() - b2.getBrandCode(); 
            }
        });
        return this.brandList;
    }
    
    
    public int removeBrand(int brandCode) throws SQLException{
        String sql = "delete from marca where cod_marca = " + brandCode;
        int dmlResult = this.executeSQLDml(sql);
        this.getBrands();
        return dmlResult;
    }
    
    public boolean addBrand(int brandCode,String brandName) throws SQLException{
        String sql = "INSERT INTO marca(cod_marca,nm_marca) VALUES (" + brandCode + ",'" + brandName + "');";
        System.out.println(sql);
        this.executeSQLDml(sql);
        this.getBrands();
        return this.rs.rowInserted();
    }
    
    public void updateBrand(int brandCode,String newBrandName) throws SQLException {
        String sql = "UPDATE marca SET nm_marca = '" + newBrandName + "' where cod_marca = " + brandCode;
        this.executeSQLDml(sql);
        this.getBrands();
        
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

    public ArrayList<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(ArrayList<Brand> brandList) {
        this.brandList = brandList;
    }
    
    
    
}
