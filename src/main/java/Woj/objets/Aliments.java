package Woj.objets;

public class Aliments implements Items {
    private String nom;
    private double poid;
    private int pointDeRegeneration;

    /**
     * Constructeur d'un Aliment
     * @param nom nom de l'aliment
     * @param poid poid de l'aliment
     * @param pointDeRegeneration Point De Régénération de l'aliment
     */
    public Aliments(String nom, double poid, int pointDeRegeneration) {
        this.nom = nom;
        this.poid = poid;
        this.pointDeRegeneration = pointDeRegeneration;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public double getPoid() {
        return poid;
    }

    public int getPointDeRegeneration() {
        return pointDeRegeneration;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }

    public void setPointDeRegeneration(int pointDeRegeneration) {
        this.pointDeRegeneration = pointDeRegeneration;
    }

    @Override
    public String toString() {
        return nom;
    }
}
