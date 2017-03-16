package domaine;

/**
 *
 * @author Artrit
 */
public class Lieu {
    
    private int noLieu;
    private String nomLieu;
    
    //Constructeur
    public Lieu(int no , String nom){
        this.noLieu = no;
        this.nomLieu =  nom;
    }
    
    //Accesseurs
    public int getNoLieu(){return noLieu;}
    public void setNoLieu(int no){this.noLieu = no;}
    public String getNomLieu(){return nomLieu;}
    public void setNomLieu(String nom){this.nomLieu = nom;}

    //toString
    public String toString(){
        return nomLieu;
    }
}
