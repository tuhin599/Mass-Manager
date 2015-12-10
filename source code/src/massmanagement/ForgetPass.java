/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massmanagement;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Tuhin
 */
public class ForgetPass extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    

    /**
     * Creates new form Register_form
     */
    public ForgetPass() {
        initComponents();
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/heavy.png")));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    
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
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        securitycode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        afterfind = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(449, 275));
        setSize(new java.awt.Dimension(449, 275));
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel4.setText("Email      :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 110, 80, 20);

        email.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        getContentPane().add(email);
        email.setBounds(250, 110, 139, 26);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel5.setText("Security Code :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 150, 113, 20);

        securitycode.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        securitycode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securitycodeActionPerformed(evt);
            }
        });
        securitycode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                securitycodeKeyTyped(evt);
            }
        });
        getContentPane().add(securitycode);
        securitycode.setBounds(250, 144, 139, 26);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 220, 55, 23);

        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(320, 220, 63, 23);

        afterfind.setEditable(false);
        getContentPane().add(afterfind);
        afterfind.setBounds(90, 180, 300, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jframeback.jpg"))); // NOI18N
        jLabel6.setText(" ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, -20, 450, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void securitycodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securitycodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_securitycodeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String mail=email.getText();
        int secure=Integer.parseInt(securitycode.getText());
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 
            con=DriverManager.getConnection("jdbc:derby:millmanage;create=true","app","");
            String sql="select * from login";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                String user=rs.getString("username");
                String pass=rs.getString("password");
                String m=rs.getString("email");
                int sc=rs.getInt("security_code");
                if(mail.equals(m)&&secure==sc){
                afterfind.setText("U= '"+user+"' and P= '"+pass+"' ");
                }else{
                JOptionPane.showMessageDialog(this,"Email / Security Code Not found !!");
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void securitycodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_securitycodeKeyTyped
        char c=evt.getKeyChar();
                    if (!((c >= '0') && (c <= '9') ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                     (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                     evt.consume();}
    }//GEN-LAST:event_securitycodeKeyTyped

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
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField afterfind;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField securitycode;
    // End of variables declaration//GEN-END:variables
}
