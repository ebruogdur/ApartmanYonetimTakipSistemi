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


public class Aidat_odemeyenler_bilgi extends javax.swing.JFrame {
 private  Connection baglanti;
    private  ResultSet sonuc;
    private  Statement ifade;
    
   
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
                
                
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
     public class Sakin
     {
         String sakin_tc;
         String sakin_ad;
         String sakin_soyad;
         int daire_no;
         int borc;
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
    
    public ArrayList borc_tut()
    {   
        ArrayList<Integer> borc= new ArrayList<Integer>();
        ResultSet sonuc=null;
        int sakin_borc;
        int i=0;
        ArrayList<String> SakinTc = tc_dondur();
        for(i=0;i<SakinTc.size();i++){
            try {
            
                sonuc = ifade.executeQuery("SELECT *FROM \"AIDAT\" "+" WHERE sakin_tc = '"+SakinTc.get(i)+"'");
                sonuc.next();
                if(cmb_ay.getSelectedIndex() == 0)
                {   
                    sakin_borc=sonuc.getInt("ocak");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                }
            if(cmb_ay.getSelectedIndex() == 1)
            {
                    sakin_borc=sonuc.getInt("subat");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }
            if(cmb_ay.getSelectedIndex() == 2)
            {
                
                    sakin_borc=sonuc.getInt("mart");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }  
         
            if(cmb_ay.getSelectedIndex() == 3)
            {
                
                    sakin_borc=sonuc.getInt("nisan");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }  
        
            if(cmb_ay.getSelectedIndex() == 4)
            {
                
                    sakin_borc=sonuc.getInt("mayis");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }
            
            if(cmb_ay.getSelectedIndex() == 5)
            {
                    sakin_borc=sonuc.getInt("haziran");
                   if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }  
            
            if(cmb_ay.getSelectedIndex() == 6)
            {
                while(sonuc != null && sonuc.next()) 
                {
                    sakin_borc=sonuc.getInt("temmuz");
                    borc.add(sakin_borc);
                }
            }  
         
            if(cmb_ay.getSelectedIndex() == 7)
            {   
                   sakin_borc=sonuc.getInt("agustos");
                   if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }  
         
            if(cmb_ay.getSelectedIndex() == 8)
            {  
                    sakin_borc=sonuc.getInt("eylul");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }  
            if(cmb_ay.getSelectedIndex() == 9)
            {
              
                sakin_borc=sonuc.getInt("ekim");
                if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
            }
            
            if(cmb_ay.getSelectedIndex() == 10)
            {
                    sakin_borc=sonuc.getInt("kasim");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                   
            } 
            if(cmb_ay.getSelectedIndex() == 11)
            {
                    sakin_borc=sonuc.getInt("aralik");
                    if(sakin_borc!=0){
                        borc.add(sakin_borc);
                    }
                
            }  
         
            }catch (SQLException ex) {
                 ex.printStackTrace();
            }
         
        
        }
        return borc;
    }
    
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
    
    
    
   
    public Aidat_odemeyenler_bilgi() {
        initComponents();
        VerileriGetir();
    }
    
    
     public ArrayList borc_tc()
    {
        ResultSet sonuc;
        ArrayList<String> borc=new ArrayList<String>();
        
        try {
            if (cmb_ay.getSelectedIndex() == 0)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE ocak!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
                 
            }
            if (cmb_ay.getSelectedIndex() == 1)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE subat!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 2)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE mart!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 3)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE nisan!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
          
            if (cmb_ay.getSelectedIndex() == 5)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE mayis!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 6)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE haziran!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 7)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE temmuz!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 8)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE agustos!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 9)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE eylul!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 10)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE ekim!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 11)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE kasim!=0 ";
                sonuc=ifade.executeQuery(sql);
                while(sonuc!= null && sonuc.next())
                {
                    borc.add(sonuc.getString("sakin_tc"));
     
                }
            }
            if (cmb_ay.getSelectedIndex() == 12)
            {
                String sql="SELECT * FROM \"AIDAT\" "+" WHERE aralik!=0 ";
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

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_goster = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_odemeyen = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmb_ay = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_blok = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_goster.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_goster.setText("Göster");
        btn_goster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gosterActionPerformed(evt);
            }
        });

        tbl_odemeyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_odemeyen);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ayı giriniz");

        cmb_ay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_ay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ocak", "şubat", "mart", "nisan", "mayıs", "haziran", "temmuz", "ağustos", "eylül", "ekim", "kasım", "aralık", " " }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("blok numarasını gir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_ay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_blok, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_goster)))
                .addContainerGap(346, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_blok, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmb_ay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(btn_goster)))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_gosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gosterActionPerformed
        
        ArrayList<Aidat_odemeyenler_bilgi.Sakin> SakinListem=new ArrayList<Aidat_odemeyenler_bilgi.Sakin>();
        ArrayList<String> SakinTc=new ArrayList<String>();
        ArrayList<String> Borc=new ArrayList<String>();
        ArrayList<String> Eleme=new ArrayList<String>();
        ArrayList<Integer> BorcTut=new ArrayList<Integer>();
        SakinTc=tc_dondur();
        Borc=borc_tc();
        BorcTut=borc_tut();
        ResultSet sonuc;
        int nop = 0;
        
        
        
        for(int i=0;i<SakinTc.size();i++)
        {
            for(int j=0;j<Borc.size();j++)
            {
                if(SakinTc.get(i).equals(Borc.get(j))){
                    Eleme.add(SakinTc.get(i));
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
                    
                    Aidat_odemeyenler_bilgi.Sakin skn=new Aidat_odemeyenler_bilgi.Sakin();
                    skn.sakin_tc = sonuc.getString("sakin_tc");
                    skn.sakin_ad=sonuc.getString("sakin_adi");
                    skn.sakin_soyad=sonuc.getString("sakin_soyadi");
                    nop = sonuc.getInt("daire_no");
                    skn.daire_no=daire_bul(nop);
                    skn.borc=BorcTut.get(i);
                    SakinListem.add(skn);
                
                 }
                String dizim[][]=new String[SakinListem.size()][];
                for (int j = 0; j < SakinListem.size(); j++) {     
                     dizim[j]=new String[]{                                   
                     valueOf(SakinListem.get(j).sakin_tc),
                     valueOf(SakinListem.get(j).sakin_ad),
                     valueOf(SakinListem.get(j).sakin_soyad),
                     valueOf(SakinListem.get(j).daire_no),
                     valueOf(SakinListem.get(j).borc)
                     };
                                      
                
                
                TableModel tabloModeli=new DefaultTableModel(
                dizim,
                new String[] {"Sakin TC", "Sakin Adı", "Sakin Soyadı","Daire NO","Sakin Borç" }                                                
                    );
                tbl_odemeyen.setModel(tabloModeli);
                
                
                }  
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        
    }//GEN-LAST:event_btn_gosterActionPerformed

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
            java.util.logging.Logger.getLogger(Aidat_odemeyenler_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aidat_odemeyenler_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aidat_odemeyenler_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aidat_odemeyenler_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aidat_odemeyenler_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_goster;
    private javax.swing.JComboBox cmb_ay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_odemeyen;
    private javax.swing.JTextField txt_blok;
    // End of variables declaration//GEN-END:variables
}
