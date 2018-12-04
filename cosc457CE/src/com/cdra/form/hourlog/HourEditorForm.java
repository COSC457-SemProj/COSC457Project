/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdra.form.hourlog;

import com.cdra.SystemInterface;
import com.cdra.controller.WorksOn;
import javax.swing.JOptionPane;

/**
 *
 * @author cgood
 */
public class HourEditorForm extends javax.swing.JFrame {

    /**
     * Creates new form HourEditorForm
     */
    public HourEditorForm(String[][] response) {
        initComponents();
        empID = response[0][0];
        conNum = response[0][1];
        empIDLabel.setText(empIDLabel.getText() + empID);
        conNumLabel.setText(conNumLabel.getText() + conNum);
        hoursBox.setText(response[0][2]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        empIDLabel = new javax.swing.JLabel();
        conNumLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hoursBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter the hours you have worked");

        empIDLabel.setText("Employee ID: ");

        conNumLabel.setText("Contract Number: ");

        jLabel2.setText("Hours: ");

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(empIDLabel)
                    .addComponent(conNumLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoursBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(conNumLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hoursBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WorksOn worksOn = new WorksOn();
        String[] workPrim = worksOn.getPrimaryKey();
        if(SystemInterface.select(new String[] {worksOn.getTableName()},
                workPrim,
                new String[] {"=", "="},
                new String[] {empID, conNum}).length > 0){
            if(SystemInterface.update(
                    worksOn.getTableName(),
                    new String[] {"WorksOnHours"},
                    new String[] {hoursBox.getText()},
                    workPrim,
                    new String[] {"=", "="},
                    new String[] {empID, conNum}) == null){
                JOptionPane.showMessageDialog(null, "Error, check your data and try again..");
            }else{
                JOptionPane.showMessageDialog(null, "Log Successful");
                this.dispose();
            }
        }else{
            worksOn.setWorksOnEmpNum(empID);
            worksOn.setWorksOnConNum(conNum);
            worksOn.setWorksOnHours(hoursBox.getText());
            if(SystemInterface.insert(worksOn) == null){
                JOptionPane.showMessageDialog(null, "Error, check your data and try again..");
            }else{
                JOptionPane.showMessageDialog(null, "Log Successful");
                this.dispose();
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private String empID;
    private String conNum;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel conNumLabel;
    private javax.swing.JLabel empIDLabel;
    private javax.swing.JTextField hoursBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}