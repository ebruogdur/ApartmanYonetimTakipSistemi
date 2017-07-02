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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author asuss
 */
public class Gider_bilgi extends javax.swing.JFrame {

    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
   
   private DAO dao = new DAO();
   
   
   public class Gider{
       int gider_no;
       String icerik;
       String tarih;
       int miktar;
   }
   
   public void tabloyuDoldur()
       {
           ArrayList<Gider> GiderListem=new ArrayList<Gider>();
           
           String sql = "SELECT  *FROM \"GIDER\"";
            try
            {
                ResultSet sonuc = ifade.executeQuery(sql);
                while (sonuc.next()) 
                {
                    Gider gider=new Gider();
                    gider.gider_no = sonuc.getInt("gider_no");
                    gider.icerik=sonuc.getString("gider_tipi");
                    gider.miktar=sonuc.getInt("gider_miktar");
                    gider.tarih=sonuc.getString("gider_tarih");
                    GiderListem.add(gider);
                }
                String dizim[][]=new String[GiderListem.size()][];
                for (int i = 0; i < GiderListem.size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(GiderListem.get(i).gider_no),
                     valueOf(GiderListem.get(i).icerik),
                     valueOf(GiderListem.get(i).miktar),
                     valueOf(GiderListem.get(i).tarih)                                 
                     };
                                      
                    }
                
                TableModel tabloModeli=new DefaultTableModel(
                dizim,
                new String[] {"Gider Numarası", "Gider Tipi", "Gider Miktarı","Gider Tarihi" }                                                
                    );
                tbl_gider.setModel(tabloModeli);
                
                
                
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
       }
   
   
   
   private void VerileriGetir()
    {
        String sql = "SELECT  *FROM \"GIDER\"";
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
   
    private void txtBosalt()
    {
        txt_tipi.setText("");
        txt_miktar.setText("");
        txt_tarih.setText("");
        txt_no.setText("");
    }
    
    private void VerileriGoster()
    {
        txtBosalt();
      
        if(sonuc != null)
        {
            try {
                txt_tipi.setText(sonuc.getString("gider_tipi"));
                txt_miktar.setText(sonuc.getString("gider_miktar"));
                txt_tarih.setText(sonuc.getString("gider_tarih"));
                txt_no.setText(sonuc.getString("gider_no"));
                
                } catch (SQLException ex) 
                {
                ex.printStackTrace();
                }
        }
        
    }

    public void baslangic()
    {
        //txtBosalt();
        VerileriGetir();
        tabloyuDoldur();
       // VerileriGoster();
    }
   
    
    public Gider_bilgi() {
        initComponents();
        baslangic();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_tipi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_miktar = new javax.swing.JTextField();
        txt_tarih = new javax.swing.JTextField();
        btn_kaydet = new javax.swing.JButton();
        txt_sil = new javax.swing.JButton();
        txt_guncelle = new javax.swing.JButton();
        txt_no = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_gider = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("gider tipi");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("toplam miktar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("tarih");

        btn_kaydet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_kaydet.setText("kaydet");
        btn_kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kaydetActionPerformed(evt);
            }
        });

        txt_sil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_sil.setText("sil");
        txt_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_silActionPerformed(evt);
            }
        });

        txt_guncelle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_guncelle.setText("guncelle");
        txt_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_guncelleActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("gider no");

        tbl_gider.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_gider);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tüm Giderler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tipi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_guncelle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_kaydet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addComponent(txt_sil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55)
                        .addComponent(txt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_tipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btn_kaydet)
                        .addGap(18, 18, 18)
                        .addComponent(txt_sil)
                        .addGap(18, 18, 18)
                        .addComponent(txt_guncelle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaydetActionPerformed
        String gider_tipi = txt_tipi.getText();
        //String gider_miktar = txt_miktar.getText();
        String gider_tarih = txt_tarih.getText();
        //String gider_no = txt_no.getText();
        
        int miktar_int = Integer.parseInt(txt_miktar.getText());
        int no_int = Integer.parseInt(txt_no.getText());
        
        String sql = "INSERT INTO \"GIDER\"(gider_no,gider_tipi,gider_tarih,gider_miktar) VALUES("+no_int+",'"+gider_tipi+"', '"+gider_tarih+"', "+miktar_int+" )";
        
        try{
            
              ifade.execute(sql);
              ifade.close();
              VerileriGetir();
              txtBosalt();
              tabloyuDoldur();
              //VerileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_kaydetActionPerformed

    private void txt_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_silActionPerformed
        try
        {
            //ifade = baglanti.createStatement();
            String sql =  " DELETE FROM \"GIDER\" "+" WHERE gider_no = '"+txt_no.getText()+"' ";
            System.out.println(sql);
            ifade.execute(sql);
            ifade.close();
            VerileriGetir();
            txtBosalt();
            tabloyuDoldur();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_silActionPerformed

    private void txt_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_guncelleActionPerformed
        String tipi = txt_tipi.getText();
        //String miktar = txt_miktar.getText();
        String tarih = txt_tarih.getText();
        //String no = txt_no.getText();
        int miktar_int = Integer.parseInt(txt_miktar.getText());
        int no_int = Integer.parseInt(txt_no.getText());
        try
        {
           // ifade = baglanti.createStatement();
            String sql = " UPDATE \"GIDER\" SET "+
                    "gider_no="+no_int+
                    ", gider_miktar="+miktar_int+
                    ", gider_tipi='"+tipi+"'"+
                    ", gider_tarih='"+tarih+"'"+
                    
                    " WHERE gider_no = '"+txt_no.getText()+"' ";
            System.out.println(sql);
            ifade.execute(sql);
            ifade.close();
            VerileriGetir();
            VerileriGoster();
            tabloyuDoldur();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_guncelleActionPerformed

    
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
            java.util.logging.Logger.getLogger(Gider_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gider_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gider_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gider_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gider_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kaydet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_gider;
    private javax.swing.JButton txt_guncelle;
    private javax.swing.JTextField txt_miktar;
    private javax.swing.JTextField txt_no;
    private javax.swing.JButton txt_sil;
    private javax.swing.JTextField txt_tarih;
    private javax.swing.JTextField txt_tipi;
    // End of variables declaration//GEN-END:variables
}
