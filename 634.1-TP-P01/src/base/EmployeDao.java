package base;

import domaine.Departement;
import domaine.Employe;
import domaine.Fonction;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * 
 *
 * @author AJDINI Artrit
 * 
*/
public class EmployeDao {
    /** Retourne la liste complète des Employes dans l'ordre des nom et prénom, null en cas d'erreur */
    public static ArrayList getEmployes () {
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoDept FROM Employe ORDER BY NomEmpl, PrenomEmpl");
            while (rs.next()) {
                Fonction f = FonctionDao.getFonction(rs.getInt("NoFonc"));
                Departement d = DepartementDao.getDepartement(rs.getInt("NoDept"));
                Employe e = new Employe(rs.getInt("NoEmpl"), rs.getString("NomEmpl"), rs.getString("PrenomEmpl"), f, rs.getDate("DateEmpl"), d);
                liste.add(e);
                //System.out.println(e);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.getEmployes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getEmployes
    
    public static int supprimerEmploye(Employe employe){
        try {
            Connection con = ConnexionBase.get();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM employe WHERE NoEmpl = ?" );
            stmt.setInt(1, employe.getNoEmpl());
            int nbDel = stmt.executeUpdate();
            stmt.close();
            return nbDel;
        }
        catch (SQLException e) {System.out.println("Message d'erreur : " + e.getMessage()); e.printStackTrace(); return 0;}
    }//supprimerEmploye
    
    public static void ajouterEmploye(String nom, String prenom, String date, Fonction fonction , Departement departement){
            java.sql.Date  d = creerDate(date);
        try{
             System.out.println("AJOUT");
             Connection con = ConnexionBase.get();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO employe (NomEmpl,PrenomEmpl,DateEmpl,NoFonc,NoChef, NoDept) VALUES(?,?,?,?,?,?)");
             stmt.setString(1, nom);
             stmt.setString(2, prenom);
             stmt.setDate(3, d);
             stmt.setInt(4, fonction.getNoFonc());
             stmt.setInt(5, 0);
             stmt.setInt(6, departement.getNoDept());
             stmt.executeUpdate();
             stmt.close();
         }
         catch (SQLException e) {System.out.println("Message d'erreur" + e.getMessage()); e.printStackTrace();} 
    }//ajouterEmploye
    
    private static java.sql.Date creerDate(String str){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
                java.util.Date parsed = format.parse(str);
                java.sql.Date sql = new java.sql.Date(parsed.getTime());
                System.out.println(sql);
                return sql;
        }
        catch (Exception e) {
                System.out.println("EmployeDao.getEmployes(): " + e.getMessage());
        }
        return null;
    }//creerDate
    
} // EmployeDao
