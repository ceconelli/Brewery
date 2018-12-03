package views;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Address;
import models.Beer;
import models.BeerStyle;
import models.Brand;
import models.Client;
import models.Order;
import models.Stock;
import services.BeerDAO;
import services.DBConnetion;
//import net.proteanit.sql.DbUtils;
import services.AddressDAO;
import services.BrandDAO;
import services.ClientDAO;
import services.OrderDAO;
import services.StockDAO;
import services.StyleDAO;
/**
 *
 * @author gceconelli
 */
public class MainFrame extends javax.swing.JFrame {

    Connection dbConnection;
    BeerDAO beerDAO;
    BrandDAO brandDAO;
    StyleDAO styleDAO;
    ClientDAO clientDAO;
    AddressDAO addressDAO;
    StockDAO stockDAO;
    OrderDAO orderDAO;
    Client selectedClient;
    
    
    public MainFrame(Connection con,BeerDAO beerDAO,BrandDAO brandDAO,StyleDAO styleDAO,ClientDAO clientDAO,AddressDAO addressDAO,StockDAO stockDAO,OrderDAO orderDAO) throws SQLException {
        initComponents();
        this.setLocation(400, 200);
        this.dbConnection = con;
        this.beerDAO = beerDAO;
        this.brandDAO = brandDAO;
        this.styleDAO = styleDAO;
        this.clientDAO = clientDAO;
        this.addressDAO = addressDAO;
        this.stockDAO = stockDAO;
        this.orderDAO = orderDAO;
        
        this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
        this.FillStyleTable(this.styleDAO.getBeerStyleList());
        this.FillClientTable(this.clientDAO.getClientList());
        this.FillBeerTable(this.stockDAO.getStockList());
        this.FillBrandComboBox(this.brandDAO.getBrandList());
        this.FillStyleComboBox(this.styleDAO.getBeerStyleList());
        this.FillAllOrdersTable(this.orderDAO.getOrderList());
        
        this.brands_table.setDefaultEditor(Object.class, null);
        this.beers_table.setDefaultEditor(Object.class, null);
        this.styles_table.setDefaultEditor(Object.class, null);
        this.clients_table.setDefaultEditor(Object.class, null);

        this.selectedClient = null;
//        this.beers_table.set
                
    }
    
    public void FillBrandComboBox(ArrayList<Brand> brandList){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Brand brand:brandList){
            model.addElement(brand.getBrandName());
        }
        this.addBrand_cb.setModel(model);
    }
    
    public void FillStyleComboBox(ArrayList<BeerStyle> styleList){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(BeerStyle style:styleList){
            model.addElement(style.getBeerStyleName());
        }
        this.addStyle_cb.setModel(model);
    }
    
    
    public void FillBrandTable(ArrayList<Brand> brandList,JTable table){
        this.brands_table.setModel(new DefaultTableModel());
        String col[] = {"cod_marca","nm_marca"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        this.brands_table.setModel(tableModel);
        for(Brand brand:brandList){
            System.out.println(brand.toString());
            Object[] row = {brand.getBrandCode(),brand.getBrandName()};
            tableModel.addRow(row);
        }
    }
    
    public void FillStyleTable(ArrayList<BeerStyle> styleList){
        this.styles_table.setModel(new DefaultTableModel());
        String col[] = {"cod_estilo","nm_estilo"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        this.styles_table.setModel(tableModel);
        for(BeerStyle style:styleList){
            System.out.println(style.toString());
            Object[] row = {style.getBeerStyleCode(),style.getBeerStyleName()};
            tableModel.addRow(row);
        }
    }
    
    public void FillBeerTable(ArrayList<Stock> stockList) {
        this.beers_table.setModel(new DefaultTableModel());
        String col[] = {"cod_cerveja","nm_marca","nm_estilo","graduacao","preco","quantidade"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        this.beers_table.setModel(tableModel);
        for(Stock stock:stockList){
            Object[] row = {stock.getBeer().getCod_beer(),stock.getBeer().getBrand().getBrandName(),stock.getBeer().getStyle().getBeerStyleName(),stock.getBeer().getAlcohol_content(),stock.getBeer().getPrice(),stock.getAmount()};
            tableModel.addRow(row);
        }
    }
    
    public void FillClientTable(ArrayList<Client> clientList){
        this.clients_table.setModel(new DefaultTableModel());
        String col[] = {"cpf","nome","telefone","email"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        this.clients_table.setModel(tableModel);
        for(Client client:clientList){
            System.out.println(client.toString());
            Object[] row = {client.getCpf(),client.getName(),client.getPhoneNumber(),client.getEmail()};
            tableModel.addRow(row);
        }
    }
    
    public void FillAllOrdersTable(ArrayList<Order> allOrders){
        this.allOrders_table.setModel(new DefaultTableModel());
        String col[] = {"cod_cliente","cod_cerveja","quantidade","valor_pedido","data_pedido","entrega","cod_pedido"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        this.allOrders_table.setModel(tableModel);
        for(Order order:allOrders){
            Object[] row = {order.getClient().getCpf(),order.getBeer().getCod_beer(),order.getAmount(),order.getPrice(),order.getDate(),order.isDelivered(),order.getOrderCode()};
            tableModel.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame2 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        brands_table = new javax.swing.JTable();
        remove_btn = new javax.swing.JButton();
        addBrand_btn = new javax.swing.JButton();
        brandName_txtField = new javax.swing.JTextField();
        edit_btn = new javax.swing.JButton();
        editBrandName_txtField = new javax.swing.JTextField();
        editBrandCode_txtField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        styles_table = new javax.swing.JTable();
        addStyle_btn = new javax.swing.JButton();
        styleName_txtField = new javax.swing.JTextField();
        removeStyle_btn = new javax.swing.JButton();
        editStyle_btn = new javax.swing.JButton();
        editStyleName_txtField = new javax.swing.JTextField();
        editStyleCode_txtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        clients_table = new javax.swing.JTable();
        addClient_btn = new javax.swing.JButton();
        addClientEmail_txtField = new javax.swing.JTextField();
        addClientPhone_txtField = new javax.swing.JTextField();
        addClientName_txtField = new javax.swing.JTextField();
        addClientCpf_txtField = new javax.swing.JTextField();
        removeClient_btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cep_txtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        numberAddress_txtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        complement_txtField = new javax.swing.JTextField();
        addEditAddress_btn = new javax.swing.JButton();
        removeAddress_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        getClientOrders_btn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        beers_table = new javax.swing.JTable();
        addBrand_cb = new javax.swing.JComboBox<>();
        addStyle_cb = new javax.swing.JComboBox<>();
        addAlcoholContent_txtField = new javax.swing.JTextField();
        addPrice_txtField = new javax.swing.JTextField();
        addBeer_btn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        setAmount_txtField = new javax.swing.JTextField();
        setAmount_btn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        addOrderCPF_txtField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addOrderBeer_txtField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        addOrderAmount_txtField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        addOrder_btn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        allOrders_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame2.setVisible(true);

        brands_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "cod_marca", "nm_marca"
            }
        ));
        brands_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                brands_tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(brands_table);

        remove_btn.setText("Remove");
        remove_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                remove_btnMouseReleased(evt);
            }
        });

        addBrand_btn.setText("Add");
        addBrand_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addBrand_btnMouseReleased(evt);
            }
        });

        edit_btn.setText("Edit");
        edit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                edit_btnMouseReleased(evt);
            }
        });

        jLabel5.setText("Nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 415, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(brandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addBrand_btn)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editBrandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editBrandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edit_btn)
                .addGap(18, 18, 18)
                .addComponent(remove_btn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBrand_btn)
                    .addComponent(brandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove_btn)
                    .addComponent(edit_btn)
                    .addComponent(editBrandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBrandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(287, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Brands", jPanel1);

        styles_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "cod_estilo", "nm_estilo"
            }
        ));
        styles_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                styles_tableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(styles_table);

        addStyle_btn.setText("Add");
        addStyle_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addStyle_btnMouseReleased(evt);
            }
        });

        removeStyle_btn.setText("Remove");
        removeStyle_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeStyle_btnMouseReleased(evt);
            }
        });

        editStyle_btn.setText("Edit");
        editStyle_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editStyle_btnMouseReleased(evt);
            }
        });

        jLabel6.setText("Nome");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(editStyleCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editStyleName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editStyle_btn)
                                .addGap(18, 18, 18)
                                .addComponent(removeStyle_btn))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(styleName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(addStyle_btn))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStyle_btn)
                    .addComponent(styleName_txtField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeStyle_btn)
                    .addComponent(editStyle_btn)
                    .addComponent(editStyleName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editStyleCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(290, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Styles", jPanel3);

        clients_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "cpf", "nome", "telefone", "email"
            }
        ));
        clients_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clients_tableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(clients_table);

        addClient_btn.setText("Add");
        addClient_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addClient_btnMouseReleased(evt);
            }
        });

        removeClient_btn.setText("Remove");
        removeClient_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeClient_btnMouseReleased(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("CEP");

        jLabel3.setText("Number");

        jLabel4.setText("Complement");

        addEditAddress_btn.setText("Add Address");
        addEditAddress_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addEditAddress_btnMouseReleased(evt);
            }
        });

        removeAddress_btn.setText("Remove Address");
        removeAddress_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeAddress_btnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cep_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numberAddress_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(complement_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(addEditAddress_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeAddress_btn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cep_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberAddress_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complement_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEditAddress_btn)
                    .addComponent(removeAddress_btn))
                .addContainerGap())
        );

        jLabel1.setText("Address");

        jLabel7.setText("CPF");

        jLabel8.setText("Nome");

        jLabel9.setText("Telefone");

        jLabel10.setText("Email");

        getClientOrders_btn.setText("Get Orders");
        getClientOrders_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                getClientOrders_btnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getClientOrders_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeClient_btn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(addClientCpf_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(76, 76, 76)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addClientName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addClientPhone_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addClientEmail_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addClient_btn))
                            .addComponent(jLabel10))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addClient_btn)
                    .addComponent(addClientEmail_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClientPhone_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClientName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClientCpf_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeClient_btn)
                    .addComponent(getClientOrders_btn))
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clients", jPanel2);

        beers_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "cod_cerveja", "nm_marca", "nm_estilo", "graduacao", "preco", "quantidade"
            }
        ));
        beers_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                beers_tableMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(beers_table);
        if (beers_table.getColumnModel().getColumnCount() > 0) {
            beers_table.getColumnModel().getColumn(1).setResizable(false);
            beers_table.getColumnModel().getColumn(3).setResizable(false);
        }

        addBrand_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addStyle_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addBeer_btn.setText("Add Beer");
        addBeer_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addBeer_btnMouseReleased(evt);
            }
        });

        jLabel11.setText("Marca");

        jLabel12.setText("Estilo");

        jLabel13.setText("Graduação");

        jLabel14.setText("Preço");

        jLabel18.setText("Amount in Estoque");

        setAmount_btn.setText("Set Amount");
        setAmount_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                setAmount_btnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addBrand_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStyle_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(addAlcoholContent_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(addPrice_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addBeer_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(setAmount_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setAmount_btn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBrand_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStyle_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAlcoholContent_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPrice_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBeer_btn))
                .addGap(70, 70, 70)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setAmount_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setAmount_btn))
                .addContainerGap(301, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Beers", jPanel5);

        jLabel15.setText("CPF");

        jLabel16.setText("Codígo Cerveja");

        jLabel17.setText("Quantidade");

        addOrder_btn.setText("Add Order");
        addOrder_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addOrder_btnMouseReleased(evt);
            }
        });

        allOrders_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(allOrders_table);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(addOrderCPF_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addOrderBeer_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(addOrderAmount_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addOrder_btn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addOrderCPF_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOrderBeer_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOrderAmount_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOrder_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orders", jPanel6);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStyle_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStyle_btnMouseReleased

        String styleName = this.styleName_txtField.getText();
        if (styleName.equals("")) {
            return;
        }
        try {
            this.styleDAO.addStyle(0, styleName);  //O BD insere o codigo correto
            this.FillStyleTable(this.styleDAO.getBeerStyleList());
            this.FillStyleComboBox(this.styleDAO.getBeerStyleList());
        } catch (SQLException ex) {
            boolean optionPane = true;
            for(BeerStyle style : this.styleDAO.getBeerStyleList()){
                System.out.println(style.getBeerStyleName() + " - " + styleName);
                if(style.getBeerStyleName().equals(styleName)){
                    JOptionPane.showMessageDialog(rootPane, "Já existe um estilo com o mesmo nome. Por favor, insira um nome inexistente");
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, "Já existe um estilo com o mesmo nome. Por favor, insira um nome inexistente");
                    optionPane = false;
                }
            }
            if(optionPane){
                JOptionPane.showMessageDialog(rootPane, "Um erro ocorreu. Tente novamente");
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addStyle_btnMouseReleased

    private void removeStyle_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeStyle_btnMouseReleased
        if(this.styles_table.getSelectedRow() != -1){
            DefaultTableModel model = (DefaultTableModel) this.styles_table.getModel();
            System.out.println((int)model.getValueAt(this.styles_table.getSelectedRow(),0));
            try {
                System.out.println(this.styleDAO.removeStyle((int)model.getValueAt(this.styles_table.getSelectedRow(),0)));
                this.FillStyleTable(this.styleDAO.getBeerStyleList());
                this.FillStyleComboBox(this.styleDAO.getBeerStyleList());
            } catch (SQLException ex) {
                System.out.println("sdf: "+ex.getMessage());
                JOptionPane.showMessageDialog(rootPane, ex);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_removeStyle_btnMouseReleased

    private void styles_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_styles_tableMouseReleased
        // TODO add your handling code here:
        System.out.println("mouse released in table styles");
        DefaultTableModel model = (DefaultTableModel) this.styles_table.getModel();
        
        this.editStyleCode_txtField.setText(Integer.toString((int) model.getValueAt(this.styles_table.getSelectedRow(),0)));
        this.editStyleCode_txtField.setEditable(false);
        this.editStyleName_txtField.setText((String)model.getValueAt(this.styles_table.getSelectedRow(),1));
        
    }//GEN-LAST:event_styles_tableMouseReleased

    private void editStyle_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editStyle_btnMouseReleased
        // TODO add your handling code here:
        if(this.styles_table.getSelectedRow() != -1){
            DefaultTableModel model = (DefaultTableModel) this.styles_table.getModel();
            try {
                this.styleDAO.updateStyle((int)model.getValueAt(this.styles_table.getSelectedRow(),0),this.editStyleName_txtField.getText());
                this.FillStyleTable(this.styleDAO.getBeerStyleList());
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_editStyle_btnMouseReleased

    private void addClient_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClient_btnMouseReleased
        // TODO add your handling code here:
        String clientCpf = this.addClientCpf_txtField.getText();
        String clientName = this.addClientName_txtField.getText();
        String clientPhone = this.addClientPhone_txtField.getText();
        String clientEmail = this.addClientEmail_txtField.getText();
        if (clientCpf.equals("") || clientName.equals("") || clientPhone.equals("") || clientEmail.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Fill all fields");
            return;
        }
        try {
            this.clientDAO.addClient(clientCpf, clientName, clientPhone, clientEmail);
            this.FillClientTable(this.clientDAO.getClientList());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addClient_btnMouseReleased

    private void removeClient_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeClient_btnMouseReleased
        if(this.clients_table.getSelectedRow() != -1){
            DefaultTableModel model = (DefaultTableModel) this.clients_table.getModel();
            try {
                System.out.println(this.clientDAO.removeClient((String) model.getValueAt(this.clients_table.getSelectedRow(),0)));
                this.FillClientTable(this.clientDAO.getClientList());
            } catch (SQLException ex) {
                System.out.println("sdf: "+ex.getMessage());
                JOptionPane.showMessageDialog(rootPane, ex);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_removeClient_btnMouseReleased

    private void fillAddressFields(Address address){
        System.out.println("Address: " + address);
        if(address != null){
            this.cep_txtField.setText(address.getCep());
            this.numberAddress_txtField.setText(address.getAddressNumber());
            this.complement_txtField.setText(address.getComplement());
            this.addEditAddress_btn.setText("Edit Address");
        } else {
            this.cep_txtField.setText("");
            this.numberAddress_txtField.setText("");
            this.complement_txtField.setText("");
            this.addEditAddress_btn.setText("Add Address");
        }
        
    }
    
    private void clients_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clients_tableMouseReleased
        DefaultTableModel model = (DefaultTableModel) this.clients_table.getModel();
        String cpf = (String) model.getValueAt(this.clients_table.getSelectedRow(),0);
        System.out.println("cpf: " + cpf);
        this.selectedClient = this.clientDAO.getClient(cpf);
//        System.out.println(this.addressDAO.getAddress(cpf));
        this.fillAddressFields(this.addressDAO.getAddress(cpf));
    }//GEN-LAST:event_clients_tableMouseReleased

    private void addEditAddress_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEditAddress_btnMouseReleased
        if (this.addressDAO.getAddress(this.selectedClient.getCpf()) != null) {
            try {
                this.addressDAO.updateAddress(this.cep_txtField.getText(),this.numberAddress_txtField.getText(),this.complement_txtField.getText(), selectedClient);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.addressDAO.addAddress(this.cep_txtField.getText(),this.numberAddress_txtField.getText(),this.complement_txtField.getText(), selectedClient);
            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
        
    }//GEN-LAST:event_addEditAddress_btnMouseReleased

    private void removeAddress_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeAddress_btnMouseReleased
        // TODO add your handling code here:
        if (this.addressDAO.getAddress(this.selectedClient.getCpf()) != null) {
            try {
                this.addressDAO.removeAddress(this.selectedClient);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }//GEN-LAST:event_removeAddress_btnMouseReleased

    private void edit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_btnMouseReleased
        // TODO add your handling code here:
        if(this.brands_table.getSelectedRow() != -1){
            DefaultTableModel model = (DefaultTableModel) this.brands_table.getModel();
            try {
                this.brandDAO.updateBrand((int)model.getValueAt(this.brands_table.getSelectedRow(),0),this.editBrandName_txtField.getText());
                this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_edit_btnMouseReleased

    private void addBrand_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBrand_btnMouseReleased

        String brandName = this.brandName_txtField.getText();
        if (brandName.equals("")) {
            return;
        }
        try {
            this.brandDAO.addBrand(0, brandName);  //O BD insere o codigo correto
            this.FillBrandTable(this.brandDAO.getBrandList(), this.brands_table);
            this.FillBrandComboBox(this.brandDAO.getBrandList());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBrand_btnMouseReleased

    private void remove_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove_btnMouseReleased

        if(this.brands_table.getSelectedRow() != -1){
            DefaultTableModel model = (DefaultTableModel) this.brands_table.getModel();
            //        model.removeRow(this.brands_table.getSelectedRow());
            System.out.println((int)model.getValueAt(this.brands_table.getSelectedRow(),0));
            try {
                System.out.println(this.brandDAO.removeBrand((int)model.getValueAt(this.brands_table.getSelectedRow(),0)));
                this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
                this.FillBrandComboBox(this.brandDAO.getBrandList());
            } catch (SQLException ex) {
                System.out.println("sdf: "+ex.getMessage());
                JOptionPane.showMessageDialog(rootPane, ex);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_remove_btnMouseReleased

    private void brands_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brands_tableMouseReleased
        // TODO add your handling code here:
        System.out.println("mouse released in table brands");
        DefaultTableModel model = (DefaultTableModel) this.brands_table.getModel();

        this.editBrandCode_txtField.setText(Integer.toString((int) model.getValueAt(this.brands_table.getSelectedRow(),0)));
        this.editBrandCode_txtField.setEditable(false);
        this.editBrandName_txtField.setText((String)model.getValueAt(this.brands_table.getSelectedRow(),1));

    }//GEN-LAST:event_brands_tableMouseReleased

    private void clearAddBeerFields(){
        this.addAlcoholContent_txtField.setText("");
        this.addPrice_txtField.setText("");
    }
    
    private void addBeer_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBeer_btnMouseReleased
        // TODO add your handling code here:
        try {
            Double alcoholContent = Double.parseDouble(this.addAlcoholContent_txtField.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Invalid value for graduacao");
            this.addAlcoholContent_txtField.setText("");
            return;
        }
        
        try {
            Double price = Double.parseDouble(this.addPrice_txtField.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Invalid value for preco");
            this.addPrice_txtField.setText("");
            return;
        }
        try {
            this.beerDAO.addBeer(this.brandDAO.getBrandByName((String)this.addBrand_cb.getSelectedItem()).getBrandCode(),
                    this.styleDAO.getStyleByName((String)this.addStyle_cb.getSelectedItem()).getBeerStyleCode(),
                    Double.parseDouble(this.addAlcoholContent_txtField.getText()), 
                    Double.parseDouble(this.addPrice_txtField.getText()));

            this.stockDAO.getStockItems();
            this.FillBeerTable(this.stockDAO.getStockList());
            this.clearAddBeerFields();
            JOptionPane.showMessageDialog(rootPane, "Beer added successfuly");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addBeer_btnMouseReleased

    private void getClientOrders_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getClientOrders_btnMouseReleased
        // TODO add your handling code here:
        if (this.clients_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane,"Select a client");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.clients_table.getModel();
        System.out.println(model.getValueAt(this.clients_table.getSelectedRow(), 0));
        String cpf = (String) model.getValueAt(this.clients_table.getSelectedRow(), 0);
        try {
            System.out.println(this.orderDAO.getOrdersFrom(cpf));
            if (this.orderDAO.getOrdersFrom(cpf).isEmpty()) {
                JOptionPane.showMessageDialog(rootPane,"This client doesn't have any order");
                return;
            }
            OrdersFrame of = new OrdersFrame(this.orderDAO.getOrdersFrom(cpf),this);
            of.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_getClientOrders_btnMouseReleased

    private void addOrder_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOrder_btnMouseReleased
        // TODO add your handling code here:
        Client client = this.clientDAO.getClient(this.addOrderCPF_txtField.getText());
        if (client == null) {
            JOptionPane.showMessageDialog(rootPane, "Client not found");
            return;
        }
        if (this.addressDAO.getAddress(client.getCpf()) == null) {
            JOptionPane.showMessageDialog(rootPane, "Client does't have an address");
            return;
        }
        try {
            System.out.println(Integer.parseInt(this.addOrderBeer_txtField.getText()));
            Beer beer = this.beerDAO.getBeerByCode(Integer.parseInt(this.addOrderBeer_txtField.getText()));
            System.out.println(beer.toString());
            if (beer == null) {
                JOptionPane.showMessageDialog(rootPane, "Beer not found");
                return;
            }
            if(Double.parseDouble(this.addOrderAmount_txtField.getText()) > this.stockDAO.getAmount(beer.getCod_beer())){
                JOptionPane.showMessageDialog(rootPane, "Unavailable amount in stock\nAmount in stock: " + this.stockDAO.getAmount(beer.getCod_beer()));
                return;
            }
            this.orderDAO.addOrder(client.getCpf(),beer.getCod_beer(),Double.parseDouble(this.addOrderAmount_txtField.getText()));
            JOptionPane.showMessageDialog(rootPane, "Order added succesfuly");
            this.FillBeerTable(this.stockDAO.getStockItems());
            this.FillAllOrdersTable(this.orderDAO.getOrderList());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Invalid value for beer code");
        }
        
    }//GEN-LAST:event_addOrder_btnMouseReleased

    private void setAmount_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setAmount_btnMouseReleased
        // TODO add your handling code here:
        if (this.beers_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Select a beer");
            return;
        }
        if(this.setAmount_txtField.getText().equals("")){
            return;
        }
        int beerCode = (int) this.beers_table.getValueAt(this.beers_table.getSelectedRow(),0);
        try {
            this.stockDAO.updateBeerAmount(beerCode,Double.parseDouble(this.setAmount_txtField.getText()));
            this.FillBeerTable(this.stockDAO.getStockList());
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Invalid value for amount");
        }
    }//GEN-LAST:event_setAmount_btnMouseReleased

    private void beers_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beers_tableMouseReleased
        // TODO add your handling code here:
        this.setAmount_txtField.setText(Double.toString((double) this.beers_table.getValueAt(this.beers_table.getSelectedRow(),5)));
    }//GEN-LAST:event_beers_tableMouseReleased

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    Connection dbCon = DBConnetion.connect();
                    ClientDAO clientDAO = new ClientDAO(dbCon);
                    BrandDAO brandDAO = new BrandDAO(dbCon);
                    StyleDAO styleDAO = new StyleDAO(dbCon);
                    BeerDAO beerDAO = new BeerDAO(dbCon,brandDAO,styleDAO);
                    StockDAO stockDAO = new StockDAO(dbCon,beerDAO);
                    OrderDAO orderDAO = new OrderDAO(dbCon,clientDAO,beerDAO);
                    new MainFrame(dbCon,beerDAO, brandDAO,styleDAO,clientDAO,new AddressDAO(dbCon,clientDAO),stockDAO,orderDAO).setVisible(true);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addAlcoholContent_txtField;
    private javax.swing.JButton addBeer_btn;
    private javax.swing.JButton addBrand_btn;
    private javax.swing.JComboBox<String> addBrand_cb;
    private javax.swing.JTextField addClientCpf_txtField;
    private javax.swing.JTextField addClientEmail_txtField;
    private javax.swing.JTextField addClientName_txtField;
    private javax.swing.JTextField addClientPhone_txtField;
    private javax.swing.JButton addClient_btn;
    private javax.swing.JButton addEditAddress_btn;
    private javax.swing.JTextField addOrderAmount_txtField;
    private javax.swing.JTextField addOrderBeer_txtField;
    private javax.swing.JTextField addOrderCPF_txtField;
    private javax.swing.JButton addOrder_btn;
    private javax.swing.JTextField addPrice_txtField;
    private javax.swing.JButton addStyle_btn;
    private javax.swing.JComboBox<String> addStyle_cb;
    private javax.swing.JTable allOrders_table;
    private javax.swing.JTable beers_table;
    private javax.swing.JTextField brandName_txtField;
    private javax.swing.JTable brands_table;
    private javax.swing.JTextField cep_txtField;
    private javax.swing.JTable clients_table;
    private javax.swing.JTextField complement_txtField;
    private javax.swing.JTextField editBrandCode_txtField;
    private javax.swing.JTextField editBrandName_txtField;
    private javax.swing.JTextField editStyleCode_txtField;
    private javax.swing.JTextField editStyleName_txtField;
    private javax.swing.JButton editStyle_btn;
    private javax.swing.JButton edit_btn;
    private javax.swing.JButton getClientOrders_btn;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField numberAddress_txtField;
    private javax.swing.JButton removeAddress_btn;
    private javax.swing.JButton removeClient_btn;
    private javax.swing.JButton removeStyle_btn;
    private javax.swing.JButton remove_btn;
    private javax.swing.JButton setAmount_btn;
    private javax.swing.JTextField setAmount_txtField;
    private javax.swing.JTextField styleName_txtField;
    private javax.swing.JTable styles_table;
    // End of variables declaration//GEN-END:variables
}
