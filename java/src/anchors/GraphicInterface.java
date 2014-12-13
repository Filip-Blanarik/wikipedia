/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

/**
 *
 * @author Filip
 */
public class GraphicInterface extends javax.swing.JFrame {

    /**
     * Creates new form GraphicInterface
     */
    public GraphicInterface() {
        initComponents();
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
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AnchorTextAndStatisctics");
        setName("AnchorTextAndStatistics"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setText("../data/sample_input_enwiki-pages-articles-123.xml");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField2.setText("../data/program_anchor_output.txt");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("XML Source file:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Parsed XML Output file:");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Calculate Statistics for anchor link");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField3.setText("../data/program_anchor_output.txt");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Input file for statistics:");

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField4.setText("../data/Statistics/program_output_sorted");

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setText("Calculate Statistics for anchor text");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setText("Parse XML file");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Statistics output file name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String  file_input = jTextField3.getText();
        jTextArea1.setText("");
        jTextArea1.setForeground(Color.black);  jTextArea1.append("Anchor LINK statistics:\n");
        try {
            BufferedReader brstat = new BufferedReader(new InputStreamReader(new FileInputStream(file_input), "UTF8"));
               
            File_with_anchor_txt fa = new File_with_anchor_txt(null, null, brstat, null, null);
            Statistics stat = new Statistics(brstat, fa, null, jTextArea1);   
		
            jTextArea1.setForeground(Color.black);  jTextArea1.append("\tCreating hash map from file\n");
            Map<String, Frequencies> map;
            map = stat.hash_map(0);	//1 -> hash_map of anchor_text | 0 -> hash_map of anchor_links
            brstat.close();
       	    jTextArea1.setForeground(Color.black);  jTextArea1.append("\tHash map is complete, size of hash_map: " + map.size() + "\n");
            
            jTextArea1.setForeground(Color.black);  jTextArea1.append("Sorting hash map by Collection frequency\n");
            Map<String, Frequencies> SortedMap;
	    SortedMap = stat.sort_hash_map_CF(map);
            jTextArea1.setForeground(Color.black);  jTextArea1.append("\tSorting completed\n\n");
            stat.iterate_hash_map(SortedMap, 10);
      
            stat.print_hash_map_to_file(SortedMap, 0, jTextField4.getText() + "_ANCHOR_LINK_CF.TXT");
       
            jTextArea1.setForeground(Color.black);  jTextArea1.append("Sorting hash map by Document frequency\n");
            SortedMap = stat.sort_hash_map_DF(map);
            jTextArea1.setForeground(Color.black);  jTextArea1.append("\tSorting completed\n\n");
            stat.iterate_hash_map(SortedMap, 10);
        
            stat.print_hash_map_to_file(SortedMap, 0, jTextField4.getText() + "_ANCHOR_LINK_DF.TXT");
        
            jTextArea1.setForeground(Color.black);  jTextArea1.append("\nAverage ANCHOR LINK statistics\n");
            stat.average_CF_DF(map);
         
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String  file_input = jTextField3.getText();
        jTextArea1.setText("");
        jTextArea1.setForeground(Color.black);  jTextArea1.append("Anchor TEXT statistics:\n");
        try {
            BufferedReader brstat = new BufferedReader(new InputStreamReader(new FileInputStream(file_input), "UTF8"));
               
            File_with_anchor_txt fa = new File_with_anchor_txt(null, null, brstat, null, null);
            Statistics stat = new Statistics(brstat, fa, null, jTextArea1);   
		
            jTextArea1.setForeground(Color.black);  jTextArea1.append("Creating hash map\n");
            Map<String, Frequencies> map;
            map = stat.hash_map(1);	//1 -> hash_map of anchor_text | 0 -> hash_map of anchor_links
            brstat.close();
       	    jTextArea1.setForeground(Color.black);  jTextArea1.append("\tHash map is complete, size of hash_map: " + map.size() + "\n");
            
            jTextArea1.setForeground(Color.black);  jTextArea1.append("Sorting hash map by Collection frequency" + "\n");
            Map<String, Frequencies> SortedMap;
	    SortedMap = stat.sort_hash_map_CF(map);
            jTextArea1.setForeground(Color.black);  jTextArea1.append("\tSorting completed" + "\n\n");
            stat.iterate_hash_map(SortedMap, 10);
      
            stat.print_hash_map_to_file(SortedMap, 0, jTextField4.getText() + "_ANCHOR_TEXT_CF.TXT");
       
            jTextArea1.setForeground(Color.black);  jTextArea1.append("Sorting hash map by Document frequency" + "\n");
            SortedMap = stat.sort_hash_map_DF(map);
            jTextArea1.setForeground(Color.black);  jTextArea1.append("\tSorting completed" + "\n\n");
            stat.iterate_hash_map(SortedMap, 10);
        
            stat.print_hash_map_to_file(SortedMap, 0, jTextField4.getText() + "_ANCHOR_TEXT_DF.TXT");
            
            jTextArea1.setForeground(Color.black);  jTextArea1.append("\nAverage ANCHOR TEXT statistics\n");
            stat.average_CF_DF(map);
         
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String file_input = jTextField1.getText();
        String file_output = jTextField2.getText();
        jTextArea1.setText("");
        jTextArea1.setForeground(Color.black);  jTextArea1.append("Parsing XML file\n");
        BufferedWriter bw;
        BufferedReader br; 
        List<Page> record_list = new ArrayList<Page>();
        
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_output, true),"UTF-8"));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file_output), "UTF8"));
     
            File_with_anchor_txt file = new File_with_anchor_txt(file_output, bw, br, record_list, jTextArea1);
            Parse_XML_wiki xmlw = new Parse_XML_wiki(file_input, file, jTextArea1);
		
            file.erase_file();	//delete existing record in file
            xmlw.read_wiki();	//extract page title, anchor link and anchor text from file input

            bw.close();	//close text file
            br.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, ex);
            jTextArea1.setForeground(Color.red);    jTextArea1.setText(ex.getMessage());
        }     
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}