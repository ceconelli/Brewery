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
import models.Beer;
import models.Brand;
import services.BeerDAO;
import services.DBConnetion;
import net.proteanit.sql.DbUtils;
import services.BrandDAO;
/**
 *
 * @author gceconelli
 */
public class MainFrame extends javax.swing.JFrame {

    Connection dbConnection;
    BeerDAO beerDAO;
    BrandDAO brandDAO;
    
    public MainFrame(Connection con,BeerDAO beerDAO,BrandDAO brandDAO) throws SQLException {
        initComponents();
        this.setLocation(400, 200);
        this.dbConnection = con;
        this.beerDAO = beerDAO;
        this.brandDAO = brandDAO;
        this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(brandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(brandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addBrand_btn)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(editBrandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editBrandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(edit_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(remove_btn))))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove_btn)
                    .addComponent(edit_btn)
                    .addComponent(editBrandName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBrandCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jTabbedPane1.addTab("Brands", jPanel1);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void remove_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove_btnMouseReleased

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
      
        
    }//GEN-LAST:event_remove_btnMouseReleased

    private void addBrand_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBrand_btnMouseReleased
        
        int brandCode = Integer.parseInt(this.brandCode_txtField.getText());
        String brandName = this.brandName_txtField.getText();
        try {
            this.brandDAO.addBrand(brandCode, brandName);
            this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBrand_btnMouseReleased

    private void brands_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brands_tableMouseReleased
        // TODO add your handling code here:
        System.out.println("mouse released in table");
        DefaultTableModel model = (DefaultTableModel) this.brands_table.getModel();
        
        this.editBrandCode_txtField.setText(Integer.toString((int) model.getValueAt(this.brands_table.getSelectedRow(),0)));
        this.editBrandCode_txtField.setEditable(false);
        this.editBrandName_txtField.setText((String)model.getValueAt(this.brands_table.getSelectedRow(),1));
        
    }//GEN-LAST:event_brands_tableMouseReleased

    private void edit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_btnMouseReleased
        // TODO add your handling code here:
        if(this.brands_table.getSelectedRow() != -1){
            
        }
    }//GEN-LAST:event_edit_btnMouseReleased

    
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
                    new MainFrame(dbCon,new BeerDAO(dbCon), new BrandDAO(dbCon)).setVisible(true);
                    
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
    private javax.swing.JTextField brandCode_txtField;
    private javax.swing.JTextField brandName_txtField;
    private javax.swing.JTable brands_table;
    private javax.swing.JTextField editBrandCode_txtField;
    private javax.swing.JTextField editBrandName_txtField;
    private javax.swing.JButton edit_btn;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton remove_btn;
    // End of variables declaration//GEN-END:variables
}
