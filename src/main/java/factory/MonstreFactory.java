package factory;

import objets.Armes;
import personnage.Monstre;

public class MonstreFactory {

    /**
     * Permet de Créer un Monstre
     * @return Nous retourne un Monstre
     */
    public Monstre creerMonstre(){
        Monstre monstre = new Monstre();
        return monstre;
    }
}
