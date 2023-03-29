package Woj.factory;

import Woj.objets.Aliments;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NouritureFactory {
    private List<Aliments> listNouriture;

    public List<Aliments> getListNouriture() {
        return listNouriture;
    }

    /**
     * Permet de créer un liste d'Aliments
     * @param nbrNouriture Entrer le nombre d'aliment qu'il y aura dans la liste
     * @return Un liste d'Aliments
     */
    public List<Aliments> creationNouriture(int nbrNouriture){
        Random random = new Random();
        listNouriture = new ArrayList<>();
        for (int i = 0; i < nbrNouriture; i++) {
            int aleatoire = random.nextInt(0,10);
            if (aleatoire == 0){
                listNouriture.add(creationCookies());
            }else {
                listNouriture.add(creationPommes());
            }
        }
        return listNouriture;
    }

    /**
     * Permet de créer un Aliment Pomme
     * @return Retourne un Aliments
     */
    public Aliments creationPommes(){
        Aliments pomme=new Aliments("Pomme",600,15);
        return pomme;
    }

    /**
     * Permet de créer un Aliments Cookie
     * @return Retourne un Aliments
     */
    public Aliments creationCookies(){
        Aliments cookie = new Aliments("Cookie",200,40);
        return cookie;
    }
}
