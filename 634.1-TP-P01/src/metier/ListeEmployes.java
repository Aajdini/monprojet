package metier;

import base.EmployeDao;
import domaine.Employe;

/**
 * Liste d'Employes dans l'ordre des noms et prénoms avec une position courante
 *
 * @author PLKABOUSSE
 * @version 2.0
 */
public class ListeEmployes extends ListeObjects {
  
    /** Constructeur */
    public ListeEmployes () {liste = EmployeDao.getEmployes();}

    /** Retourne l'employé courant, null si la position courante est NO_POS */
    public Employe getEmployeCourant () {return (Employe)super.getCourant();}

    /** Retourne l'employé d'indice k, null si k n'est pas correctement défini */
    public Employe getEmploye (int k) {return (Employe)super.get(k);}
  
} // ListeEmployes
