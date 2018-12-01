package views;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Address;
import models.Beer;
import models.BeerStyle;
import models.Brand;
import models.Client;
import services.BeerDAO;
import services.DBConnetion;
//import net.proteanit.sql.DbUtils;
import services.AddressDAO;
import services.BrandDAO;
import services.ClientDAO;
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
    Client selectedClient;
    
    public MainFrame(Connection con,BeerDAO beerDAO,BrandDAO brandDAO,StyleDAO styleDAO,ClientDAO clientDAO,AddressDAO addressDAO) throws SQLException {
        initComponents();
        this.setLocation(400, 200);
        this.dbConnection = con;
        this.beerDAO = beerDAO;
        this.brandDAO = brandDAO;
        this.styleDAO = styleDAO;
        this.clientDAO = clientDAO;
        this.addressDAO = addressDAO;
        
        this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
        this.FillStyleTable(this.styleDAO.getBeerStyleList());
        this.FillClientTable(this.clientDAO.getClientList());
//        this.brands_table.

        this.selectedClient = null;
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
        brandCode_txtField = new javax.swing.JTextField();
        edit_btn = new javax.swing.JButton();
        editBrandName_txtField = new javax.swing.JTextField();
        editBrandCode_txtField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        styles_table = new javax.swing.JTable();
        addStyle_btn = new javax.swing.JButton();
        styleName_txtField = new javax.swing.JTextField();
        styleCode_txtField = new javax.swing.JTextField();
        removeStyle_btn = new javax.swing.JButton();
        editStyle_btn = new javax.swing.JButton();
        editStyleName_txtField = new javax.swing.JTextField();
        editStyleCode_txtField = new javax.swing.JTextField();
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
        jPanel5 = new javax.swing.JPanel();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editBrandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editBrandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remove_btn))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(brandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(brandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBrand_btn)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBrand_btn)
                    .addComponent(brandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove_btn)
                    .addComponent(edit_btn)
                    .addComponent(editBrandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBrandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
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
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(styleCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(styleName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addStyle_btn)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStyle_btn)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(styleName_txtField)
                            .addComponent(styleCode_txtField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeStyle_btn)
                    .addComponent(editStyle_btn)
                    .addComponent(editStyleName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editStyleCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(175, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addClientCpf_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addClientName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addClientPhone_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addClientEmail_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addClient_btn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeClient_btn)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addClient_btn)
                    .addComponent(addClientEmail_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClientPhone_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClientName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClientCpf_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeClient_btn)
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clients", jPanel2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Beers", jPanel5);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
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

    private void remove_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove_btnMouseReleased

        if(this.brands_table.getSelectedRow() != -1){
            DefaultTableModel model = (DefaultTableModel) this.brands_table.getModel();
    //        model.removeRow(this.brands_table.getSelectedRow());
            System.out.println((int)model.getValueAt(this.brands_table.getSelectedRow(),0));
            try {
                System.out.println(this.brandDAO.removeBrand((int)model.getValueAt(this.brands_table.getSelectedRow(),0)));
                this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
            } catch (SQLException ex) {
                System.out.println("sdf: "+ex.getMessage());
                JOptionPane.showMessageDialog(rootPane, ex);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
        
    }//GEN-LAST:event_remove_btnMouseReleased

    private void addBrand_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBrand_btnMouseReleased
        
        int brandCode = Integer.parseInt(this.brandCode_txtField.getText());
        String brandName = this.brandName_txtField.getText();
        try {
            this.brandDAO.addBrand(brandCode, brandName);
            this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBrand_btnMouseReleased

    private void brands_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brands_tableMouseReleased
        // TODO add your handling code here:
        System.out.println("mouse released in table brands");
        DefaultTableModel model = (DefaultTableModel) this.brands_table.getModel();
        
        this.editBrandCode_txtField.setText(Integer.toString((int) model.getValueAt(this.brands_table.getSelectedRow(),0)));
        this.editBrandCode_txtField.setEditable(false);
        this.editBrandName_txtField.setText((String)model.getValueAt(this.brands_table.getSelectedRow(),1));
        
    }//GEN-LAST:event_brands_tableMouseReleased

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

    private void addStyle_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStyle_btnMouseReleased
        int styleCode = Integer.parseInt(this.styleCode_txtField.getText());
        String styleName = this.styleName_txtField.getText();
        try {
            this.styleDAO.addStyle(styleCode, styleName);
            this.FillStyleTable(this.styleDAO.getBeerStyleList());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addStyle_btnMouseReleased

    private void removeStyle_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeStyle_btnMouseReleased
        // TODO add your handling code here:
        if(this.styles_table.getSelectedRow() != -1){
            DefaultTableModel model = (DefaultTableModel) this.styles_table.getModel();
    //        model.removeRow(this.brands_table.getSelectedRow());
            System.out.println((int)model.getValueAt(this.styles_table.getSelectedRow(),0));
            try {
                System.out.println(this.styleDAO.removeStyle((int)model.getValueAt(this.styles_table.getSelectedRow(),0)));
                this.FillStyleTable(this.styleDAO.getBeerStyleList());
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
        this.selectedClient = this.clientDAO.getClient(cpf);
        System.out.println(this.addressDAO.getAddress(cpf));
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
                    new MainFrame(dbCon,new BeerDAO(dbCon), new BrandDAO(dbCon),new StyleDAO(dbCon),clientDAO,new AddressDAO(dbCon,clientDAO)).setVisible(true);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBrand_btn;
    private javax.swing.JTextField addClientCpf_txtField;
    private javax.swing.JTextField addClientEmail_txtField;
    private javax.swing.JTextField addClientName_txtField;
    private javax.swing.JTextField addClientPhone_txtField;
    private javax.swing.JButton addClient_btn;
    private javax.swing.JButton addEditAddress_btn;
    private javax.swing.JButton addStyle_btn;
    private javax.swing.JTextField brandCode_txtField;
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
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField numberAddress_txtField;
    private javax.swing.JButton removeAddress_btn;
    private javax.swing.JButton removeClient_btn;
    private javax.swing.JButton removeStyle_btn;
    private javax.swing.JButton remove_btn;
    private javax.swing.JTextField styleCode_txtField;
    private javax.swing.JTextField styleName_txtField;
    private javax.swing.JTable styles_table;
    // End of variables declaration//GEN-END:variables
}
