package base;

import domaine.Fonction;
import domaine.Lieu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AJDINI Artrit
 */
public class LieuDao {
    private static Lieu lieu;
    /** Retourne le Lieu d'identifiant noLieu, null en cas d'erreur */
    public static Lieu getLieu (int noLieu) {
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoLieu, NomLieu FROM lieu where NoLieu = " + noLieu );
            while(rs.next()){
                lieu = new Lieu(rs.getInt("NoLieu"), rs.getString("NomLieu"));
            }
            stmt.close(); 
        }
        catch (SQLException e) {System.out.println(e.getMessage()); e.printStackTrace(); return null;}
        //System.out.println(fonction);
       return lieu;
    } // getLieu
}
