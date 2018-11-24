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
import models.BeerStyle;
import models.Brand;
import services.BeerDAO;
import services.DBConnetion;
import net.proteanit.sql.DbUtils;
import services.BrandDAO;
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
    
    public MainFrame(Connection con,BeerDAO beerDAO,BrandDAO brandDAO,StyleDAO styleDAO) throws SQLException {
        initComponents();
        this.setLocation(400, 200);
        this.dbConnection = con;
        this.beerDAO = beerDAO;
        this.brandDAO = brandDAO;
        this.styleDAO = styleDAO;
        this.FillBrandTable(this.brandDAO.getBrandList(),this.brands_table);
        this.FillStyleTable(this.styleDAO.getBeerStyleList());
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(styleCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(styleName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addStyle_btn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(editStyleCode_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editStyleName_txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editStyle_btn)
                                .addGap(18, 18, 18)
                                .addComponent(removeStyle_btn)))))
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
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Styles", jPanel3);

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
                    new MainFrame(dbCon,new BeerDAO(dbCon), new BrandDAO(dbCon),new StyleDAO(dbCon)).setVisible(true);
                    
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
    private javax.swing.JButton addStyle_btn;
    private javax.swing.JTextField brandCode_txtField;
    private javax.swing.JTextField brandName_txtField;
    private javax.swing.JTable brands_table;
    private javax.swing.JTextField editBrandCode_txtField;
    private javax.swing.JTextField editBrandName_txtField;
    private javax.swing.JTextField editStyleCode_txtField;
    private javax.swing.JTextField editStyleName_txtField;
    private javax.swing.JButton editStyle_btn;
    private javax.swing.JButton edit_btn;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton removeStyle_btn;
    private javax.swing.JButton remove_btn;
    private javax.swing.JTextField styleCode_txtField;
    private javax.swing.JTextField styleName_txtField;
    private javax.swing.JTable styles_table;
    // End of variables declaration//GEN-END:variables
}
