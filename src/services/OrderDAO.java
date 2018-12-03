package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Order;
import utils.Utils;

/**
 *
 * @author gceconelli
 */
public class OrderDAO {

    private Connection _dbConnection;
    private PreparedStatement pst;
    private ResultSet rs;
    private ArrayList<Order> orderList;
    private ArrayList<Order> clientOrders;
    private ClientDAO clientDAO;
    private BeerDAO beerDAO;
    
    public OrderDAO(Connection con,ClientDAO clientDAO,BeerDAO beerDAO) throws SQLException{
        this._dbConnection = con;
        this.orderList = new ArrayList<Order>();
        this.clientOrders = new ArrayList<Order>();
        this.clientDAO = clientDAO;
        this.beerDAO = beerDAO;
        this.getOrders();
    }
    
    public void addToOrderList(ResultSet rs,ArrayList<Order> list) throws SQLException {
        while(rs.next()){
            list.add(new Order(this.clientDAO.getClient(this.rs.getString("cod_cliente")),
                                         this.beerDAO.getBeerByCode(this.rs.getInt("cod_cerveja")),
                                         this.rs.getDouble("quantidade"),
                                         this.rs.getDouble("valor_pedido"),
                                         this.rs.getDate("data_pedido"),
                                         this.rs.getString("entrega"),
                                         this.rs.getInt("cod_pedido")
                                        ));
        }
    }
    
    public ArrayList<Order> getOrders() throws SQLException{
        String sql = "select * from pedido";
        this.orderList.clear();
        this.rs = Utils.executeSQLquery(this._dbConnection, sql);
        this.addToOrderList(this.rs, this.orderList);
        return this.orderList;
    }
    
    public ArrayList<Order> getOrdersFrom(String cpf) throws SQLException {
        String sql = "select * from pedido where cod_cliente = '" + cpf + "'";
        this.clientOrders.clear();
        this.rs = Utils.executeSQLquery(this._dbConnection, sql);
        this.addToOrderList(this.rs,this.clientOrders);
        return this.clientOrders;
    }
    
    public ArrayList<Order> getOrdersOf(int beerCode) throws SQLException {
        String sql = "select * from pedido where cod_cerveja = " + beerCode + "";
        this.clientOrders.clear();
        this.rs = Utils.executeSQLquery(this._dbConnection, sql);
        this.addToOrderList(this.rs,this.clientOrders);
        return this.clientOrders;
    }

    public void addOrder(String clientCode,int beerCode,double amount) {
        double orderCost = amount * this.beerDAO.getBeerByCode(beerCode).getPrice();
//        String sql = "INSERT INTO pedido(cod_cliente,cod_cerveja,quantidade,valor_pedido)"
//                + "VALUES ('" + clientCode + "'," + beerCode + "," + amount + "," + orderCost + ")";
        String sql = "SELECT addPedido('" + clientCode + "'," + beerCode + "," + amount + "," + orderCost + ")";
        try {
//            Utils.executeSQLDml(_dbConnection, sql);
            Utils.executeProc(this._dbConnection, sql);
            this.getOrders();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateOrder(int orderCode,String newStatus) {
        String sql = "UPDATE pedido SET entrega = '" + newStatus + "' where cod_pedido = " + orderCode + "";
        try {
            Utils.executeSQLDml(this._dbConnection, sql);
            this.getOrders();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public BeerDAO getBeerDAO() {
        return beerDAO;
    }

    public void setBeerDAO(BeerDAO beerDAO) {
        this.beerDAO = beerDAO;
    }
    
    
}
