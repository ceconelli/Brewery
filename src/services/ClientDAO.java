package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import models.Client;

/**
 *
 * @author gceconelli
 */
public class ClientDAO {
    
    private Connection _dbConnection;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<Client> clientList;
    
    public ClientDAO(Connection con) throws SQLException{
        this._dbConnection = con;
        this.clientList = new ArrayList<Client>();
        this.getClients();
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
    
    public ArrayList<Client> getClients() throws SQLException{
        String sql = "select * from cliente";
        this.clientList.clear();
        this.rs = this.executeSQLquery(sql);
        while(rs.next()){
            this.clientList.add(new Client(this.rs.getString("cpf"),this.rs.getString("nome"),this.rs.getString("telefone"),this.rs.getString("email")));
        }
//        Collections.sort(this.clientList,new Comparator<Client>(){
//            public int compare(Client c1, Client c2){
//                return  c1.
//            }
//        });
        return this.clientList;
    }
    
    
    public int removeClient(String clientCpf) throws SQLException{
        String sql = "delete from cliente where cpf = '" + clientCpf + "'";
        int dmlResult = this.executeSQLDml(sql);
        this.getClients();
        return dmlResult;
    }
    
    public boolean addClient(String cpf,String name,String phoneNumber,String email) throws SQLException{
        String sql = "INSERT INTO cliente(cpf,nome,telefone,email) VALUES ('" + cpf + "','" + name + "','" + phoneNumber + "','" + email + "');";
        System.out.println(sql);
        this.executeSQLDml(sql);
        this.getClients();
        return this.rs.rowInserted();
    }
    
    public void updateStyle(int beerStyleCode,String newBeerStyleName) throws SQLException {
        String sql = "UPDATE estilo SET nm_estilo = '" + newBeerStyleName + "' where cod_estilo = " + beerStyleCode;
        this.executeSQLDml(sql);
        this.getClients();
        
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

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }
    
    
}
