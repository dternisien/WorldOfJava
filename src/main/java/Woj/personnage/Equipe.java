package Woj.personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Equipe {
    private  List<Personnage> membreEquipe ;

    /**
     * Permet des créer une liste d'équipes
     * @param listEquipe
     */
    public Equipe(List<Personnage> listEquipe) {
        this.membreEquipe = listEquipe;
    }

    public List<Personnage> getMembreEquipe() {
        return this.membreEquipe;
    }

    /**
     * Permet de récupérer un Héro dans une liste d'Héros
     * @param indexList L'emplacement du Héro dans la liste
     * @return Un Héro
     */
    public Personnage getHeros(int indexList){
      return membreEquipe.get(indexList);
    }

    /**
     * Récupérer le nombre de membres vivant dans une Equipe
     * @return Un nombre entier
     */
    public int getNbrMembreVivant(){
        int compteur = 0;
        for (Personnage personnage:this.membreEquipe) {
            if (personnage.getPoint_de_vie() > 0){
                compteur++;
            }
        }
        return compteur;
    }

    /**
     * Récupérer un membre vivant Aléatoire dans une Equipe
     * @return Un Personnage
     */
    public Personnage getMembreVivantAleatoire(){
        List<Integer>indexMembresVivant = new ArrayList<>();
        for (int i = 0; i < this.membreEquipe.size(); i++) {
            if (this.membreEquipe.get(i).getPoint_de_vie() > 0){
                indexMembresVivant.add(i);
            }
        }
        Random random = new Random();
        int index = random.nextInt(0,indexMembresVivant.size());
        int membreChoisi = indexMembresVivant.get(index);
        return this.membreEquipe.get(membreChoisi);
    }

    /**
     * Récupérer un Monstre dans une liste de monstre
     * @param indexList Emplacement du monstre dans la liste
     * @return Un Personnage Monstre
     */
    public Personnage getMonstres(int indexList){
        return  membreEquipe.get(indexList);
    }

    @Override
    public String toString() {
        return "" +
            membreEquipe ;
    }
}
