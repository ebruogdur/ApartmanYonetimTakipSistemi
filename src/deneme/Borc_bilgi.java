/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asuss
 */
public class Borc_bilgi extends javax.swing.JFrame {

    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    
    private DAO dao = new DAO();
    
    private void VerileriGetir()
    {
        String sql = "SELECT  *FROM \"AIDAT\"";
        try
        {
            
                baglanti = dao.getBaglanti();
                ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                sonuc = ifade.executeQuery(sql);
                sonuc.next();
                //ifade.close();
                
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
        
        
    public Borc_bilgi() {
        initComponents();
        VerileriGetir();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_goster = new javax.swing.JButton();
        txt_tc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_toplam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_goster = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_goster.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_goster.setText("Göster");
        btn_goster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gosterActionPerformed(evt);
            }
        });

        txt_tc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sakin TC Giriniz");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Toplam Borç                     :");

        txt_goster.setColumns(20);
        txt_goster.setRows(5);
        jScrollPane1.setViewportView(txt_goster);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("AYLARA GORE BORC DURUMU:");

        jButton1.setText("TEMİZLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_goster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_toplam))
                    .addComponent(jButton1))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_goster)
                    .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_gosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gosterActionPerformed
        
        int ocak;
        int subat;
        int mart;
        int nisan;
        int mayis;
        int haziran;
        int temmuz;
        int agus;
        int eylul;
        int ekim;
        int kasim;
        int aralik;
        
        
        try {
            
            ResultSet sonuc;
            int toplam;
            
            String tc =txt_tc.getText();
            
            String sql="SELECT * FROM \"AIDAT\" "+" WHERE sakin_tc='"+tc+"' ";
            sonuc= ifade.executeQuery(sql);
            sonuc.next();
            
            ocak=sonuc.getInt("ocak");
            
            subat=sonuc.getInt("subat");
            mart=sonuc.getInt("mart");
            nisan=sonuc.getInt("nisan");
            mayis=sonuc.getInt("mayis");
            haziran=sonuc.getInt("haziran");
            temmuz=sonuc.getInt("temmuz");
            agus=sonuc.getInt("agustos");
            eylul=sonuc.getInt("eylul");
            ekim=sonuc.getInt("ekim");
            kasim=sonuc.getInt("kasim");
            aralik=sonuc.getInt("aralik");
            
            toplam =ocak+subat+mart+nisan+mayis+haziran+temmuz+agus+eylul+ekim+kasim+aralik;
            txt_goster.setText("");
            txt_toplam.setText(String.valueOf(toplam));
            
            if(sonuc.getInt("ocak")!=0){
                int o= sonuc.getInt("ocak");
                String kelime = String.valueOf(o);
                String cumle="ocak" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
            }
            
            if(sonuc.getInt("subat")!=0){
                int o= sonuc.getInt("subat");
                String kelime = String.valueOf(o);
                String cumle="subat" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
               
                
            }
            if(sonuc.getInt("mart")!=0){
               int o= sonuc.getInt("mart");
                String kelime = String.valueOf(o);
                String cumle="mart" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
             
            }
            if(sonuc.getInt("nisan")!=0){
                int o= sonuc.getInt("nisan");
                String kelime = String.valueOf(o);
                String cumle="nisan" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
              
                
            }
            if(sonuc.getInt("mayis")!=0){
                 int o= sonuc.getInt("mayis");
                String kelime = String.valueOf(o);
                String cumle="mayis" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
             
                
            }
            if(sonuc.getInt("haziran")!=0){
                int o= sonuc.getInt("haziran");
                String kelime = String.valueOf(o);
                String cumle="haziran" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
            }
            if(sonuc.getInt("temmuz")!=0){
                 int o= sonuc.getInt("temmuz");
                String kelime = String.valueOf(o);
                String cumle="temmuz" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
            }
            if(sonuc.getInt("agustos")!=0){
                 int o= sonuc.getInt("agustos");
                String kelime = String.valueOf(o);
                String cumle="agustos" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
            }
            if(sonuc.getInt("eylul")!=0){
                int o= sonuc.getInt("eylul");
                String kelime = String.valueOf(o);
                String cumle="eylul" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
            }
            if(sonuc.getInt("ekim")!=0){
                int o= sonuc.getInt("ekim");
                String kelime = String.valueOf(o);
                String cumle="ekim" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);   
            }
            if(sonuc.getInt("kasim")!=0){
                int o= sonuc.getInt("kasim");
                String kelime = String.valueOf(o);
                String cumle="kasim" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
            }
            if(sonuc.getInt("aralik")!=0){
                int o= sonuc.getInt("aralik");
                String kelime = String.valueOf(o);
                String cumle="aralik" + ":  " + kelime+ "\n";
                txt_goster.append(cumle);
            }
           
            
            
            sonuc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
     
       
    }//GEN-LAST:event_btn_gosterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       txt_goster.setText("");
       txt_tc.setText("");
       txt_toplam.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Borc_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borc_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borc_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borc_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Borc_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_goster;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_goster;
    private javax.swing.JTextField txt_tc;
    private javax.swing.JTextField txt_toplam;
    // End of variables declaration//GEN-END:variables
}
