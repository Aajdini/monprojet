package base;

import domaine.Departement;
import domaine.Fonction;
import domaine.Lieu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Gestion des accès à la base de données pour l'entité Departement.
 *
 * @author AJDINI Artrit
 * 
*/
public class DepartementDao {
    private static Departement departement;
    private static Lieu lieu;
    
    /** Retourne le Departement d'identifiant noDept, null en cas d'erreur */
    public static Departement getDepartement (int noDept) {
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  NoDept, NomDept, NoLieu  FROM departement where NoDept = " + noDept );
            while(rs.next()){
                lieu = LieuDao.getLieu(rs.getInt("NoLieu"));
                departement = new Departement(rs.getInt("NoDept"), rs.getString("NomDept"),lieu);
            }
            stmt.close(); 
        }
        catch (SQLException e) {System.out.println(e.getMessage()); e.printStackTrace(); return null;}
        //System.out.println(fonction);
       return departement;
    } // getDepartement
    
    public static ArrayList getDepartements(){
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoDept, NomDept, NoLieu FROM departement ORDER BY NomDept");
            while (rs.next()) {
                lieu = LieuDao.getLieu(rs.getInt("NoLieu"));
                departement = new Departement(rs.getInt("NoDept"),rs.getString("NomDept"),lieu);
                liste.add(departement);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.getEmployes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getDepartements
    

} // DepartementDao
