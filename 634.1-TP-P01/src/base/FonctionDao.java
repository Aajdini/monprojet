package base;

import domaine.Departement;
import domaine.Employe;
import domaine.Fonction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Gestion des accès à la base de données pour l'entité Fonction.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 0.1
*/
public class FonctionDao {
    private static Fonction fonction;
    /** Retourne la Fonction d'identifiant noFonc, null en cas d'erreur */
    public static Fonction getFonction (int noFonc) {
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoFonc, NomFonc FROM fonction where NoFonc = " + noFonc );
            while(rs.next()){
                fonction = new Fonction(rs.getInt("NoFonc"), rs.getString("NomFonc"));
            }
            stmt.close(); 
        }
        catch (SQLException e) {System.out.println(e.getMessage()); e.printStackTrace(); return null;}
        //System.out.println(fonction);
       return fonction;
    } // getFonction
    
    public static ArrayList getFonctions(){
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoFonc, NomFonc FROM fonction ORDER BY NomFonc");
            while (rs.next()) {
                Fonction f = FonctionDao.getFonction(rs.getInt("NoFonc"));
                liste.add(f);
                //System.out.println(e);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.getEmployes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getFonctions
}
  

