/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javaapplication2.addTrain;
import java.sql.*;

/**
 *
 * @author ekans
 */
public class addTrain extends javax.swing.JFrame{
    
    Connection conn = null;
    PreparedStatement pst;
    ResultSet rs;
   
    
    public addTrain() {
        initComponents();
        connect();
        Train_Details();
    }
    
    
    public void connect(){
        
        try{
            
            Class.forName("org.sqlite.JDBC");
            
            
            try{
                String url = "jdbc:sqlite:temp.db";
                conn = DriverManager.getConnection(url);
                System.out.println("Connection done");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            
        } 
        catch(ClassNotFoundException ex){
            Logger.getLogger(addTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void Train_Details(){
        try {
            pst=conn.prepareStatement("select * from traindetails");
            rs=pst.executeQuery();
            
            ResultSetMetaData rsd=rs.getMetaData();
            int c;
            c=rsd.getColumnCount();
            DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()){
                Vector v=new Vector();
                for (int i=0;i<=c;i++){
                    v.add(rs.getString("tnumber"));
                    v.add(rs.getString("tName"));
                    v.add(rs.getString("tstartplace"));
                    v.add(rs.getString("tDplace"));
                    v.add(rs.getString("jTextField5"));
                }
                d.addRow( v);
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(addTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
         DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
           
          int selectIndex =jTable1.getSelectedRow();
          txttrainno.setText(d.getValueAt(selectIndex,  0).toString());
          tName.setText(d.getValueAt(selectIndex,  1).toString());
          tStartplace.setText(d.getValueAt(selectIndex,  2).toString());
          tDplace.setText(d.getValueAt(selectIndex,  3).toString());
          jTextField5.setText(d.getValueAt(selectIndex,  4).toString());
        
          jButton2.setEnabled(false);
        
        }
        
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         String tno=txttrainno.getText();
        String trainname=tName.getText();
        String startplace=tStartplace.getText();
        String dplace=tDplace.getText();
        String price=jTextField5.getText();
        
        try {
            pst=conn.prepareStatement("update traindetails set tName=?,tStartplace=?,tDplace=?,jTextField5=? where  tnumber=?");
            
           // pst.setInt(1,Integer.valueOf(tno.trim()));
            pst.setString(1,trainname );
            pst.setString(2,startplace);
            pst.setString(3,dplace);
            pst.setInt(4,Integer.valueOf(price.trim()) );
            pst.setInt(5,Integer.valueOf(tno.trim()));
            int k=pst.executeUpdate();
           
            if(k==1){
              JOptionPane.showMessageDialog(this,"Record  Updated") ;
            }
            else{
                JOptionPane.showMessageDialog(this,"Record  Failed") ;
            }
            
            txttrainno.setText("");
            tName.setText("");
            tStartplace.setText("");
            tDplace.setText("");
            jTextField5.setText("");
            txttrainno.requestFocus();
             Train_Details();
            
             jButton2.setEnabled( true);
            
           /* tName.requestFocus();
             txttrainno.requestFocus();
             txttrainno.requestFocus();
             txttrainno.requestFocus();*/
             
            
            
        } catch (SQLException ex) {
            Logger.getLogger(addTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         String tno=txttrainno.getText();
       
        
        try {
            pst=conn.prepareStatement(" Delete from traindetails where  tnumber=?");
            
           // pst.setInt(1,Integer.valueOf(tno.trim()));
            pst.setString(1,tno);
             
            int k=pst.executeUpdate();
           
            if(k==1){
              JOptionPane.showMessageDialog(this,"Record   Deleted") ;
            }
            else{
                JOptionPane.showMessageDialog(this,"Record  Failed") ;
            }
            
            txttrainno.setText("");
            tName.setText("");
            tStartplace.setText("");
            tDplace.setText("");
            jTextField5.setText("");
            txttrainno.requestFocus();
             Train_Details();
            
             jButton2.setEnabled( true);
            
           /* tName.requestFocus();
             txttrainno.requestFocus();
             txttrainno.requestFocus();
             txttrainno.requestFocus();*/
         } catch (SQLException ex) {
            Logger.getLogger(addTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
          private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Train_Details();
            
             jButton2.setEnabled( true);
        
    }  
          
          /*public void LoadCategory()
          {
              Connection con1=null;
              PreparedStatement insert=null;
              ResultSet rs=null;
              try
              {
                  Class.forName(className)
              }
          }*/
 /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txttrainno = new javax.swing.JTextField();
        tName = new javax.swing.JTextField();
        tStartplace = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tDplace = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
         jButton4 = new javax.swing.JButton();

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("    Train No");

        txttrainno.setText(" ");

        tName.setText(" ");
        tName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNameActionPerformed(evt);
            }
        });

        tStartplace.setText(" ");

        jLabel2.setText(" Destination");

        tDplace.setText(" ");

        jLabel3.setText(" Price");

        jLabel4.setText("Train Name");

        jLabel5.setText("Start Place");

        jTextField5.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tStartplace, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttrainno, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDplace, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txttrainno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tStartplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jButton1.setText(" Edit");
         jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(" Add Train");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(" Delete");
         jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
         jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "TrainNumber", "Train Name", "Start Place", "D Place", "Price"
            }
        ));
         
          jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        
          jScrollPane1.setViewportView(jTable1);

        /*jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", " Title 3", "Title 4"
            }
        ));*/
       // jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText(" Add Train");
        
        jButton4.setText(" Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton2)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>                        

    
    private void tNameActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String tno=txttrainno.getText();
        String trainname=tName.getText();
        String startplace=tStartplace.getText();
        String dplace=tDplace.getText();
        String price=jTextField5.getText();
        
        try {
            pst=conn.prepareStatement("insert into traindetails values(?,?,?,?,?)");
            
            pst.setInt(1,Integer.valueOf(tno.trim()));
            pst.setString(2,trainname );
            pst.setString(3,startplace);
            pst.setString(4,dplace);
            pst.setInt(5,Integer.valueOf(price.trim()) );
            int k=pst.executeUpdate();
           
            if(k==1){
              JOptionPane.showMessageDialog(this,"Record Added") ;
            }
            else{
                JOptionPane.showMessageDialog(this,"Record  Failed") ;
            }
            
            txttrainno.setText("");
            tName.setText("");
            tStartplace.setText("");
            tDplace.setText("");
            jTextField5.setText("");
            txttrainno.requestFocus();
            
             Train_Details();
              tName.requestFocus();
             txttrainno.requestFocus();
             txttrainno.requestFocus();
             txttrainno.requestFocus();
            
        } catch (SQLException ex) {
            Logger.getLogger(addTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
     

    
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
            java.util.logging.Logger.getLogger(addTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addTrain().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
     private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField tDplace;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tStartplace;
    private javax.swing.JTextField txttrainno;
    // End of variables declaration       
}
