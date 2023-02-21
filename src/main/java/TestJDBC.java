

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {

   public static void main(String argv[]) {

      try {
         Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/concert", "root", "");
         System.out.println("Connexion JDBC OK");

         Statement req = conn.createStatement();
         ResultSet res = req.executeQuery("select * from sport");
         System.out.println("La liste des sports : ");
         while (res.next())
            System.out.println(" - " + res.getString(2));
      }
      catch (Exception e) {
         System.err.println("Erreur : " + e);
         e.printStackTrace();
      }
   }
}