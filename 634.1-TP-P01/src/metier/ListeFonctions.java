package metier;

import base.FonctionDao;
import domaine.Fonction;

/**
 * Liste des Fonctions dans l'ordre des noms avec une position courante
 *
 * @author LKABOUSSE
 * @version 2.0
 */
public class ListeFonctions extends ListeObjects {
  
    /** Constructeur */
    public ListeFonctions () {liste = FonctionDao.getFonctions();}

    /** Retourne la fonction courante, null si la position courante est NO_POS */
    public Fonction getFonctionCourante () {return (Fonction)super.getCourant();}

    /** Retourne la fonction d'indice k, null si k n'est pas correctement défini */
    public Fonction getFonction (int k) {return (Fonction)super.get(k);}
  
} // ListeFonctions
