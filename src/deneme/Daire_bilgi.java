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
public class Daire_bilgi extends javax.swing.JFrame {
    
    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
   
   private DAO dao = new DAO();
   
   
 private void VerileriGetir()
    {
        String sql = "SELECT  *FROM \"DAIRE\"";
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
        txt_daire_no.setText("");
        txt_oda_sayisi.setText("");
        txt_balkon_sayisi.setText("");
        txt_ısınma.setText("");
        txt_banyo_sayisi.setText("");
        txt_kat_bilgisi.setText("");
        txt_blok_numarasi.setText("");
        txt_daire_no.requestFocus();
        
    }
 
 private void VerileriGoster()
    {
        txtBosalt();
      
        if(sonuc != null)
        {
            try {
                txt_daire_no.setText(sonuc.getString("daire_no"));
                txt_oda_sayisi.setText(sonuc.getString("oda_sayisi"));
                txt_balkon_sayisi.setText(sonuc.getString("balkon_sayisi"));
                txt_ısınma.setText(sonuc.getString("isinma_durumu"));
                txt_banyo_sayisi.setText(sonuc.getString("banyo_sayisi"));
                String durum="bos";
                 if (sonuc.getString("durumu").equals(durum))
                {
                    cmb_durum.setSelectedIndex(0);
                 }   
                 else {
                    cmb_durum.setSelectedIndex(1);
                }
                txt_kat_bilgisi.setText(sonuc.getString("kat_bilgisi"));
                txt_blok_numarasi.setText(sonuc.getString("blok_no"));
                
                } catch (SQLException ex) 
                {
                ex.printStackTrace();
                }
        }
        
    }
 
 public void ayarla(){
     ResultSet sonuc=null;
     String cumle="";
     String ad="";
     String soyad="";
     String tc="";
     int nop=eleme();
       try {
                int blok_no = Integer.parseInt(txt_arama.getText());
                int daire_no = Integer.parseInt(txt_arama2.getText());
                String sql= "SELECT * FROM \"SAKINLER\" "+" where daire_no = "+nop+" ";
                System.out.println(sql);
                sonuc=ifade.executeQuery(sql);
                while(sonuc.next()){//HOCAYA SOR
                     tc = sonuc.getString("sakin_tc");
                     soyad = sonuc.getString("sakin_soyadi");
                     ad = sonuc.getString("sakin_adi");
                     cumle = tc+"\n"+ad+"\n"+soyad+"\n";
                    jTextArea2.setText(cumle);
                } 
                //sonuc.close();
                //sonuc.first();
                //ifade.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
   }
 
    public int daire_dondur()
    {
        int row=0;
        ResultSet sonuc;
        
        try {
            sonuc=ifade.executeQuery("SELECT * FROM \"DAIRE\" ");
        
             sonuc.next();
             sonuc.last();
             row = sonuc.getInt("daire_nop");
             row++;
             System.out.println(row);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }
    
    public int eleme()
    {
        ResultSet sonuc;
        int eleme=0;
        int daire=Integer.parseInt(txt_arama2.getText());
        int blok=Integer.parseInt(txt_arama.getText());
        
        
        try {
            String sql = "SELECT * FROM \"DAIRE\" "+" WHERE daire_no="+daire+" and blok_no="+blok+" ";
            sonuc=ifade.executeQuery(sql);
            
            System.out.println(sql);
            sonuc.next();
            eleme = sonuc.getInt("daire_nop");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return eleme;
        
    }
    
    
     
    public int eleme1()
    {
        ResultSet sonuc;
        int eleme=0;
        int daire=Integer.parseInt(txt_daire_no.getText());
        int blok=Integer.parseInt(txt_blok_numarasi.getText());
        
        
        try {
            String sql = "SELECT * FROM \"DAIRE\" "+" WHERE daire_no="+daire+" and blok_no="+blok+" ";
            sonuc=ifade.executeQuery(sql);
            
            System.out.println(sql);
            sonuc.next();
            eleme = sonuc.getInt("daire_nop");
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return eleme;
        
    }
    
 
 public void baslangic()
    {
        //txtBosalt();
        VerileriGetir();
        //VerileriGoster();
        //ayarla();
    }
   
   
    public Daire_bilgi() {
        initComponents();
        baslangic();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_daire_no = new javax.swing.JTextField();
        txt_oda_sayisi = new javax.swing.JTextField();
        txt_balkon_sayisi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ısınma = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_banyo_sayisi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_kat_bilgisi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_blok_numarasi = new javax.swing.JTextField();
        btn_kaydet = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        txt_arama = new javax.swing.JTextField();
        btn_arama = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        txt_arama2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmb_durum = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        txt_temizle = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Daire Numarası");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Oda Sayısı");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Balkon Sayısı");

        txt_balkon_sayisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_balkon_sayisiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Isınma Durumu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("banyo sayısı");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("durumu");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("kat bilgisi");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("blok numarası");

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

        btn_arama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_arama.setText("ara");
        btn_arama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aramaActionPerformed(evt);
            }
        });

        btn_guncelle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_guncelle.setText("guncelle");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("blok  numarasını giriniz");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("daire numarasını giriniz");

        cmb_durum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_durum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bos", "Dolu" }));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Daireye ait sakin bilgisi");

        txt_temizle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_temizle.setText("temizle");
        txt_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_temizleActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_balkon_sayisi, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(txt_oda_sayisi)
                            .addComponent(txt_daire_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_kaydet)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_blok_numarasi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_guncelle)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_temizle))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_banyo_sayisi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txt_ısınma, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_kat_bilgisi)
                                    .addComponent(cmb_durum, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_arama2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btn_arama)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_sil))
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 70, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_daire_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_oda_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_balkon_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_ısınma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_banyo_sayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_durum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txt_arama2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_arama)
                            .addComponent(btn_sil))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_kaydet)
                            .addComponent(btn_guncelle)
                            .addComponent(txt_temizle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_kat_bilgisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_blok_numarasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_balkon_sayisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_balkon_sayisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_balkon_sayisiActionPerformed

    private void btn_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaydetActionPerformed
       //ResultSet sonuc=null;
        String daire_no = txt_daire_no.getText();
        String oda_sayisi = txt_oda_sayisi.getText();
        String balkon_sayisi = txt_balkon_sayisi.getText();
        String ısınma = txt_ısınma.getText();
        String banyo_sayisi = txt_banyo_sayisi.getText();
        String durum ;
        if (cmb_durum.getSelectedIndex() == 0)
        {
            durum= "bos";
        }   
        else {
            durum = "dolu";
        }
        String kat= txt_kat_bilgisi.getText();
        String blok_no=txt_blok_numarasi.getText();
        int row=daire_dondur();
        
        
        int blok_no_int = Integer.parseInt(txt_blok_numarasi.getText());
        int oda_sayisi_int = Integer.parseInt(txt_oda_sayisi.getText());
        int kat_int = Integer.parseInt(txt_kat_bilgisi.getText());
        int daire_no_int=Integer.parseInt(txt_daire_no.getText());
        int balkon_sayisi_int=Integer.parseInt(txt_balkon_sayisi.getText());
        int banyo_sayisi_int=Integer.parseInt(txt_banyo_sayisi.getText());
        try{
            
            ifade = baglanti.createStatement();
            String sql="INSERT INTO \"DAIRE\"(isinma_durumu,durumu,blok_no,kat_bilgisi,daire_no,balkon_sayisi,banyo_sayisi,oda_sayisi,daire_nop) VALUES('"+ısınma+"', '"+durum+"', "+blok_no_int+", "+kat_int+","+daire_no_int+","+balkon_sayisi_int+","+banyo_sayisi_int+", "+oda_sayisi_int+","+row+") ";
            ifade.execute(sql);
              VerileriGetir();
              txtBosalt();
             
              //VerileriGoster();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_kaydetActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
         try
        {
            int row=eleme();
            
            String sql = " DELETE FROM \"DAIRE\" "+" WHERE daire_nop = "+row+" ";
            System.out.println(sql);
            ifade.execute(sql);
            
            //VerileriGetir();
            //VerileriGoster();
        
            //sonuc.close();
            ifade.close();
            VerileriGetir();
            txtBosalt();
            //VerileriGoster();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        String daire_no = txt_daire_no.getText();
        String oda_sayisi = txt_oda_sayisi.getText();
        String balkon_sayisi = txt_balkon_sayisi.getText();
        String ısınma = txt_ısınma.getText();
        String banyo_sayisi = txt_banyo_sayisi.getText();
        String durum ;
        int satir = eleme1();
        if (cmb_durum.getSelectedIndex() == 0)
        {
            durum= "bos";
        }   
        else {
            durum = "dolu";
        }
        String kat= txt_kat_bilgisi.getText();
        String blok_no=txt_blok_numarasi.getText();
        
        int blok_no_int = Integer.parseInt(txt_blok_numarasi.getText());
        int oda_sayisi_int = Integer.parseInt(txt_oda_sayisi.getText());
        int kat_int = Integer.parseInt(txt_kat_bilgisi.getText());
        int daire_no_int=Integer.parseInt(txt_daire_no.getText());
        int balkon_sayisi_int=Integer.parseInt(txt_balkon_sayisi.getText());
        int banyo_sayisi_int=Integer.parseInt(txt_banyo_sayisi.getText());
        
        try
        {
            //ifade = baglanti.createStatement();
            String sql = " UPDATE \"DAIRE\" SET "+
                    "blok_no="+blok_no_int+
                    ", isinma_durumu='"+ısınma+"'"+
                    ", oda_sayisi="+oda_sayisi_int+
                    ", kat_bilgisi="+kat_int+
                    ", durumu='"+durum+"'"+
                    ", daire_no="+daire_no_int+
                    ", balkon_sayisi="+balkon_sayisi_int+
                    ", banyo_sayisi="+banyo_sayisi_int+
                    
                    
                    " WHERE daire_nop = "+satir+" ";
            System.out.println(sql);
            ifade.execute(sql);
            ifade.close();
            VerileriGetir();
            VerileriGoster();
            //String islem = "GUNCELLEME İSLEMİNİZ\nTAMAMLANMISTIR";
           // txt_islem.setText(islem);
            txtBosalt();
            //VerileriGoster();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void btn_aramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aramaActionPerformed
        jTextArea2.setText("");
        VerileriGetir();
        String blok_no = txt_arama.getText();
        int blok_no_int = Integer.parseInt(blok_no);
        String daire_no = txt_arama2.getText();
        int daire_no_int = Integer.parseInt(daire_no);
        try {
            int mevcut_satir;
            mevcut_satir = sonuc.getRow(); 
            sonuc.first();
            sonuc.previous();
            int satir = 0;
            boolean bulundu = false;
            while(sonuc.next())
            {
                satir++;
                if(sonuc.getInt("blok_no")==blok_no_int) 
                {
                    if(sonuc.getInt("daire_no")==daire_no_int){
                        bulundu = true;
                        break;
                    }
                }
            }
            if(bulundu)
            {
                sonuc.absolute(satir);
            }   
            else
            {
                sonuc.absolute(mevcut_satir);
            }
            //VerileriGetir();
            VerileriGoster();
            ayarla();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      
    }//GEN-LAST:event_btn_aramaActionPerformed

    private void txt_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_temizleActionPerformed
        txtBosalt();
        jTextArea2.setText("");
        txt_arama.setText("");
        txt_arama2.setText("");
    }//GEN-LAST:event_txt_temizleActionPerformed

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
            java.util.logging.Logger.getLogger(Daire_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Daire_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Daire_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Daire_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Daire_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_arama;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_kaydet;
    private javax.swing.JButton btn_sil;
    private javax.swing.JComboBox cmb_durum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField txt_arama;
    private javax.swing.JTextField txt_arama2;
    private javax.swing.JTextField txt_balkon_sayisi;
    private javax.swing.JTextField txt_banyo_sayisi;
    private javax.swing.JTextField txt_blok_numarasi;
    private javax.swing.JTextField txt_daire_no;
    private javax.swing.JTextField txt_kat_bilgisi;
    private javax.swing.JTextField txt_oda_sayisi;
    private javax.swing.JButton txt_temizle;
    private javax.swing.JTextField txt_ısınma;
    // End of variables declaration//GEN-END:variables
}
