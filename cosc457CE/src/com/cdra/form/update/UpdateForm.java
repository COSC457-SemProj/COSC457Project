package com.cdra.form.update;

import com.cdra.SystemInterface;
import com.cdra.controller.*;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class UpdateForm extends javax.swing.JFrame {

    /**
     * Creates new form UpdateForm
     */
    public UpdateForm() {
        initComponents();
        primKey1.setVisible(false);
        primKey1Box.setVisible(false);
        primKey2.setVisible(false);
        primKey2Box.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tableName = new javax.swing.JComboBox<>();
        primKey1 = new javax.swing.JLabel();
        primKey1Box = new javax.swing.JTextField();
        primKey2 = new javax.swing.JLabel();
        primKey2Box = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Update Existing Row:");

        jLabel2.setText("Table:");

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tableName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One...", "Employee", "Contract", "Customer", "Department", "Location" }));
        tableName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(primKey1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(primKey1Box, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(primKey2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(primKey2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primKey1)
                    .addComponent(primKey1Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(primKey2)
                    .addComponent(primKey2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void tableNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableNameActionPerformed
        String item = (String) tableName.getSelectedItem();
        switch(item){
            case "Choose One...":
                primKey1.setVisible(false);
                primKey1Box.setVisible(false);
                primKey2.setVisible(false);
                primKey2Box.setVisible(false);
                break;
            case "Employee":
                primKey1.setText("Employee ID: ");
                primKey1.setVisible(true);
                primKey1Box.setVisible(true);
                primKey2.setVisible(false);
                primKey2Box.setVisible(false);
                break;
            case "Contract":
                primKey1.setText("Contract Number: ");
                primKey1.setVisible(true);
                primKey1Box.setVisible(true);
                primKey2.setVisible(false);
                primKey2Box.setVisible(false);
                break;
            case "Customer":
                primKey1.setText("Customer ID: ");
                primKey1.setVisible(true);
                primKey1Box.setVisible(true);
                primKey2.setVisible(false);
                primKey2Box.setVisible(false);
                break;
            case "Department":
                primKey1.setText("Department ID: ");
                primKey1.setVisible(true);
                primKey1Box.setVisible(true);
                primKey2.setVisible(false);
                primKey2Box.setVisible(false);
                break;
            case "Location":
                primKey1.setText("Location ID: ");
                primKey1.setVisible(true);
                primKey1Box.setVisible(true);
                primKey2.setVisible(false);
                primKey2Box.setVisible(false);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_tableNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String item = (String) tableName.getSelectedItem();
        switch(item){
            case "Choose One...":
                break;
            case "Employee":
                Employee employee = new Employee();
                String[] empPrim = employee.getPrimaryKey();
                String[][] empResults = SystemInterface.select( 
                        new String[] {employee.getTableName()},
                        empPrim,
                        new String[] {"="},
                        new String[] {primKey1Box.getText()});
                if(empResults != null && empResults.length > 0){
                    Employee e = new Employee(empResults[0]);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            new EmployeeUpdateForm(e).setVisible(true);
                        }
                    });
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Employee with ID \"" +
                                    primKey1Box.getText() +
                                    "\" not found");
                }
                break;
            case "Contract":
                Contract contract = new Contract();
                String[][] conResults = SystemInterface.select(
                        new String[] {contract.getTableName()},
                        contract.getPrimaryKey(),
                        new String[] {"="},
                        new String[] {primKey1Box.getText()});
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                        new ContractUpdateForm(conResults).setVisible(true);
                    }
                });
                break;
            case "Customer":
                Customer customer = new Customer();
                String[][] custResults = SystemInterface.select(
                        new String[] {customer.getTableName()},
                        customer.getPrimaryKey(),
                        new String[] {"="},
                        new String[] {primKey1Box.getText()});
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                        new CustomerUpdateForm(custResults).setVisible(true);
                    }
                });
                break;
            case "Department":
                Department department = new Department();
                String[][] deptResults = SystemInterface.select(
                        new String[] {department.getTableName()},
                        department.getPrimaryKey(),
                        new String[] {"="},
                        new String[] {primKey1Box.getText()});
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                        new DepartmentUpdateForm(deptResults).setVisible(true);
                    }
                });
                break;
            case "Location":
                Location location = new Location();
                String[][] locResults = SystemInterface.select(
                        new String[] {location.getTableName()},
                        location.getPrimaryKey(),
                        new String[] {"="},
                        new String[] {primKey1Box.getText()});
                java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                        new LocationUpdateForm(locResults).setVisible(true);
                    }
                });
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel primKey1;
    private javax.swing.JTextField primKey1Box;
    private javax.swing.JLabel primKey2;
    private javax.swing.JTextField primKey2Box;
    private javax.swing.JComboBox<String> tableName;
    // End of variables declaration//GEN-END:variables
}
