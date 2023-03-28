package factory;

import objets.Bouclier;
import objets.Epee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BouclierFactory {

    private List<Bouclier> listBoucliers;

    /**
     * Permet de créer une liste de Boucliers
     * @param nbrBouclier Nombre de boucliers a créer
     */
    public void creationBouclier(int nbrBouclier){
        List<Bouclier> boucliers = new ArrayList<>();
        for (int i = 0; i < nbrBouclier; i++) {
            Random bouclierAleatoire = new Random();
            int bouclier = bouclierAleatoire.nextInt(0, 10);
            if (bouclier < 2) {
                Bouclier bouclierFer = new Bouclier("Bouclier en fer", 50, 15);
                boucliers.add(bouclierFer);
            } else {
                Bouclier bouclierBois = new Bouclier("Bouclier en bois", 25, 7);
                boucliers.add(bouclierBois);
            }
        }
        this.listBoucliers = boucliers;
    }

    public List<Bouclier> getListBoucliers() {
        return listBoucliers;
    }
}
