/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NGORole;

import Business.EcoSystem;
import Business.Enterprise.DisposableEnterprise;
import Business.Enterprise.Enterprise;
import Business.Inventory.InventoryItem;
import Business.Inventory.NGOInventoryItem;
import Business.Medicine.Medicine;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NGOtoRNDWorkRequest;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankita Mhatre
 */
public class NGOManageInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NGOManageInventoryJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Network network;
    private UserAccount account;
    EcoSystem business;

//    ******Ankita 11/29*****
//    private NGOInventoryItem ngoInventory;
    public NGOManageInventoryJPanel(JPanel userProcessContainer, Enterprise enterprise, Network network, EcoSystem business, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.network = network;
        this.business = business;
        this.account = account;

        populateTableinv();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBackButton = new javax.swing.JButton();
        checkExpiry = new javax.swing.JButton();

        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(inventoryTable);

        jButton1.setText("View Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Inventory");

        txtBackButton.setText("<<< Back");
        txtBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBackButtonActionPerformed(evt);
            }
        });

        checkExpiry.setText("Check Expiry");
        checkExpiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkExpiryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBackButton))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkExpiry))
                .addContainerGap(212, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void populateTableinv() {
        DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();

        model.setRowCount(0);

// Ankita
        for (InventoryItem inv : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList()) {

            Object[] row = new Object[2];
            row[0] = inv;
            row[1] = inv.getQuantity();
            model.addRow(row);
//Ankita
        }
    }


    private void txtBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBackButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_txtBackButtonActionPerformed

    private void checkExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkExpiryActionPerformed
        // TODO add your handling code here:

        // nikunj 6/12
        for (InventoryItem inv : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList()) {

            for(Medicine m : inv.getMedicineListInInventoryItem().getMedicineList())
            {
            Date expired = m.getExpiryDate();
            int medqt = m.getQuantity();
            Date today = new Date();
            if (expired.compareTo(today) < 0) {
                // expired dates
                Enterprise enterp = null;
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {

                    if (ent.getEnterpriseType().getValue().equals("Disposable Enterprise") && ent instanceof DisposableEnterprise) {

                        enterp = ent;
                        break;
                    }
                }
                enterp.getInventoryDirectoryEnterpriseLevel().addInventoryItemDisposable(enterp, account, m, medqt);
            }
            }       

        }
        
        populateTableinv();
        JOptionPane.showMessageDialog(null, "Expired Medicines Sent To Disposable");


    }//GEN-LAST:event_checkExpiryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                int selectedRow = inventoryTable.getSelectedRow();
        if (selectedRow < 0){
            return;
        }
        System.out.println(selectedRow+" selectedRow is");
        NGOInventoryItem ngoInventoryItem= (NGOInventoryItem)inventoryTable.getValueAt(selectedRow, 0);
        System.out.println(ngoInventoryItem.getMedicine()+" med is");
        
        NGOInventoryItemDetailsJPanel nGOInventoryItemDetailsJPanel = new NGOInventoryItemDetailsJPanel(userProcessContainer,ngoInventoryItem);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("nGOInventoryItemDetailsJPanel", nGOInventoryItemDetailsJPanel);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkExpiry;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton txtBackButton;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
