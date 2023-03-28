package objets;

public class Epee extends Armes {
    private String nom ;

    /**
     * Permet de créer un Epée
     * @param nom
     * @param point_de_degats
     * @param longueur
     * @param poid
     */
    public Epee(String nom, int point_de_degats, double longueur, double poid) {
        super(nom, point_de_degats, longueur, poid);
    }

    @Override
    public String getNom() {
        return nom;
    }

}
