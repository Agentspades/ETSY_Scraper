/*
 * Proxy Settings
 * File Name: proxySettings_GUI.java
 * Purpose: get the users proxy settings
 * Author: Agentspades
 * Date: 1 Jul 2021
 * ToDo:
 */
package com.agentspades.etsyscrapermaven;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

public class proxySettingsGUI extends javax.swing.JFrame {

    public proxySettingsGUI() {
        initComponents();
        //set the window to the center of the screen
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_JLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ip_JTextField = new javax.swing.JTextField();
        port_JTextField = new javax.swing.JTextField();
        set_JButton = new javax.swing.JButton();
        proxyList_JButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proxy Configuration");
        setResizable(false);

        title_JLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        title_JLabel.setText("Proxy Settings");

        jLabel1.setText("IP:");

        jLabel2.setText("Port:");

        set_JButton.setText("Set");
        set_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                set_JButtonActionPerformed(evt);
            }
        });

        proxyList_JButton.setText("Proxy List");
        proxyList_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxyList_JButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(title_JLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(proxyList_JButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(set_JButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(port_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(ip_JTextField)))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_JLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ip_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(port_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(set_JButton)
                    .addComponent(proxyList_JButton))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void set_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_set_JButtonActionPerformed
        //check if there is data input
        if(ip_JTextField.getText().length() > 0 || port_JTextField.getText().length() > 0){
            //set the ip from the text field
            SearchGUI.setIp(ip_JTextField.getText());
            //get the string from the port text field
            String portStr = port_JTextField.getText();
            //check if the port only contains numbers
            if(portStr.matches("[0-9]+")){
                //return the port number back to the main application
                SearchGUI.setPort(Integer.parseInt(portStr));
            }//end inner if
            else{
                //show a warning message if the port is invalid
                JOptionPane.showMessageDialog(null, "Please only use numbers for port number", 
                        "INVALID PORT", JOptionPane.ERROR_MESSAGE);
                //escape the method
                return;
            }//end else
        }//end outer if
        else{
            //shows a warnign to the user if the fields are black
            JOptionPane.showMessageDialog(null, "Please enter both an IP and a port", 
                        "INVALID INPUT", JOptionPane.ERROR_MESSAGE);
                return;
        }//end outer else
        //dispose the window once set
        this.dispose();
    }//GEN-LAST:event_set_JButtonActionPerformed

    private void proxyList_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxyList_JButtonActionPerformed
        try{
            //create a new desktop object
            Desktop dt = Desktop.getDesktop();
            //set the web URI to be opened
            URI url = new URI("https://www.us-proxy.org");
            //open the URI
            dt.browse(url);
        }//end try
        catch(Exception e){
            e.printStackTrace();
        }//end catch
    }//GEN-LAST:event_proxyList_JButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ip_JTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField port_JTextField;
    private javax.swing.JButton proxyList_JButton;
    private javax.swing.JButton set_JButton;
    private javax.swing.JLabel title_JLabel;
    // End of variables declaration//GEN-END:variables
}
