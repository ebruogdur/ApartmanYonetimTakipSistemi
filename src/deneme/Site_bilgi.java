
package deneme;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.postgresql.util.PSQLException;



public class Site_bilgi extends javax.swing.JFrame {
   
    private Connection baglanti;
    private Statement ifade;
    private ResultSet sonuc;

    private DAO dao = new DAO();
    
    
    
    private void VerileriGetir()
    {
        String sql = "SELECT  *FROM \"SITE\" ";
        try
        {
            
                baglanti = dao.getBaglanti();
                ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                sonuc = ifade.executeQuery(sql);
                sonuc.next();
               // ifade.close();
   
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void txtBosalt()
    {
        txt_ad.setText("");
        txt_yas.setText("");
        txt_telefon.setText("");
        txt_adres.setText("");
        txt_blok_sayisi.setText("");
        txt_aidat_miktar.setText("");
        txt_ad.requestFocus();
        
    }
    
    private void VerileriGoster()
    {
        txtBosalt();
      
        if(sonuc != null)
        {
            try {
                txt_ad.setText(sonuc.getString("site_adi"));
                txt_yas.setText(sonuc.getString("site_yas"));
                txt_telefon.setText(sonuc.getString("site_tel"));
                txt_adres.setText(sonuc.getString("site_adres"));
                txt_blok_sayisi.setText(sonuc.getString("blok_sayisi"));
                txt_aidat_miktar.setText(sonuc.getString("aidat_miktari"));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void baslangic()
    {
        //txtBosalt();
        VerileriGetir();
        //VerileriGoster();
    }
    public Site_bilgi() {
        initComponents();
        
        baslangic();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_ad = new javax.swing.JLabel();
        lbl_yas = new javax.swing.JLabel();
        lbl_tel = new javax.swing.JLabel();
        lbl_adres = new javax.swing.JLabel();
        lbl_blok_sayisi = new javax.swing.JLabel();
        txt_ad = new javax.swing.JTextField();
        txt_yas = new javax.swing.JTextField();
        txt_telefon = new javax.swing.JTextField();
        txt_adres = new javax.swing.JTextField();
        txt_blok_sayisi = new javax.swing.JTextField();
        btn_kaydet = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        lbl_aidat = new javax.swing.JLabel();
        txt_aidat_miktar = new javax.swing.JTextField();
        txt_islem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("SİTE BİLGİLERİ");

        lbl_ad.setText("AD");

        lbl_yas.setText("YAS");

        lbl_tel.setText("TELEFON");

        lbl_adres.setText("ADRES");

        lbl_blok_sayisi.setText("BLOK SAYISI");

        txt_telefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonActionPerformed(evt);
            }
        });

        btn_kaydet.setText("KAYDET");
        btn_kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kaydetActionPerformed(evt);
            }
        });

        btn_sil.setText("SİL");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        btn_guncelle.setText("GUNCELLE");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        lbl_aidat.setText("AİDAT MİKTARI");

        txt_islem.setEditable(false);
        txt_islem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_islemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tel)
                            .addComponent(lbl_adres)
                            .addComponent(lbl_blok_sayisi)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_kaydet)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_yas)
                                        .addComponent(lbl_ad))
                                    .addGap(57, 57, 57)))
                            .addComponent(lbl_aidat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_blok_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_adres, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(txt_telefon)
                                    .addComponent(txt_ad)
                                    .addComponent(txt_yas))
                                .addComponent(txt_aidat_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_sil, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_islem)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_guncelle)
                        .addContainerGap(144, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ad)
                    .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_yas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_yas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tel)
                    .addComponent(txt_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_adres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_islem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_blok_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_blok_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_aidat)
                            .addComponent(txt_aidat_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_kaydet)
                    .addComponent(btn_sil)
                    .addComponent(btn_guncelle))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonActionPerformed
    
    public int ad_dondur()
    {
        ResultSet sonuc=null;
        String kontrol = null;
        try {
            sonuc = ifade.executeQuery("SELECT * FROM \"SITE\" ");
            if( sonuc.next() && sonuc !=null){
                kontrol = sonuc.getString("site_adi");
                System.out.println(kontrol);
                if(kontrol!=null)
                {
                    System.out.println("a");
                    //sonuc.close();
                    return 0;
                }
            }
            sonuc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
       return 1;
    }
    
    private void btn_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaydetActionPerformed
     
        if(ad_dondur()==1){
        String ad = txt_ad.getText();
        String telefon = txt_telefon.getText();
        String adres = txt_adres.getText();
        int yas_int = Integer.parseInt(txt_yas.getText());
        int blok_sayisi_int = Integer.parseInt(txt_blok_sayisi.getText());
        int aidat_miktar_int = Integer.parseInt(txt_aidat_miktar.getText());
            
            String sql = "INSERT INTO \"SITE\" (site_adi,site_yas,site_tel,site_adres,aidat_miktari,blok_sayisi) VALUES('"+ad+"', "+yas_int+", '"+telefon+"', '"+adres+"', "+aidat_miktar_int+", "+blok_sayisi_int+")";
            //VerileriGoster();         
        try{
     
             // ifade = baglanti.createStatement();
              ifade.execute(sql);
              ifade.close();
              VerileriGetir();
              txtBosalt();
              String islem = "KAYDETME İSLEMİNİZ\nTAMAMLANMISTIR";
              txt_islem.setText(islem);
           
            
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        else
        {
            txt_islem.setText("Baska Site Ekleyemezsiniz");
        }
                     
      
      
      
        
    }//GEN-LAST:event_btn_kaydetActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        try
        {
          
            String sql = " DELETE FROM \"SITE\" "+" WHERE site_adi = '"+txt_ad.getText()+"' ";
            
            System.out.println(sql);
            ifade.execute(sql);
            
       
            ifade.close();
            VerileriGetir();
            txtBosalt();
            String islem = "SİLME İSLEMİNİZ\nTAMAMLANMISTIR";
            txt_islem.setText(islem);
            //VerileriGoster();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
      
        
  
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        String ad = txt_ad.getText();
        String telefon = txt_telefon.getText();
        String adres = txt_adres.getText();
        int yas_int = Integer.parseInt(txt_yas.getText());
        int blok_sayisi_int = Integer.parseInt(txt_blok_sayisi.getText());
        int aidat_miktar_int = Integer.parseInt(txt_aidat_miktar.getText());
      
        
       
        try
        {
           // ifade = baglanti.createStatement();
            String sql = " UPDATE \"SITE\" SET "+
                    "site_adi='"+ad+"'"+
                    ", site_tel='"+telefon+"'"+
                    ", site_adres='"+adres+"'"+
                    ", site_yas="+yas_int+
                    ", blok_sayisi="+blok_sayisi_int+
                    ", aidat_miktari="+aidat_miktar_int+
                    " WHERE site_adi = '"+txt_ad.getText()+"' ";
            System.out.println(sql);
            ifade.execute(sql);
            
        
            ifade.close();
            VerileriGetir();
            VerileriGoster();
            txtBosalt();
            String islem = "GUNCELLEME İSLEMİNİZ\nTAMAMLANMISTIR";
            txt_islem.setText(islem);
            //txtBosalt();
            //VerileriGoster();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void txt_islemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_islemActionPerformed
        //String islem = "tamamlandi";
        
    }//GEN-LAST:event_txt_islemActionPerformed

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
            java.util.logging.Logger.getLogger(Site_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Site_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Site_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Site_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Site_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_kaydet;
    private javax.swing.JButton btn_sil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_ad;
    private javax.swing.JLabel lbl_adres;
    private javax.swing.JLabel lbl_aidat;
    private javax.swing.JLabel lbl_blok_sayisi;
    private javax.swing.JLabel lbl_tel;
    private javax.swing.JLabel lbl_yas;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_adres;
    private javax.swing.JTextField txt_aidat_miktar;
    private javax.swing.JTextField txt_blok_sayisi;
    private javax.swing.JTextField txt_islem;
    private javax.swing.JTextField txt_telefon;
    private javax.swing.JTextField txt_yas;
    // End of variables declaration//GEN-END:variables

    /*private void verileriGetir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

