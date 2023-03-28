package personnage;

import objets.*;

public abstract class Personnage {
    private int point_de_vie ;
    private String nom ;
    private Armes arme;
    private int endurance;
    private Sacoche sacoche;
    private Bouclier bouclier;

    /**
     * Création d'un personnage avec Nom, pv , Endurance  Aleatoire
     */
    public Personnage() {
        this.point_de_vie = creationPV();
        this.nom = creationNom();
        this.endurance = creationEndurance();
        this.sacoche = creationSacoche();
    }
    public Personnage( Armes arme,Bouclier bouclier) {
        this.nom = creationNom();
        this.point_de_vie = creationPV();
        this.arme = arme;
        this.sacoche = new Sacoche();
        this.bouclier = bouclier;
    }


    public abstract String creationNom();
    public abstract int creationPV();
    public abstract int creationEndurance();

    public abstract Sacoche creationSacoche();

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public Sacoche getSacoche() {
        return sacoche;
    }

    public String getNom() {
        return nom;
    }

    public Bouclier getBouclier() {
        return bouclier;
    }

    public void setBouclier(Bouclier bouclier) {
        this.bouclier = bouclier;
    }

    public int getEndurance() {
        return endurance;
    }

    public Armes getArme() {
        return arme;
    }

    public void setArme(Armes arme) {
        this.arme = arme;
    }

    /**
     * Permet au personnage de manger et de récupérer de l'endurance en fonction de l'aliment
     * Voir les aliments dans NouritureFactory
     */
    public void manger(){
        Aliments aliment = getSacoche().recupererAliment();
        this.endurance += aliment.getPointDeRegeneration();
        System.out.println(this.nom+" mange et récupère "+aliment.getPointDeRegeneration()+" d'endurance ");
        System.out.println("Nouvelle endurance "+ this.endurance);
    }

    /**
     * Permet au Personnage de se défendre en fonction des point d'encaissement de son bouclier
     * @param degats
     */
    public void seDefendre(int degats){
        if (this.bouclier != null) {
            if (this.endurance >= this.getBouclier().getPoid() / 10000) {
                this.point_de_vie -= degats - this.bouclier.getPointEncaissement();
            } else {
                this.point_de_vie -= degats;
            }
        }else {
            this.point_de_vie -= degats;
        }
    }

    /**
     * Permet au personnage d'attaquer en fonction des dégats de son arme
     * Le Personage perd aussi de l'endurance en fonction de son arme avec la formule
     * (Poid * longueur ) / 10000
     * @param personnage
     */
    public void attaquer(Personnage personnage){
            this.endurance -= (this.arme.getPoid()* this.arme.getLongueur()) / 10000;
            personnage.seDefendre(this.arme.getPoint_de_degats());
        }

    /**
     * Permet de voir si un personnage possède un bouclier
     * @return Boolean
     */
    public boolean checkBouclier(){
        if (getBouclier() != null){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return  "{"+nom +
                " Point de vie= " + point_de_vie+
                ", Arme= " + arme+
                ", Items="+ sacoche+
                ", Endurance= "+ endurance
                +"}"+"\n";
    }
}
