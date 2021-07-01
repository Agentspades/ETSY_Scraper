/*
 * ETSY Scraper
 * File Name: SearchGUI.java
 * Purpose: Scrape etsy search results to show listing tags
 * Author: Agentspades
 * Date: 1 Jul 2021
 * ToDo: Finish About JOptionPane
 */
package com.agentspades.etsyscrapermaven;

import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;

public class SearchGUI extends javax.swing.JFrame {

    //set default url string
    private String searchUrl = "https://www.etsy.com/search?q=";
    //declare default table models
    private static DefaultTableModel resultsTableModel;
    private static DefaultTableModel topTableModel;
    //set default row
    Object[] defaultRow = {"NA", "NA"};
    //set the sorted tag
    char sorted = 'n';
    //variables for proxyIP and proxyPort
    private static String proxyIP;
    private static int proxyPort = 0;
    
    public SearchGUI() {
        //cutomized column names
        String[] resultsColumnNames = {"Title", "Tags"};
        String[] topColumnNames = {"Tag", "#"};
        
        //reference for iscelleditable workaround: 
        //https://stackoverflow.com/questions/12840153/defaulttablemodel-make-cell-not-editable-jtable
        resultsTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        topTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //set column names and default row
        resultsTableModel.setColumnIdentifiers(resultsColumnNames);
        resultsTableModel.addRow(defaultRow);
        topTableModel.setColumnIdentifiers(topColumnNames);
        topTableModel.addRow(defaultRow);
        //set column widths
        double[] resultsColWidth = {0.4f, 0.6f};
        double[] topColWidth = {0.8f, 0.2f};
        
        
        initComponents();
        
        //get column model
        TableColumnModel resultsColModel = results_JTable.getColumnModel();
        TableColumnModel topColModel = top_JTable.getColumnModel();
        //get table width
        int resultsWidth = results_JTable.getWidth();
        int topWidth = top_JTable.getWidth();
        //set table model to table object
        results_JTable.setModel(resultsTableModel);
        top_JTable.setModel(topTableModel);
        //resize the tables
        resizeTable(resultsColWidth, resultsWidth, resultsColModel);
        resizeTable(topColWidth, topWidth, topColModel);
    }

    /**********************************************************/
    // Method:	  private void resizeTable(double[] columnWidth, int tableWidth, TableColumnModel columnModel)
    // Purpose:   Resizes the JTables
    // Inputs:	  void
    // Outputs:   void
    /**********************************************************/
     private void resizeTable(double[] columnWidth, int tableWidth, TableColumnModel columnModel){
        //create a variable for the table column
        TableColumn column;
        //get the number of columns
        int colCount = columnModel.getColumnCount();
        //loop through each column to assign the width
        for(int i = 0; i < colCount; i++){
            //get the column
            column = columnModel.getColumn(i);
            //get the preferred width
            float pWidth = Math.round(columnWidth[i] * tableWidth);
            //set the preferred width
            column.setPreferredWidth((int)pWidth);
        }//end for loop
    }//end resizeUsersTable() method
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_JLabel = new javax.swing.JLabel();
        search_JLabel = new javax.swing.JLabel();
        search_JTextField = new javax.swing.JTextField();
        search_JButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        progress_JTextArea = new javax.swing.JTextArea();
        reset_JButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        results_JTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        top_JTable = new javax.swing.JTable();
        top_JLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ETSY | Scraper");

        title_JLabel.setFont(new java.awt.Font("sansserif", 0, 48)); // NOI18N
        title_JLabel.setText("ETSY | Scraper");

        search_JLabel.setText("Search Term:");

        search_JButton.setText("Search");
        search_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_JButtonActionPerformed(evt);
            }
        });

        progress_JTextArea.setEditable(false);
        progress_JTextArea.setBackground(new java.awt.Color(0, 0, 0));
        progress_JTextArea.setColumns(20);
        progress_JTextArea.setForeground(new java.awt.Color(0, 153, 51));
        progress_JTextArea.setRows(5);
        jScrollPane1.setViewportView(progress_JTextArea);

        reset_JButton.setText("Reset");
        reset_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_JButtonActionPerformed(evt);
            }
        });

        results_JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(results_JTable);

        top_JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(top_JTable);

        top_JLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        top_JLabel.setText("Top Tags");

        jMenu1.setText("Proxy");

        jMenuItem1.setText("Settings");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(search_JLabel)
                                .addGap(28, 28, 28)
                                .addComponent(search_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(search_JButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reset_JButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title_JLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(top_JLabel))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(title_JLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_JLabel)
                            .addComponent(search_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_JButton)
                            .addComponent(reset_JButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(top_JLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**********************************************************/
    // Method:	  private void search_JButtonActionPerformed(java.awt.event.ActionEvent evt) 
    // Purpose:   Builds the search url and starts a thread for processing
    // Inputs:	  void
    // Outputs:   void
    /**********************************************************/
    private void search_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_JButtonActionPerformed
        //get the search text
        String searchTerm = search_JTextField.getText();
        if(!searchTerm.isEmpty()){
            //split the search term
            String[] split = searchTerm.split(" ");
            //get the array length
            int searchLength = split.length;
            //loop through the array and add to the search URL
            for(int i = 0; i < searchLength; i++){
                searchUrl += (split[i]+ "+");
            }
            //check if anything exists in the JTextArea and clear it if not empty then add the text
            if(!progress_JTextArea.getText().isEmpty()){
                //clear the text area
                progress_JTextArea.setText("");
            }//end if
            //display the search URL in the JTextArea
            progress_JTextArea.setText("Proccessing: " +searchUrl);
            //start a new thread
            new Thread(new scrapeHtmlUnit()).start();
        }//end outer if
        //else display a message
        else{
            //check if the text area is empty first
            if(!progress_JTextArea.getText().isEmpty()){
                //clear the text area
                progress_JTextArea.setText("");    
            }
            //set new text
            progress_JTextArea.setText("Please enter a search term first!");
        }
    }//GEN-LAST:event_search_JButtonActionPerformed

    /**********************************************************/
    // Method:	  private void reset_JButtonActionPerformed(java.awt.event.ActionEvent evt)
    // Purpose:   Resets the GUI
    // Inputs:	  void
    // Outputs:   void
    /**********************************************************/
    private void reset_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_JButtonActionPerformed
        //reset the searchUrl
        searchUrl = "https://www.etsy.com/search?q=";
        //set the fields to blank
        progress_JTextArea.setText("");
        search_JTextField.setText("");
        //clear the tables contents
        clearTable(1);
        clearTable(2);
        //adds the deafult row to tables again
        resultsTableModel.addRow(defaultRow);
        topTableModel.addRow(defaultRow);
        
    }//GEN-LAST:event_reset_JButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new proxySettingsGUI().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //store the about message in a String variable
        String aboutText = "This program has been created by Agentspades "
                + "(July, 2021) under the GNU/GPL V3.0 license."
                + "\nusing the below third party library"
                + "\n\nHtmlUnit v2.5.0 \nhttps://htmlunit.sourceforge.io"
                + "\n\nContact: Agentspades@gmail.com"
                + "\nhttps://github.com/Agentspades/ETSY_Scraper";
        //show a JOptionPane with about info
        JOptionPane.showMessageDialog(null, aboutText, "About", 
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**********************************************************/
    // Method:	  public void clearTable()
    // Purpose:   Clears the tables contents
    // Inputs:	  void
    // Outputs:   void
    /**********************************************************/
   public void clearTable(int type){
        //clear the tables depending on type
        //1 for results table, 2 for top tags table
        switch(type){
            //results table
            case 1:
                //loop through the rows and remove each row
                for(int i = resultsTableModel.getRowCount() -1; i > -1; i--){
                    resultsTableModel.removeRow(i);
                }//end for
                break;
            //top 10 table
            case 2:
                //loop through the table rows and remove each row
                for(int i = topTableModel.getRowCount() -1; i > -1; i--){
                    topTableModel.removeRow(i);
                }//end for
                break;
        }//end switch
    }//end clearTable() method
    
   /**********************************************************/
    // Method:	  private class scrapeHtmlUnit implements Runnable
    // Purpose:   Gets the data from etsy and begins to scrape
    // Inputs:	  void
    // Outputs:   void
    /**********************************************************/
    private class scrapeHtmlUnit implements Runnable{
        public void run(){
            //decalre variables
            HtmlPage resultsPage = null;
            List<String> linkList = new LinkedList<String>();
            //create a WebClient to use for the scrape
            WebClient client = new WebClient();
            //these are done for faster loads
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);
            //this is to fetch more results to overcome the infinite scrolling
            client.getOptions().setScreenHeight(600000);
            //if if a proxy has been specified if not then use the users IP
            if(proxyIP == null && proxyPort != 0){
                ProxyConfig proxyConfig = new ProxyConfig(proxyIP, proxyPort, null);
                client.getOptions().setProxyConfig(proxyConfig);
            }//end if
            try{
                //try connect to etsy
                try{
                    //connect to etsy and get the returned results
                    resultsPage = client.getPage(searchUrl);
                }//end try
                catch(IOException e){
                    //alert the user if the proxy cant connect
                    progress_JTextArea.setText("ERROR: Proxy error try using another one");
                }//end catch
                //create a list of listing cards
                List<HtmlElement> items = resultsPage.getByXPath("//ul"
                        + "[@class='wt-grid wt-grid--block wt-pl-xs-0 tab-reorder-container']"
                        + "/li/div/a");
                //loop through each listing and get the web link
                for(HtmlElement item : items){
                    linkList.add(item.getAttribute("href"));
                }//end for
                //set progress text
                progress_JTextArea.setText(progress_JTextArea.getText()+ "\nFound " 
                        +linkList.size()+ " results");
                //check if there were any results returned
                if(linkList.size() > 0){
                    //set progress text
                    progress_JTextArea.setText(progress_JTextArea.getText()+ 
                            "\nScraping ...");
                    //clear the table
                    clearTable(1);
                    //loop through each link fetched from the search results
                    for(String link : linkList){
                        //set String variables to blank
                        String tagStr = "";
                        String titleStr = "";
                        //get the webpage source for each listing
                        HtmlPage listingPage = client.getPage(link);
                        //get a list of the code containing the titles
                        List<HtmlElement> titles = listingPage.getByXPath("//div"
                                + "[@class='wt-mb-xs-2']/h1");
                        //loop through each title and save to titleStr variable
                        for(HtmlElement title : titles){
                            //get the text element of the fetched code and trim ending whitespace
                            titleStr = title.getTextContent().trim();
                        }//end inner for
                        //get the tags from the listing page using XPath
                        List<HtmlElement> tags = listingPage.getByXPath("//div"
                                + "[@class='tags-section-container tag-cards-section-container-with-images']"
                                + "/ul/li/a/h4");
                        //loop through each tag to merge into one string
                        for(HtmlElement tag : tags){
                            //get a string containing all the tags
                            tagStr += (tag.getTextContent().trim()+ ", ");
                        }//end inner for
                        //add reults to tablerow
                        resultsTableModel.addRow(new Object[]{titleStr, tagStr});
                    }//end outer for
                    //set progress text
                    progress_JTextArea.setText(progress_JTextArea.getText()+ 
                            "\nScrape Completed and fetched " 
                            +resultsTableModel.getRowCount()+ " results");
                }
                else{
                    //set progress text to alert the user of no results found
                    progress_JTextArea.setText(progress_JTextArea.getText()+ 
                            "\nNo results found");
                    //kill the thread
                    return;
                }//end else
                if(resultsTableModel.getRowCount() > 0){
                //count the found tags
                countTags();
                }//end if
            }//end try
            catch(IOException e){
                //set progress text to alert the user to an error
                progress_JTextArea.setText("There was an error connecting to etsy");
                e.printStackTrace();
            }//end catch
            //set progress text
            progress_JTextArea.setText(progress_JTextArea.getText()+ 
                    "\nSequence Complete!");
            //reset the searchUrl
            searchUrl = "https://www.etsy.com/search?q=";
            //end the thread
            return;
        }//end run()
    }//end scrapeHtmlUnit() method
    
    /**********************************************************/
    // Method:	  private void countTags()
    // Purpose:   Counts the times a tag is repeated
    // Inputs:	  void
    // Outputs:   void
    /**********************************************************/
    private void countTags(){
        //clear the top tags table
        clearTable(2);
        //set progress text
        progress_JTextArea.setText(progress_JTextArea.getText()+ "\nCounting the tags used");
        //declare empty String variables
        String tags = "";
        String[] tagArr;
        //loop through the table rows and append all the tags to the String tags
        for(int i = 0; i < resultsTableModel.getRowCount(); i++){
            tags += resultsTableModel.getValueAt(i, 1);
        }//end for
        //create an array variable that splits the tag string by (", ")
        tagArr = tags.split(", ");
        //turn the newly created array into a LinkedList
        List<String> list = new LinkedList<>(Arrays.asList(tagArr));
        //look for duplicate strings
        //reference: https://www.codegrepper.com/code-examples/java/count+duplicates+in+array+java
        //starting string to compare
        for(int i =0; i < list.size() - 1; i++){
            //reset the counter to 1
            int count = 1;
            //second string to compare
            for(int j = i + 1; j < list.size(); j++){
                //compare the strings
                if(list.get(i).equals(list.get(j))){
                    //if matching strings then remove the second string from the array
                    list.remove(j);
                    //increase the counter
                    count++;
                }//end inner if
            }//end in for
            //add the string to the table with the count
            topTableModel.addRow(new Object[]{list.get(i), count});
        }//end outer for
        //check if list is already sorted
        if(sorted == 'n'){
            //sort the top tags table
            sortTable();
        }//end if
    }//end countTags() method
    
    /**********************************************************/
    // Method:	  private void sortTable()
    // Purpose:   Sorts the tag list by highest count
    // Inputs:	  void
    // Outputs:   void
    // Reference: https://www.codejava.net/java-se/swing/6-techniques-for-sorting-jtable-you-should-know - section 2
    /**********************************************************/
    private void sortTable(){
        //create a TableRowSorter Object using the topTableModel
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(topTableModel);
        //set the abover row sorter to the table
        top_JTable.setRowSorter(sorter);
        //declare a List Object to hold the contents of the specified column
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        //set the column to sort
        int columnIndexToSort = 1;
        //add the values of the specifed column index to the sortKeys array
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
        //set the sort keys array to the sorter Object
        sorter.setSortKeys(sortKeys);
        //sort the table
        sorter.sort();
        //set the is sorted variable
        sorted = 'y';
    }//end sortTable() method
    
    
    /***********************************************************************
     * 
     * GET and SET methods for private variables
     * 
     **********************************************************************/
    public static String getip(){
        return proxyIP;
    }
    public static int getPort(){
        return proxyPort;
    }
    public static void setIp(String ip){
        proxyIP = ip;
    }
    public static void setPort(int port){
        proxyPort = port;
    }
    
    
    @SuppressWarnings("Convert2Lambda")
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
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                JFrame frame = new SearchGUI();
                //start maximised
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea progress_JTextArea;
    private javax.swing.JButton reset_JButton;
    private javax.swing.JTable results_JTable;
    private javax.swing.JButton search_JButton;
    private javax.swing.JLabel search_JLabel;
    private javax.swing.JTextField search_JTextField;
    private javax.swing.JLabel title_JLabel;
    private javax.swing.JLabel top_JLabel;
    private javax.swing.JTable top_JTable;
    // End of variables declaration//GEN-END:variables
}
