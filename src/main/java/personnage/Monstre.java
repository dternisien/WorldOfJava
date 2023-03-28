package personnage;

import objets.Armes;
import objets.Bouclier;
import objets.Sacoche;
import personnage.Personnage;

import java.util.Random;

public class Monstre extends Personnage {
    /**
     * Création d'un monstre
     */
    public Monstre() {
        creationNom();
        creationPV();
        creationEndurance();
        creationSacoche();
    }
    public Monstre(Armes arme,Bouclier bouclier) {
        super(arme,bouclier);
        creationNom();
        creationPV();
        creationEndurance();
    }

    /**
     * Récupérer un nom aléatoi de monstre dans une list
     * @return Un nom de monstre
     */
    @Override
    public String creationNom() {
        Random random = new Random();

        String[] monstres = new String[]{"Rockjaw Trogg","Frostmane Troll","Gnoll","Kobold","Skeleton","Venom Spider","Basilisk "};
        String nomMonstre = monstres[random.nextInt(0,monstres.length)];
        return nomMonstre;
    }

    /**
     * Donner un nombre de point de vie Aleatoire entre 25 et 75
     * @return Un nombre entier
     */
    @Override
    public int creationPV(){
        Random random = new Random();

        int pv = random.nextInt(25,76);
        return pv;
    }

    /**
     * Créer un nombre d'endurance Aleatoire entre 20 et 29
     * @return Un nombre entier
     */
    public int creationEndurance(){
        Random random = new Random();

        int endurance = random.nextInt(20,30);
        return endurance;
    }

    /**
     * Créer une sacoche
     * @return Une Sacoche
     */
    public Sacoche creationSacoche(){
        Sacoche sacoche = new Sacoche();
        return sacoche;
    }


    @Override
    public String toString() {
        return "Monstre : " + super.toString();
    }
}
