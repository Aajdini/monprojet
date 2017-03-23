package metier;

import base.DepartementDao;
import domaine.Departement;

/**
 * Liste des Departements dans l'ordre des noms avec une position courante
 *
 * @author LKABOUSSE
 * @version 2.0
 */
public class ListeDepartements extends ListeObjects {
  
    /** Constructeur */
    public ListeDepartements () {liste = DepartementDao.getDepartements();}

    /** Retourne le département courant, null si la position courante est NO_POS */
    public Departement getDepartementCourant () {return (Departement)super.getCourant();}

    /** Retourne le département d'indice k, null si k n'est pas correctement défini */
    public Departement getDepartement (int k) {return (Departement)super.get(k);}
  
} // ListeDepartements
