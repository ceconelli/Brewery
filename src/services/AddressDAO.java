package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Address;
import models.Client;

/**
 *
 * @author gceconelli
 */
public class AddressDAO {
    
    private Connection _dbConnection;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<Address> addressList;
    private ClientDAO clientDAO;
    
    public AddressDAO(Connection con,ClientDAO clientDAO) throws SQLException{
        this._dbConnection = con;
        this.clientDAO = clientDAO;
        this.addressList = new ArrayList<Address>();
        this.getAddresses();
    }
    
    public ResultSet executeSQLquery(String sql) throws SQLException{
        this.pst = this._dbConnection.prepareStatement(sql);
        this.rs = this.pst.executeQuery();
        return this.rs;
    }
    
    public int executeSQLDml(String sql) throws SQLException{
        try {
            this.pst = this._dbConnection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.pst.executeUpdate();
    }
    
    public ArrayList<Address> getAddresses() throws SQLException{
        String sql = "SELECT * FROM endereco";
        this.addressList.clear();
        this.rs = this.executeSQLquery(sql);
        Client c;
        while(rs.next()){
            if(this.clientDAO.getClient(rs.getString("cod_cliente")) != null){
               this.addressList.add(new Address(rs.getString("cep"),rs.getString("numero"),rs.getString("complemento"),this.clientDAO.getClient(rs.getString("cod_cliente"))));
            }
            
        }
        return this.addressList;
    }
    
    public boolean addAddress(String cep,String number,String complement,Client client) throws SQLException {
        String sql = "INSERT INTO endereco(cod_cliente,cep,numero,complemento) values ('" + client.getCpf() + "','" + cep + "','" + number + "','" + complement + "')";
        try {
            this.executeSQLDml(sql);
            this.getAddresses();
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.rs.rowInserted();
    }
    
    public void updateAddress(String cep,String number,String complement,Client client) throws SQLException {
        Address oldAddress = this.getAddress(client.getCpf());
        String sql = "UPDATE endereco SET cep = '" + cep + "',numero = '" + number + "',complemento = '" + complement + "' WHERE cod_cliente = '" + client.getCpf() + "'";
        this.executeSQLDml(sql);
        this.getAddresses();
    }
    
    public Address getAddress(String cpf){
        for(Address a:this.addressList){
//            System.out.println(a.toString());
            if(a.getClient().getCpf() == cpf){
                return a;
            }
        }
        return null;
    }
}
