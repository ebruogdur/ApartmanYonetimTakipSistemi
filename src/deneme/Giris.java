/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme;

import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Giris extends javax.swing.JFrame {
   private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
   
    private DAO dao = new DAO();
    
   public class Aktivite{
       int no;
       String bas;
       String son;
       String tip;
       
   }
    
    
    private void VerileriGetir()
    {
        String sql = "SELECT  *FROM \"AKTIVITE\"";
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
    
   
    public Giris() {
        initComponents();
        Tarih_dondur();
        
    }
    
    
    public void Tarih_dondur()
    {
        VerileriGetir();
        ArrayList<Aktivite> AktiviteListem=new ArrayList<Aktivite>();
        long Fark=0;
        ResultSet sonuc;
        String tarih="";
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          //System.out.println(simdikiZaman.getTime());
        String tar= df.format(simdikiZaman);
       // System.out.println(tar);
        Date Gel_tarih;
        
        try {
           
           sonuc=ifade.executeQuery("SELECT * FROM \"AKTIVITE\" ");
           //sonuc.next();
           while(sonuc.next()){
                tarih=sonuc.getString("bas_tarihi");
                try {
                    Gel_tarih = df.parse(tarih);
                    long diff = Gel_tarih.getTime()-simdikiZaman.getTime();
                    System.out.println(Gel_tarih.getTime());
                    System.out.println(simdikiZaman.getTime());
                    Fark= TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    System.out.println(Fark);
                    if(Fark <=5)
                    {
                        Aktivite akt=new Aktivite();
                        akt.no = sonuc.getInt("aktivite_no");
                        akt.bas=sonuc.getString("bas_tarihi");
                        akt.son=sonuc.getString("bit_tarihi");
                        akt.tip=sonuc.getString("aktivite_tipi");
                        AktiviteListem.add(akt);
                    }
                    
                
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
           }
            System.out.println(AktiviteListem);
           String dizim[][]=new String[AktiviteListem.size()][];
                for (int i = 0; i < AktiviteListem.size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(AktiviteListem.get(i).no),
                     valueOf(AktiviteListem.get(i).bas),
                     valueOf(AktiviteListem.get(i).son),
                     valueOf(AktiviteListem.get(i).tip)                                 
                     };
                                      
                    }
                
                TableModel tabloModeli=new DefaultTableModel(
                dizim,
                new String[] {"Aktivite Numarası", "Baslama Tarihi", "Bitis Tarihi","Aktivite Tipi" }                                                
                    );
                tbl_aktivite.setModel(tabloModeli);
                
                
       
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
      
    }


    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_blok_bilgi = new javax.swing.JButton();
        btn_sakin_bilgi = new javax.swing.JButton();
        btn_yapilacaklar = new javax.swing.JButton();
        btn_aidat_odeyen = new javax.swing.JButton();
        btn_aidat_odemeyen = new javax.swing.JButton();
        btn_makbuz = new javax.swing.JButton();
        btn_daire_borc = new javax.swing.JButton();
        btn_daire_bilgi = new javax.swing.JButton();
        btn_gider = new javax.swing.JButton();
        btn_site_bilgi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_aktivite = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("YAPILACAK İŞLEMLER");

        btn_blok_bilgi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_blok_bilgi.setText("Sitenin blok  bilgileri");
        btn_blok_bilgi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_blok_bilgiActionPerformed(evt);
            }
        });

        btn_sakin_bilgi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_sakin_bilgi.setText("Daire sakinlerinin bilgileri ");
        btn_sakin_bilgi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sakin_bilgiActionPerformed(evt);
            }
        });

        btn_yapilacaklar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_yapilacaklar.setText(" Yapılacak işler için hatırlatma");
        btn_yapilacaklar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yapilacaklarActionPerformed(evt);
            }
        });

        btn_aidat_odeyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_aidat_odeyen.setText("Aidat ödeyenlerin listesi ");
        btn_aidat_odeyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aidat_odeyenActionPerformed(evt);
            }
        });

        btn_aidat_odemeyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_aidat_odemeyen.setText("Aidat ödemeyenlerin listesi");
        btn_aidat_odemeyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aidat_odemeyenActionPerformed(evt);
            }
        });

        btn_makbuz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_makbuz.setText("Makbuz çıktısı");
        btn_makbuz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_makbuzActionPerformed(evt);
            }
        });

        btn_daire_borc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_daire_borc.setText("Daireye ait borç dökümü");
        btn_daire_borc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daire_borcActionPerformed(evt);
            }
        });

        btn_daire_bilgi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_daire_bilgi.setText("Sitenin daire bilgileri");
        btn_daire_bilgi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daire_bilgiActionPerformed(evt);
            }
        });

        btn_gider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_gider.setText("Sitenin aylık giderleri");
        btn_gider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_giderActionPerformed(evt);
            }
        });

        btn_site_bilgi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_site_bilgi.setText("Site bilgileri");
        btn_site_bilgi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_site_bilgiActionPerformed(evt);
            }
        });

        tbl_aktivite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_aktivite);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("5 gün içerisinde yapılacak aktiviteler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_sakin_bilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_daire_bilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_yapilacaklar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_makbuz, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_daire_borc, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_aidat_odeyen, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_aidat_odemeyen, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_blok_bilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_gider, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_site_bilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_site_bilgi)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(btn_blok_bilgi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_daire_bilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sakin_bilgi)
                        .addGap(18, 18, 18)
                        .addComponent(btn_yapilacaklar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_aidat_odeyen)
                        .addGap(18, 18, 18)
                        .addComponent(btn_aidat_odemeyen)
                        .addGap(18, 18, 18)
                        .addComponent(btn_makbuz)
                        .addGap(18, 18, 18)
                        .addComponent(btn_daire_borc)
                        .addGap(18, 18, 18)
                        .addComponent(btn_gider)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Blok_bilgi blok_nesne = new Blok_bilgi();
    public Site_bilgi site_nesne = new Site_bilgi();
    public Sakin_bilgi sakin_nesne = new Sakin_bilgi();
    public Aidat_odemeyenler_bilgi odemeyen_nesne = new Aidat_odemeyenler_bilgi();
    public Aidat_odeyenler_bilgi odeyen_nesne = new Aidat_odeyenler_bilgi();
    public Aktivite_bilgi aktivite_nesne = new Aktivite_bilgi();
    public Makbuz_Sorgu makbuz_nesne = new Makbuz_Sorgu();
    public Borc_bilgi borc_nesne = new Borc_bilgi();
    public Gider_bilgi gider_nesne = new Gider_bilgi();
    public Daire_bilgi daire_nesne = new Daire_bilgi();
    
    
    
    
    
    
    private void btn_blok_bilgiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_blok_bilgiActionPerformed
        if(blok_nesne == null)
        {
            blok_nesne = new Blok_bilgi();
        }
        blok_nesne.setVisible(true);   
    }//GEN-LAST:event_btn_blok_bilgiActionPerformed

    private void btn_sakin_bilgiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sakin_bilgiActionPerformed
        sakin_nesne.setVisible(true);
    }//GEN-LAST:event_btn_sakin_bilgiActionPerformed

    private void btn_site_bilgiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_site_bilgiActionPerformed

        site_nesne.setVisible(true);
    }//GEN-LAST:event_btn_site_bilgiActionPerformed

    private void btn_daire_bilgiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daire_bilgiActionPerformed
        daire_nesne.setVisible(true);
    }//GEN-LAST:event_btn_daire_bilgiActionPerformed

    private void btn_yapilacaklarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yapilacaklarActionPerformed
        aktivite_nesne.setVisible(true);
    }//GEN-LAST:event_btn_yapilacaklarActionPerformed

    private void btn_aidat_odeyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aidat_odeyenActionPerformed
        odeyen_nesne.setVisible(true);
    }//GEN-LAST:event_btn_aidat_odeyenActionPerformed

    private void btn_aidat_odemeyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aidat_odemeyenActionPerformed
        odemeyen_nesne.setVisible(true);
    }//GEN-LAST:event_btn_aidat_odemeyenActionPerformed

    private void btn_makbuzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_makbuzActionPerformed
        makbuz_nesne.setVisible(true);
    }//GEN-LAST:event_btn_makbuzActionPerformed

    private void btn_daire_borcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daire_borcActionPerformed
        borc_nesne.setVisible(true);
    }//GEN-LAST:event_btn_daire_borcActionPerformed

    private void btn_giderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_giderActionPerformed
        gider_nesne.setVisible(true);
    }//GEN-LAST:event_btn_giderActionPerformed

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
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aidat_odemeyen;
    private javax.swing.JButton btn_aidat_odeyen;
    private javax.swing.JButton btn_blok_bilgi;
    private javax.swing.JButton btn_daire_bilgi;
    private javax.swing.JButton btn_daire_borc;
    private javax.swing.JButton btn_gider;
    private javax.swing.JButton btn_makbuz;
    private javax.swing.JButton btn_sakin_bilgi;
    private javax.swing.JButton btn_site_bilgi;
    private javax.swing.JButton btn_yapilacaklar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_aktivite;
    // End of variables declaration//GEN-END:variables
}
