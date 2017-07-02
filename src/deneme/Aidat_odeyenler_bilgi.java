package deneme;

import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Aidat_odeyenler_bilgi extends javax.swing.JFrame {

    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    int row=0;
    int row2=0;
    private DAO dao = new DAO();
   
   
   
   private void VerileriGetir()
    {
        String sql = "SELECT  *FROM \"SAKINLER\"";
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
   
   public int aidat_dondur()
   {
       int aidat=0;
       ResultSet sonuc;
        try {
            sonuc=ifade.executeQuery("SELECT * FROM \"SITE\" ");
            sonuc.next();
            aidat=sonuc.getInt("aidat_miktari");
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
       
       
       return aidat;
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
    
   
   public class Sakin
     {
         String sakin_tc;
         String sakin_ad;
         String sakin_soyad;
         int daire_no;
     }
   
   public int aidat_topla()
   {
       ResultSet sonuc = null;
       ArrayList<String> toplam = new ArrayList<String>();
       int toplam_miktar = 0;
       toplam = tc_dondur();
       int miktar=aidat_dondur();
       int ay = 0;
       for(int i=0;i<toplam.size();i++)
       {
           try {
               sonuc = ifade.executeQuery("SELECT * FROM \"AIDAT\" "+" WHERE sakin_tc='"+toplam.get(i)+"'");
               sonuc.next();
               if(cmb_ay.getSelectedIndex()==0)
               {
                   ay = sonuc.getInt("ocak");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
               
               if(cmb_ay.getSelectedIndex()==1)
               {
                   ay = sonuc.getInt("subat");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
               if(cmb_ay.getSelectedIndex()==2)
               {
                   ay = sonuc.getInt("mart");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==3)
               {
                   ay = sonuc.getInt("nisan");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==4)
               {
                   ay = sonuc.getInt("mayis");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==5)
               {
                   ay = sonuc.getInt("haziran");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==6)
               {
                   ay = sonuc.getInt("temmuz");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==7)
               {
                   ay = sonuc.getInt("agustos");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==8)
               {
                   ay = sonuc.getInt("eylul");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==9)
               {
                   ay = sonuc.getInt("ekim");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==10)
               {
                   ay = sonuc.getInt("kasim");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
                if(cmb_ay.getSelectedIndex()==11)
               {
                   ay = sonuc.getInt("aralik");
                   ay=miktar-ay;
                   toplam_miktar = toplam_miktar + ay;
                }
               sonuc.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
       }
       return toplam_miktar;
       
   }
    /*public int AidatBul()
    {
        String sql = "SELECT  *FROM \"SITE\"";
        int aidat=0;
        
        try {
            baglanti = dao.getBaglanti();
            ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sonuc = ifade.executeQuery(sql);
            sonuc.next();
            aidat = sonuc.getInt("aidat_miktari");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aidat;
        
    }*/
    
 
    
   
   
    public ArrayList tc_dondur(){
        ResultSet sonuc;
        VerileriGetir();
        ArrayList<String> SakinTC=new ArrayList<String>();
      
        int i = 0;
        String blok_no = txt_blok.getText();
        int blok_no_int= Integer.parseInt(blok_no);
        String Tc="";
        String ad="as";
        System.out.println(ad);
        
        try
        {

                String sql= "SELECT * FROM \"SAKINLER\" "+" WHERE blok_no="+blok_no_int+" ";
               
                sonuc = ifade.executeQuery(sql);
                
                System.out.println(sql);
                
                 
                while(sonuc != null && sonuc.next())
                {
                    ad=sonuc.getString("sakin_adi");
                    System.out.println(ad);
                    Tc=sonuc.getString("sakin_tc");
                    SakinTC.add(Tc);
                    
                }
                System.out.println(SakinTC);
                sonuc.close();
                    
        }
        catch(SQLException ex)
        {
           ex.printStackTrace();
        }
        return SakinTC;
   }
   
    public ArrayList borc_tc()
    {
        ResultSet sonuc;
        ArrayList<String> borc=new ArrayList<String>();
        
        try {
            if (cmb_ay.getSelectedIndex() == 0)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE ocak=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
                 
            }
            if (cmb_ay.getSelectedIndex() == 1)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE subat=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 2)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE mart=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 3)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE nisan=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
          
            if (cmb_ay.getSelectedIndex() == 5)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE mayis=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 6)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE haziran=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 7)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE temmuz=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 8)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE agustos=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 9)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE eylul=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 10)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE ekim=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 11)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE kasim=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 12)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE aralik=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            
                
            
       } catch (SQLException ex) {
               //ex.printStackTrace();
        }
        return borc;
    }
    
    public Aidat_odeyenler_bilgi() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btn_goster = new javax.swing.JButton();
        btn_toplam_aidat = new javax.swing.JButton();
        txt_toplam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ode = new javax.swing.JTable();
        cmb_ay = new javax.swing.JComboBox();
        txt_blok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_goster.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_goster.setText("Göster");
        btn_goster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gosterActionPerformed(evt);
            }
        });

        btn_toplam_aidat.setText("Toplam aidat miktarını göster");
        btn_toplam_aidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toplam_aidatActionPerformed(evt);
            }
        });

        tbl_ode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sakin Tc", "Sakin Ad", "Sakin Soyad", "Daire No"
            }
        ));
        jScrollPane1.setViewportView(tbl_ode);

        cmb_ay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_ay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ocak", "şubat", "mart", "nisan", "mayıs", "haziran", "temmuz", "agustos", "eylül", "ekim", "kasım", "aralık" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ayı Seçiniz");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Blok No Giriniz");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btn_toplam_aidat)
                .addGap(69, 69, 69)
                .addComponent(txt_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_ay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(txt_blok, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_goster))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_ay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_blok, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_goster))
                        .addGap(43, 43, 43)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_toplam)
                    .addComponent(btn_toplam_aidat))
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_toplam_aidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toplam_aidatActionPerformed
      
        txt_toplam.setText(String.valueOf(aidat_topla()));
        
    }//GEN-LAST:event_btn_toplam_aidatActionPerformed

    private void btn_gosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gosterActionPerformed
        
        ArrayList<Sakin> SakinListem=new ArrayList<Sakin>();
        ArrayList<String> SakinTc=new ArrayList<String>();
        ArrayList<String> Borc=new ArrayList<String>();
        ArrayList<String> Eleme=new ArrayList<String>();
        SakinTc=tc_dondur();
        Borc=borc_tc();
        ResultSet sonuc;
        int nop = 0;
        
        for(int i=0;i<Borc.size();i++)
        {
            for(int j=0;j<SakinTc.size();j++)
            {
                if(Borc.get(i).equals(SakinTc.get(j))){
                    Eleme.add(Borc.get(i));
                    System.out.println(Eleme);
                }
            }
        }
        
            try
            {
                for(int i=0;i<Eleme.size();i++)
                {
                    String sql=" SELECT * FROM \"SAKINLER\" "+" WHERE sakin_tc='"+Eleme.get(i)+"' ";
                    sonuc=ifade.executeQuery(sql);
                    sonuc.next();
                
                    Sakin skn=new Sakin();
                    skn.sakin_tc = sonuc.getString("sakin_tc");
                    skn.sakin_ad=sonuc.getString("sakin_adi");
                    skn.sakin_soyad=sonuc.getString("sakin_soyadi");
                    nop = sonuc.getInt("daire_no");
                    skn.daire_no=daire_bul(nop);
                    SakinListem.add(skn);
                
                 }
                String dizim[][]=new String[SakinListem.size()][];
                for (int j = 0; j < SakinListem.size(); j++) {     
                     dizim[j]=new String[]{                                   
                     valueOf(SakinListem.get(j).sakin_tc),
                     valueOf(SakinListem.get(j).sakin_ad),
                     valueOf(SakinListem.get(j).sakin_soyad),
                     valueOf(SakinListem.get(j).daire_no)                                 
                     };
                                      
                
                
                TableModel tabloModeli=new DefaultTableModel(
                dizim,
                new String[] {"Sakin TC", "Sakin Adı", "Sakin Soyadı","Daire NO" }                                                
                    );
                tbl_ode.setModel(tabloModeli);
                }  
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        
        
        
    }//GEN-LAST:event_btn_gosterActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aidat_odeyenler_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_goster;
    private javax.swing.JButton btn_toplam_aidat;
    private javax.swing.JComboBox cmb_ay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_ode;
    private javax.swing.JTextField txt_blok;
    private javax.swing.JTextField txt_toplam;
    // End of variables declaration//GEN-END:variables
}
