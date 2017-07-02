package deneme;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Makbuz extends javax.swing.JFrame {
    
  
      
    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    private String tc;

    private DAO dao = new DAO();

    public void setTC(String tc) {
        this.tc = tc;
        baslangic();
    }

    private void VerileriGetir() {
        String sql = "SELECT  *FROM \"SAKINLER\"";
        try {

            baglanti = dao.getBaglanti();
            ifade = baglanti.createStatement();
            sonuc = ifade.executeQuery(sql);
            if (sonuc != null) {
                sonuc.next();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
      public int daire_bul(int nop)
    {
       ResultSet sonuc; 
       int daire_no=0;
       try {
            String sql = "SELECT * FROM \"DAIRE\" "+" WHERE daire_nop="+nop+" ";
            sonuc=ifade.executeQuery(sql);
            
            System.out.println(sql);
            while(sonuc.next())
                daire_no = sonuc.getInt("daire_no");
            sonuc.close();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return daire_no;
    }
    
    
    
    

    private void txtBosalt() {
        txt_ad.setText("");
        txt_soyad.setText("");
        txt_daire_no.setText("");

    }

    private void VerileriGoster() {
        txtBosalt();
        ResultSet sonuc = null;
        int daire=0;
        try {
            ifade = baglanti.createStatement();
            String sql = "SELECT * FROM \"SAKINLER\" "+" WHERE sakin_tc = '" +tc+ "'";

            sonuc = ifade.executeQuery(sql);
            if (sonuc != null && sonuc.next()) {
                txt_ad.setText(sonuc.getString(2));
                txt_soyad.setText(sonuc.getString("sakin_soyadi"));
                daire=sonuc.getInt("daire_no");
                txt_daire_no.setText(String.valueOf(daire_bul(daire)));
            }
            sonuc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void SiteYazdir() {
        ResultSet sonuc = null;
        try {

            sonuc = ifade.executeQuery("SELECT site_adi FROM \"SITE\"");
            if (sonuc != null && sonuc.next()) {

                txt_site.setText(sonuc.getString("site_adi")+"   Sitesi ");
            }
            sonuc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void baslangic() {

        VerileriGetir();
        SiteYazdir();
        VerileriGoster();

    }
      
    public Makbuz() {
        initComponents();
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String tar = df.format(simdikiZaman);
        txt_tarih.setText(tar);
     

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_site = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_daire_no = new javax.swing.JTextField();
        txt_ad = new javax.swing.JTextField();
        txt_soyad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_miktar = new javax.swing.JTextField();
        txt_tarih = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Para Makbuzu");

        txt_site.setEditable(false);
        txt_site.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_siteActionPerformed(evt);
            }
        });

        jLabel2.setText("Tarih:");

        jLabel3.setText("Daire Numarası  ");

        jLabel4.setText("Adı  ");

        jLabel5.setText("Miktar  ");

        jLabel9.setText("Parayı Veren İmza");

        jLabel10.setText("Parayı Alan İmza");

        txt_daire_no.setEditable(false);

        txt_ad.setEditable(false);

        txt_soyad.setEditable(false);

        jLabel6.setText("Soyadı");

        txt_miktar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_miktarActionPerformed(evt);
            }
        });

        txt_tarih.setEditable(false);
        txt_tarih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tarihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_site, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_soyad)
                                    .addComponent(txt_miktar, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(txt_daire_no, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 78, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_site, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_daire_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_siteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_siteActionPerformed

    }//GEN-LAST:event_txt_siteActionPerformed

    private void txt_miktarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_miktarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_miktarActionPerformed

    private void txt_tarihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tarihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tarihActionPerformed

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
            java.util.logging.Logger.getLogger(Makbuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Makbuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Makbuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Makbuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Makbuz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_daire_no;
    private javax.swing.JTextField txt_miktar;
    private javax.swing.JTextField txt_site;
    private javax.swing.JTextField txt_soyad;
    private javax.swing.JTextField txt_tarih;
    // End of variables declaration//GEN-END:variables
}
