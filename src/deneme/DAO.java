
package deneme;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class DAO {
    private String driver="org.postgresql.Driver";
    private String baglantiUrl="jdbc:postgresql://localhost:5432/SITE";
    private String kullaniciadi="postgres";
    private String parola="4321";
    private Connection baglanti=null;
    private void DbBaglan(){
        try{
            try {
               
                Class.forName(driver);           
                baglanti=DriverManager.getConnection(baglantiUrl,kullaniciadi,parola);
                //finalize();
                //baglanti.close();
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
      
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Connection getBaglanti(){
        if (baglanti==null){
             DbBaglan();
           
           
        }

        return baglanti;    

    }
       /*protected void finalize() throws Throwable  
        {  
        try { baglanti.close(); } 
        catch (SQLException e) { 
            e.printStackTrace();
        }
        super.finalize();  
        } */
}
