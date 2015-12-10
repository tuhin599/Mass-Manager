/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massmanagement;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.sql.ConnectionPoolDataSource;
/**
 *
 * @author tuhin
 */
public class MassManagement {
Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        String propertyName = "sun.java2d.noddraw";
   System.setProperty(propertyName, "true");

   propertyName = "sun.java2d.d3d";
   System.setProperty(propertyName, "false");

   try 
   {
       javax.swing.UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
   }
   catch (Exception ex) 
   {
       ex.printStackTrace();
   }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
      new MassManagement().checkfor();
    }
    public  void checkfor(){
        try{
            File file = new File("millmanage");
            file.setExecutable(true);
            file.setExecutable(true);
            file.setExecutable(true);
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con=DriverManager.getConnection("jdbc:derby:millmanage;create=true","app","");
    
            String sql="select count(*) as counts from login";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                int sc=rs.getInt("counts");
                if(sc>0){
                new login_form().setVisible(true);
                }else{
                new Register_form().setVisible(true);
                }

            }
            con.close();
            pst.close();
            rs.close();
            
            
                    
                    
            
            
            
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    
    
    }
    
}
