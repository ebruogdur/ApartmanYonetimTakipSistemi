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
public class Sakin_bilgi extends javax.swing.JFrame {

    
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
        /*finally
        {
            if(baglanti != null )
                try {
                    baglanti.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }*/
    }
    
    public class Sakin
    {
        String tc;
        String ad;
        String soyad;
        int yas;
        String meslek;
        String tel;
        int blok;
        int daire;
    }
    
    
    public int daire_bul(int nop)
    {
      //ResultSet sonuc; 
       int daire_no=0;
       try {
            String sql = "SELECT * FROM \"DAIRE\" "+" WHERE daire_nop="+nop+" ";
            sonuc=ifade.executeQuery(sql);
            
            System.out.println(sql);
            while(sonuc.next())
                daire_no = sonuc.getInt("daire_no");
            //sonuc.close();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return daire_no;
    }
    
     public void tabloyuDoldur()
       {
           
          
           ArrayList<Sakin> SakinListem=new ArrayList<Sakin>();
           int nop = 0;
           ResultSet sonuc;
           
           
            try
            {
                String sql = "SELECT  *FROM \"SAKINLER\"";
                sonuc = ifade.executeQuery(sql);
                //sonuc.next();
               
                
               // ifade.close();;
                //sonuc.last();
                //int row=sonuc.getRow();
               // sonuc.first();
               // System.out.println(row);
                
                while(sonuc != null && sonuc.next())
                {
                    
                    VerileriGetir();
                    Sakin skn=new Sakin();
                    skn.tc= sonuc.getString("sakin_tc");
                    skn.ad=sonuc.getString("sakin_adi");
                    skn.soyad=sonuc.getString("sakin_soyadi");
                    skn.yas=sonuc.getInt("sakin_yas");
                    skn.meslek = sonuc.getString("sakin_meslek");
                    skn.tel = sonuc.getString("sakin_tel");
                    skn.blok = sonuc.getInt("blok_no");
                    nop = sonuc.getInt("daire_no");
                    skn.daire = daire_bul(nop);
                    SakinListem.add(skn);
                    System.out.println(SakinListem);
                    
                }
                
                
                System.out.println(SakinListem.size());
                String dizim[][]=new String[SakinListem.size()][];
                for (int i = 0; i < SakinListem.size(); i++) {     
                     dizim[i]=new String[]{                                   
                     valueOf(SakinListem.get(i).tc),
                     valueOf(SakinListem.get(i).ad),
                     valueOf(SakinListem.get(i).soyad),
                     valueOf(SakinListem.get(i).yas) ,
                     valueOf(SakinListem.get(i).meslek),
                     valueOf(SakinListem.get(i).tel),
                     valueOf(SakinListem.get(i).blok),
                     valueOf(SakinListem.get(i).daire) 
                     };
                                      
                    }
                
                TableModel tabloModeli=new DefaultTableModel(
                dizim,
                new String[] {"TC", "AD", "SOYAD","YAS","MESLEK","TELEFON","BLOK NUMARASI","DAİRE NUMARASI" }                                                
                    );
                tbl_sakin.setModel(tabloModeli);
                //sonuc.close();
                
                
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
           
            
             
             
    
       }
    private void txtBosalt()
    {
        txt_sakin_tc.setText("");
        txt_sakin_adi.setText("");
        txt_sakin_soyadi.setText("");
        txt_sakin_tel.setText("");
        txt_sakin_meslek.setText("");
        txt_sakin_yas.setText("");
        txt_sakin_daire_numarasi.setText("");
        txt_blok_no.setText("");
        txt_aidat.setText("");
        
        
    }

    /*private void VerileriGoster()
    {
        txtBosalt();
 
        int daireNo=0;
                
        if(sonuc != null)
        {
            try {
                daireNo=daire_bul(sonuc.getInt("daire_no"));
                System.out.println(daireNo);
                sonuc=ifade.executeQuery("SELECT * FROM \"SAKINLER\" "+" WHERE daire_no="+daireNo+" ");
                if(sonuc.next()){
                txt_sakin_tc.setText(sonuc.getString("sakin_tc"));
                txt_sakin_adi.setText(sonuc.getString("sakin_adi"));
                txt_sakin_soyadi.setText(sonuc.getString("sakin_soyadi"));
                txt_sakin_tel.setText(sonuc.getString("sakin_tel"));
                txt_sakin_meslek.setText(sonuc.getString("sakin_meslek"));
                txt_sakin_yas.setText(sonuc.getString("sakin_yas"));
                txt_sakin_daire_numarasi.setText(String.valueOf(daireNo));
                txt_blok_no.setText(sonuc.getString("blok_no"));
                }
                /*String ode="odendi";
                if (sonuc.getString("aidat_bilgisi").equals(ode))
                {
                cmb_aidat.setSelectedIndex(0);
                }   
                //if (sonuc.getString("aidat_bilgisi").equals(ode1))
                else
                {
                cmb_aidat.setSelectedIndex(1);
                }
                
                } catch (SQLException ex) 
                {
                ex.printStackTrace();
                }
        }
        
    }*/
    public int aidat_dondur()
    {
        ResultSet sonuc;
        int aidat=0;
        try {
            sonuc=ifade.executeQuery("SELECT * FROM \"SITE\"");
            sonuc.next();
            aidat = sonuc.getInt("aidat_miktari");
            sonuc.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aidat;  
    }
    
    public int AidatNoDondur()
    {
    ResultSet sonuc;
        int row=0;
        String tc;
        tc=txt_sakin_tc.getText();
        try {
            sonuc=ifade.executeQuery("SELECT * FROM \"AIDAT\" "+" WHERE sakin_tc= '"+tc+"' ");
            //sonuc.next();
            if (sonuc != null && sonuc.next()) {
                row = sonuc.getInt("aidat_no");
            }
            sonuc.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    public void ayarla()
    {
       ResultSet sonuc;
       String tc;
       int borc_durumu=0;
       int odenen_miktar = Integer.parseInt(txt_aidat.getText());
       int aidat_miktar = aidat_dondur();
       System.out.println(odenen_miktar);
       int row=0;
       try {
                tc = txt_sakin_tc.getText();
                System.out.println(tc);
                sonuc=ifade.executeQuery("SELECT * FROM \"AIDAT\" ");
                while(sonuc.next())
                {
                    row = sonuc.getInt("aidat_no");
                    row++;
                }
                System.out.println(row +"row");
                
                //sonuc.last();
                //row=sonuc.getRow();
                //row++;
                
                //sonuc.first();
                if (cmb_aidat.getSelectedIndex() == 0)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    System.out.println(borc_durumu);
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,ocak,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                    //System.out.println(sql);
                }
                if (cmb_aidat.getSelectedIndex() == 1)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,subat,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                 if (cmb_aidat.getSelectedIndex() == 2)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,mart,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                if (cmb_aidat.getSelectedIndex() == 3)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,nisan,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                 if (cmb_aidat.getSelectedIndex() == 4)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,mayis,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                if (cmb_aidat.getSelectedIndex() == 5)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,haziran,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                 if (cmb_aidat.getSelectedIndex() == 6)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,temmuz,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                if (cmb_aidat.getSelectedIndex() == 7)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,agustos,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                 if (cmb_aidat.getSelectedIndex() == 8)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,eylul,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                if (cmb_aidat.getSelectedIndex() == 9)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,ekim,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                 if (cmb_aidat.getSelectedIndex() == 10)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,kasim,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
                if (cmb_aidat.getSelectedIndex() == 11)
                {
                    borc_durumu = aidat_miktar-odenen_miktar;
                    String sql = "INSERT INTO \"AIDAT\" (sakin_tc,aralik,aidat_no) VALUES('"+tc+"',"+borc_durumu+","+row+")";
                    ifade.execute(sql);
                }
               //sonuc.close();
              //ifade.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
   }
    
    public void ayarla_guncelle()
    {
       
       ResultSet sonuc;
       String tc;
       int borc_durumu=0;
       int odenen_miktar = Integer.parseInt(txt_aidat.getText());
       int aidat_miktar = aidat_dondur();
       int row;
       int borc=0;
       
       try {
                tc = txt_sakin_tc.getText();
                
                sonuc=ifade.executeQuery("SELECT * FROM \"AIDAT\" "+" WHERE sakin_tc = '"+tc+"' ");
                sonuc.next();
                
                row = sonuc.getInt("aidat_no");
                
              
                
                if (cmb_aidat.getSelectedIndex() == 0)
                {
                    borc=sonuc.getInt("ocak");
                    if(borc > 0 )
                    {
                        borc_durumu = borc-odenen_miktar;
                        System.out.println(borc_durumu);
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", ocak='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                        " WHERE aidat_no = "+row+" ";
                            
                        System.out.println(sql);
                        ifade.execute(sql);
                   }
                    if(borc == 0)
                    {
                        borc_durumu = aidat_miktar-odenen_miktar;
                        System.out.println(borc_durumu);
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", ocak='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                        " WHERE aidat_no = "+row+" ";
                            
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                if (cmb_aidat.getSelectedIndex() == 1)
                {
                    borc=sonuc.getInt("subat");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", subat='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", subat='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                 if (cmb_aidat.getSelectedIndex() == 2)
                {
                    borc=sonuc.getInt("mart");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", mart='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", mart='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }

                  if (cmb_aidat.getSelectedIndex() == 3)
                {
                    borc=sonuc.getInt("nisan");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", nisan='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", nisan='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                   if (cmb_aidat.getSelectedIndex() == 4)
                {
                    borc=sonuc.getInt("mayis");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", mayis='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", mayis='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                   
                   
                    if (cmb_aidat.getSelectedIndex() == 5)
                {
                    borc=sonuc.getInt("haziran");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", haziran='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", haziran='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                    
                    
                    
                     if (cmb_aidat.getSelectedIndex() == 6)
                {
                    borc=sonuc.getInt("temmuz");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", temmuz='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", temmuz='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                     
                     
                     
                      if (cmb_aidat.getSelectedIndex() == 7)
                {
                    borc=sonuc.getInt("agustos");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", agustos='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", agustos='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                      
                      
                      
                      
                       if (cmb_aidat.getSelectedIndex() == 8)
                {
                    borc=sonuc.getInt("eylul");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", eylul='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", eylul='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                       
                       
                       
                       
                        if (cmb_aidat.getSelectedIndex() == 9)
                {
                    borc=sonuc.getInt("ekim");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", ekim='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", ekim='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                        
                        
                        
                         if (cmb_aidat.getSelectedIndex() == 10)
                {
                    borc=sonuc.getInt("subat");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", kasim='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", kasim='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                         
                         
                          if (cmb_aidat.getSelectedIndex() == 11)
                {
                    borc=sonuc.getInt("aralik");
                    
                    if(borc == 0){
                        borc_durumu = aidat_miktar-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", aralik='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                    System.out.println(sql);
                    ifade.execute(sql);
                    }
                    if(borc > 0)
                    {
                        borc_durumu = borc-odenen_miktar;
                        String sql = " UPDATE \"AIDAT\" SET "+
                            "sakin_tc='"+tc+"'"+
                            ", aralik='"+borc_durumu+"'"+
                            ", aidat_no="+row+
                            " WHERE aidat_no = "+row+" ";
                        System.out.println(sql);
                        ifade.execute(sql);
                    }
                }
                          
                
                   sonuc.close();
                
       } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public int daire_no_dondur()
    {
        ResultSet sonuc;
        int eleme=0;
        int daire=Integer.parseInt(txt_sakin_daire_numarasi.getText());
        int blok=Integer.parseInt(txt_blok_no.getText());
        
        
        try {
            String sql = "SELECT * FROM \"DAIRE\" "+" WHERE daire_no="+daire+" and blok_no="+blok+" ";
            sonuc=ifade.executeQuery(sql);
            
            System.out.println(sql);
            while(sonuc.next()){
                eleme = sonuc.getInt("daire_nop");
                
            }
            
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        return eleme;
        
    }
    
    public void ayarla_sil()
    {
        
        try {
            //ifade = baglanti.createStatement();
            int row=AidatNoDondur();
            System.out.println(row);
            
            String sql = " DELETE FROM \"AIDAT\" "+" WHERE aidat_no = "+row+" ";
            System.out.println(sql);
            ifade.execute(sql);
           
           
        } catch (SQLException ex) {
            //ex.printStackTrace();
        }
        
    }
    
    public void baslangic()
    {
        
       VerileriGetir();
       tabloyuDoldur();

        //VerileriGoster();
        //txtBosalt();
    }
    
    
    public Sakin_bilgi() {
        initComponents();
        baslangic();
        
    }
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_sakin_tc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_sakin_adi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_sakin_soyadi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_sakin_tel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_sakin_meslek = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_sakin_yas = new javax.swing.JTextField();
        btn_kaydet = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_ilk_kayıt = new javax.swing.JButton();
        btn_son_kayit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_sakin_daire_numarasi = new javax.swing.JTextField();
        txt_arama = new javax.swing.JTextField();
        btn_arama = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmb_aidat = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txt_blok_no = new javax.swing.JTextField();
        txt_aidat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sakin = new javax.swing.JTable();
        btn_temizle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sakin TC:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sakin Adı:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sakin Soyadı");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sakin Tel");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Sakin Meslek");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sakin Yas");

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

        btn_ilk_kayıt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ilk_kayıt.setText("ilk kayıt");
        btn_ilk_kayıt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ilk_kayıtActionPerformed(evt);
            }
        });

        btn_son_kayit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_son_kayit.setText("son kayıt");
        btn_son_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_son_kayitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Daire Numarası");

        btn_arama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_arama.setText("tc numarasına göre ara");
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Aidat odeme durumu");

        cmb_aidat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_aidat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ocak", "subat ", "mart", "nisan", "mayıs", "haziran", "temmuz", "ağustos", "eylül", "ekim", "kasım", "aralık", " " }));
        cmb_aidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_aidatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Blok Numarası");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("miktar");

        tbl_sakin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_sakin);

        btn_temizle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_temizle.setText("temizle");
        btn_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_temizleActionPerformed(evt);
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
                        .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_arama))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ilk_kayıt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_son_kayit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_aidat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_aidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_blok_no, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sakin_daire_numarasi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_sakin_tc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sakin_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sakin_soyadi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sakin_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sakin_meslek, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sakin_yas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_kaydet)
                .addGap(33, 33, 33)
                .addComponent(btn_sil)
                .addGap(18, 18, 18)
                .addComponent(btn_guncelle)
                .addGap(18, 18, 18)
                .addComponent(btn_temizle)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_sakin_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sakin_adi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_sakin_soyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_sakin_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sakin_meslek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_sakin_yas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_sakin_daire_numarasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_blok_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmb_aidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_aidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_kaydet)
                            .addComponent(btn_sil)
                            .addComponent(btn_guncelle)
                            .addComponent(btn_temizle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ilk_kayıt)
                    .addComponent(btn_son_kayit))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_arama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_arama))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaydetActionPerformed
        
        
        int nop=daire_no_dondur();
        String tc = txt_sakin_tc.getText();
        String ad = txt_sakin_adi.getText();
        String soyad = txt_sakin_soyadi.getText();
        String tel= txt_sakin_tel.getText();
        String meslek = txt_sakin_meslek.getText();
        
        int blok_no = Integer.parseInt(txt_blok_no.getText());
        int yas = Integer.parseInt(txt_sakin_yas.getText());

        String sql = "INSERT INTO \"SAKINLER\"(sakin_tc,sakin_adi,sakin_soyadi,sakin_yas,sakin_tel,sakin_meslek,blok_no,daire_no) VALUES('"+tc+"', '"+ad+"', '"+soyad+"', "+yas+",'"+tel+"','"+meslek+"',"+blok_no+","+nop+" )";
        try{
            
     
              //ifade = baglanti.createStatement();
              //System.out.println(sql);
              ifade.execute(sql);
              //ifade.close();
              ayarla();
              VerileriGetir();
              //VerileriGoster();
              txtBosalt();
              tabloyuDoldur();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_kaydetActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
    //ResultSet sonuc;
        try
        {
            ayarla_sil();
            //ifade = baglanti.createStatement();
            String sql = " DELETE FROM \"SAKINLER\" "+" WHERE sakin_tc = '"+txt_sakin_tc.getText()+"' ";
           
            ifade.execute(sql);
            
            tabloyuDoldur();
            System.out.println(sql);
            //VerileriGetir();
            
            //VerileriGoster();
            //txtBosalt();
            //sonuc.next();
            
            //sonuc.close();
           // ifade.close();
            
            //VerileriGetir();
            //txtBosalt();
             
            }
        catch(SQLException e)
        {
            //e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        String tc = txt_sakin_tc.getText();
        String ad = txt_sakin_adi.getText();
        String soyad = txt_sakin_soyadi.getText();
        String tel= txt_sakin_tel.getText();
        String meslek = txt_sakin_meslek.getText();
        int nop=daire_no_dondur();
        int yas = Integer.parseInt(txt_sakin_yas.getText());
        int daire =Integer.parseInt(txt_sakin_daire_numarasi.getText());
        int blok_no = Integer.parseInt(txt_blok_no.getText());
        
       /* int borc=0;
        try {
            //ifade = baglanti.createStatement();
            if(sonuc != null)
            {
                if(sonuc.getString("sakin_tc").equals(tc))
                {
                    //int borc;
                   // String sql="Select borc from \"SAKINLER\" "+" where sakin_tc='"+tc+"'";
                   // int borc=Integer.parseInt(sql);
                   borc = sonuc.getInt("borc");
                    
                    if (cmb_aidat.getSelectedIndex() == 0)
                    {
                        if(borc==0)
                            borc=0;
                        else
                          borc = borc-1;
                    }  
                    else {
                        borc = borc+1;
                    }
                    
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
        
        try
        {
            String sql = " UPDATE \"SAKINLER\" SET "+
                    "sakin_tc='"+tc+"'"+
                    ", sakin_adi='"+ad+"'"+
                    ", sakin_soyadi='"+soyad+"'"+
                    ", sakin_tel='"+tel+"'"+
                    ", sakin_meslek='"+meslek+"'"+
                    ", sakin_yas="+yas+
                    ", daire_no="+nop+
                    ", blok_no="+blok_no+
                   
                   
                    
                    
                    " WHERE sakin_tc = '"+txt_sakin_tc.getText()+"' ";
            
            System.out.println(sql);
            ifade.execute(sql);
            //ifade.close();
            ayarla_guncelle();
            VerileriGetir();
            //VerileriGoster();
            //txtBosalt();
            tabloyuDoldur();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void btn_ilk_kayıtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ilk_kayıtActionPerformed
        try {
             VerileriGetir();
             
             txtBosalt();
             sonuc.first();
      
        int daireNo=0;
                
        if(sonuc != null)
        {
                daireNo=daire_bul(sonuc.getInt("daire_no"));
                System.out.println(daireNo);
                VerileriGetir();
                sonuc.first();
                txt_sakin_tc.setText(sonuc.getString("sakin_tc"));
                txt_sakin_adi.setText(sonuc.getString("sakin_adi"));
                txt_sakin_soyadi.setText(sonuc.getString("sakin_soyadi"));
                txt_sakin_tel.setText(sonuc.getString("sakin_tel"));
                txt_sakin_meslek.setText(sonuc.getString("sakin_meslek"));
                txt_sakin_yas.setText(sonuc.getString("sakin_yas"));
                txt_sakin_daire_numarasi.setText(String.valueOf(daireNo));
                txt_blok_no.setText(sonuc.getString("blok_no"));
             //VerileriGoster();
             //ifade.close();
             //VerileriGetir();
        }  
            
        } catch (SQLException ex) {
                   ex.printStackTrace();
                }
    }//GEN-LAST:event_btn_ilk_kayıtActionPerformed

    private void btn_son_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_son_kayitActionPerformed
        try {
            VerileriGetir();
             
             txtBosalt();
             sonuc.last();
      
        int daireNo=0;
                
        if(sonuc != null)
        {
                txt_sakin_tc.setText(sonuc.getString("sakin_tc"));
                txt_sakin_adi.setText(sonuc.getString("sakin_adi"));
                txt_sakin_soyadi.setText(sonuc.getString("sakin_soyadi"));
                txt_sakin_tel.setText(sonuc.getString("sakin_tel"));
                txt_sakin_meslek.setText(sonuc.getString("sakin_meslek"));
                txt_sakin_yas.setText(sonuc.getString("sakin_yas"));
                txt_blok_no.setText(sonuc.getString("blok_no"));
                daireNo=daire_bul(sonuc.getInt("daire_no"));
                System.out.println(daireNo);
                txt_sakin_daire_numarasi.setText(String.valueOf(daireNo));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_son_kayitActionPerformed

    private void btn_aramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aramaActionPerformed
         
        String tc_no = txt_arama.getText();
        VerileriGetir();
        
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
                if(sonuc.getString("sakin_tc").equals(tc_no))
                {
                    bulundu = true;
                    break;
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
            int daireNo=0;
                
        if(sonuc != null)
        {
           
                
                txt_sakin_tc.setText(sonuc.getString("sakin_tc"));
                txt_sakin_adi.setText(sonuc.getString("sakin_adi"));
                txt_sakin_soyadi.setText(sonuc.getString("sakin_soyadi"));
                txt_sakin_tel.setText(sonuc.getString("sakin_tel"));
                txt_sakin_meslek.setText(sonuc.getString("sakin_meslek"));
                txt_sakin_yas.setText(sonuc.getString("sakin_yas"));
                txt_blok_no.setText(sonuc.getString("blok_no"));
                daireNo=daire_bul(sonuc.getInt("daire_no"));
                System.out.println(daireNo);
                txt_sakin_daire_numarasi.setText(String.valueOf(daireNo));
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      
    }//GEN-LAST:event_btn_aramaActionPerformed

    private void cmb_aidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_aidatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_aidatActionPerformed

    private void btn_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_temizleActionPerformed
        txtBosalt();
    }//GEN-LAST:event_btn_temizleActionPerformed

    
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
            java.util.logging.Logger.getLogger(Sakin_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sakin_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sakin_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sakin_bilgi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sakin_bilgi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_arama;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_ilk_kayıt;
    private javax.swing.JButton btn_kaydet;
    private javax.swing.JButton btn_sil;
    private javax.swing.JButton btn_son_kayit;
    private javax.swing.JButton btn_temizle;
    private javax.swing.JComboBox cmb_aidat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_sakin;
    private javax.swing.JTextField txt_aidat;
    private javax.swing.JTextField txt_arama;
    private javax.swing.JTextField txt_blok_no;
    private javax.swing.JTextField txt_sakin_adi;
    private javax.swing.JTextField txt_sakin_daire_numarasi;
    private javax.swing.JTextField txt_sakin_meslek;
    private javax.swing.JTextField txt_sakin_soyadi;
    private javax.swing.JTextField txt_sakin_tc;
    private javax.swing.JTextField txt_sakin_tel;
    private javax.swing.JTextField txt_sakin_yas;
    // End of variables declaration//GEN-END:variables
}
