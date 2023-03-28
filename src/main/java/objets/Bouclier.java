package objets;

public class Bouclier implements Items{

    private String nom;
    private double poid;
    private int pointEncaissement;

    /**
     * Création d'un Bouclier
     * @param nom Nom du bouclier
     * @param poid poid du bouclier
     * @param pointEncaissement Point d'encaissement du bouclier
     */
    public Bouclier(String nom, double poid, int pointEncaissement) {
        this.nom = nom;
        this.poid = poid;
        this.pointEncaissement = pointEncaissement;
    }

    public int getPointEncaissement() {
        return pointEncaissement;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public double getPoid() {
        return this.poid;
    }

    @Override
    public String toString() {
        return  nom;
    }
}
