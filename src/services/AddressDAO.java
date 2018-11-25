package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        this.pst = this._dbConnection.prepareStatement(sql);
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
