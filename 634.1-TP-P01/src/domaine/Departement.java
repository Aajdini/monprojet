package domaine;

/**
 *
 * @author Artrit
 */
public class Departement {
    private int noDept;
    private String nomDept;
    private Lieu lieu;
    
    //Constrcteur
    public Departement(int no, String nom, Lieu lieu){
        this.noDept = no;
        this.nomDept = nom;
        this.lieu = lieu;
    }
    //Accesseurs
    public int getNoDept(){return noDept;}
    public void setNoDept(int no){this.noDept = no;}
    public String getNomDept(){return nomDept;}
    public void setNomDept(String nom){this.nomDept = nom;}
    public Lieu getLieu(){return lieu;}
    public void setLieu(Lieu lieu){this.lieu = lieu;}
    
    //toString
    public String toString(){
        return nomDept; 
    }
}
