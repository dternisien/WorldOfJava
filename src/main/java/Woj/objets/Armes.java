package Woj.objets;

public class Armes implements Items{
    private String nom;
    private double poid;
    private int point_de_degats;
    private double longueur;

    /**
     * Permet de créer une Arme
     * @param nom nom de l'arme
     * @param point_de_degats degats de l'arme
     * @param longueur longueur de l'arme
     * @param poid poid de l'arme
     */
    public Armes(String nom, int point_de_degats, double longueur, double poid) {
        this.nom = nom;
        this.poid=poid;
        this.point_de_degats = point_de_degats;
        this.longueur = longueur;
    }

    public int getPoint_de_degats() {
        return point_de_degats;
    }

    public double getLongueur() {
        return longueur;
    }

    public String getNom() {
        return nom;
    }

    public double getPoid() {
        return poid;
    }

    @Override
    public String toString() {
        return nom ;
    }
}
