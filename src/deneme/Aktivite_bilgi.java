package deneme;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Aktivite_bilgi extends javax.swing.JFrame {
    
    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
   
    private DAO dao = new DAO();
   
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
    
    
    public class Aktivite 
    {
        int numarasi;
        String bas;
        String tip;
        String son;
        
      
    }
    
    private void txtBosalt()
    {
        txt_ak.setText("");
        txt_bas.setText("");
        txt_bit.setText("");
        txt_tip.setText("");
    }
    
    
    private void VerileriGoster()
    {
        txtBosalt();
      
        if(sonuc != null)
        {
            try {
                txt_ak.setText(sonuc.getString("aktivite_no"));
                txt_bas.setText(sonuc.getString("bas_tarihi"));
                txt_bit.setText(sonuc.getString("bit_tarihi"));
                txt_tip.setText(sonuc.getString("aktivite_tipi"));
                
                } catch (SQLException ex) 
                {
                ex.printStackTrace();
                }
        }
        
    }
    public String ayarla(){
       String site_adi=null; 
       try {
                
                sonuc=ifade.executeQuery("SELECT site_adi FROM \"SITE\"");
                sonuc.next(); 
                sonuc.first();
                site_adi=sonuc.getString("site_adi");
                ifade.close();
   
            } catch (Exception e) {
                e.printStackTrace();
            }
        return site_adi;
   }
    
    public void baslangic()
    {
       // txtBosalt();
        VerileriGetir();
       // VerileriGoster();
        tabloyuDoldur();
    }
    
    public Aktivite_bilgi() {
        initComponents();
        baslangic();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tip = new javax.swing.JTextField();
        txt_ak = new javax.swing.JTextField();
        txt_bit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_kaydet = new javax.swing.JButton();
        txt_bas = new javax.swing.JTextField();
        btn_sil = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_aktivite = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("aktivite numarası");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("baslama tarihi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("bitiş tarihi");

        txt_ak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_akActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("aktivite tipi");

        btn_kaydet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_kaydet.setText("kaydet");
        btn_kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kaydetActionPerformed(evt);
            }
        });

        btn_sil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_sil.setText("sil");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Yeni Aktivite");

        tbl_aktivite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aktivite Numarası", "Aktivite Tipi", "Aktivite Baş", "Aktivite Bit"
            }
        ));
        jScrollPane1.setViewportView(tbl_aktivite);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Eski Aktiviteler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tip, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bas, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ak, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 202, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_kaydet)
                        .addGap(97, 97, 97)
                        .addComponent(btn_sil))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_kaydet)
                    .addComponent(btn_sil))
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaydetActionPerformed
        
        String site_adi=ayarla();
        
        String bas_tarih = txt_bas.getText();
        String tip = txt_tip.getText();
        String bit_tarih = txt_bit.getText();
 
        int ak_no = Integer.parseInt(txt_ak.getText());
        
        String sql = "INSERT INTO \"AKTIVITE\"(aktivite_no,bas_tarihi,bit_tarihi,aktivite_tipi,site_adi) VALUES("+ak_no+",'"+bas_tarih+"', '"+bit_tarih+"', '"+tip+"','"+site_adi+"')";
        
        try{
            
     
              ifade = baglanti.createStatement();
              //System.out.println(sql);
              ifade.execute(sql);
             // ifade.close();
              VerileriGetir();
              txtBosalt();
              tabloyuDoldur();
              //VerileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_btn_kaydetActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        try
        {
           // ifade = baglanti.createStatement();
            String sql =  " DELETE FROM \"AKTIVITE\" "+" WHERE aktivite_no = '"+txt_ak.getText()+"' ";
            //System.out.println(sql);
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
    }//GEN-LAST:event_btn_silActionPerformed

    public void tabloyuDoldur()
       {
           ArrayList<Aktivite> AktiviteListem=new ArrayList<Aktivite>();
           
           String sql = "SELECT  *FROM \"AKTIVITE\"";
            try
            {
            
                baglanti = dao.getBaglanti();
                ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet sonuc = ifade.executeQuery(sql);
                //sonuc.next();
                //ifade.close();
                while (sonuc.next()) 
                {
                    Aktivite akt=new Aktivite();
                    akt.numarasi = sonuc.getInt("aktivite_no");
                    akt.bas=sonuc.getString("bas_tarihi");
                    akt.son=sonuc.getString("bit_tarihi");
                    akt.tip=sonuc.getString("aktivite_tipi");
                    AktiviteListem.add(akt);
                }
                String dizim[][]=new String[AktiviteListem.size()][];
                for (int i = 0; i < AktiviteListem.size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(AktiviteListem.get(i).numarasi),
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
                
                
                
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
            //VerileriGetir();
            
             
             
    
       }
    
    private void txt_akActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_akActionPerformed
              
    }//GEN-LAST:event_txt_akActionPerformed

    
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
            java.util.logging.Logger.getLogger(Aktivite_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aktivite_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aktivite_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aktivite_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aktivite_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kaydet;
    private javax.swing.JButton btn_sil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_aktivite;
    private javax.swing.JTextField txt_ak;
    private javax.swing.JTextField txt_bas;
    private javax.swing.JTextField txt_bit;
    private javax.swing.JTextField txt_tip;
    // End of variables declaration//GEN-END:variables
}
