package objets;

import objets.Armes;

public class Gourdin extends Armes {

    /**
     * Permet la création D'un Gourdin
     * @param nom
     * @param point_de_degats
     * @param longueur
     * @param poid
     */
    public Gourdin(String nom,int point_de_degats, double longueur, double poid) {
        super(nom, point_de_degats, longueur, poid);
    }
}
