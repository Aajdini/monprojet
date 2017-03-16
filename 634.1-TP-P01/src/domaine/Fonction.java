package domaine;
/**
 *
 * @author Artrit
 */
public class Fonction {
    private int noFonc;
    private String nomFonc;
   
    //Constructeur
    public Fonction(int no ,String nom){
        this.noFonc = no;
        this.nomFonc =  nom;
    } 
    //Accesseurs
    public int getNoFonc(){return noFonc;}
    public void setNoFonc(int no){this.noFonc = no;}
    public String getNomFonc(){return nomFonc;}
    public void setNomFonc(String nom){this.nomFonc = nom;}
    
    //toString
    public String toString(){
        return nomFonc;
    }
    
}
