package Woj.objets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sacoche {
    private List<Bouclier> boucliers;
    private List<Aliments> listNouriture;
    private List<Armes> armes;
    private Aliments aliments;

    /**
     * Permet la création d'une sacoche qui contient des Items
     */
    public Sacoche() {
        this.boucliers = new ArrayList<>();
        this.listNouriture = new ArrayList<>();
        this.armes = new ArrayList<>();
    }

    /**
     * Ajouter un bouclier à la liste de boucliers
     * @param bouclier
     */
    public void ajouterBouclier(Bouclier bouclier){
        boucliers.add(bouclier);
    }

    /**
     * Ajouter un Aliment a la liste d'Aliments
     * @param aliment
     */
    public void ajouterAliment(Aliments aliment){
        this.listNouriture.add(aliment);
    }

    /**
     * Ajouter une Arme à la liste d'armes
     * @param arme
     */
    public void ajouterArmes(Armes arme){
        this.armes.add(arme);
    }

    public List<Armes> getArmes() {
        return armes;
    }

    public void setArmes(List<Armes> armes) {
        this.armes = armes;
    }

    public List<Aliments> getListNouriture() {
        return listNouriture;
    }

    /**
     * Permet de récupérer un Aliment dans la liste d'aliments
     * @return Un Aliment
     */
    public Aliments recupererAliment(){
        Random random = new Random();
        int aleatoire = random.nextInt(0,this.listNouriture.size());
        Aliments aliment = this.listNouriture.get(aleatoire);
        this.listNouriture.remove(aleatoire);
        return aliment;
    }

    @Override
    public String toString() {
        return  "boucliers=" + boucliers +
                ", nouriture=" + listNouriture +
                ", armes=" + armes;
    }
}
