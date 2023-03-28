package personnage;

import objets.Armes;
import objets.Bouclier;
import objets.Sacoche;

import java.util.Random;

public class Heros extends Personnage {

    private Heros hero;

    /**
     * Création d'un héro
     */
    public Heros() {
        creationPV();
        creationNom();
        creationEndurance();
        creationSacoche();
    }
    public Heros(Armes arme,Bouclier bouclier) {
        super(arme,bouclier);
        creationPV();
        creationNom();
    }

    public Heros getHero() {
        return hero;
    }

    /**
     * Récupérer un nom de héro Aléatoire dans une liste
     * @return Un nom de héro
     */
    @Override
    public String creationNom() {
        Random random = new Random();

        String[] heros = new String[]{"Anub'arak","Muradin","Chen","Arthas","E.T.C","Balafré","Illidan"};
        String nomHero = heros[random.nextInt(0,heros.length)];
        return nomHero;
    }

    /**
     * Création d'un nombre de point de vie Aléatoire entre 25 et 75
     * @return Un nombre entier
     */
    public int creationPV(){
        Random random = new Random();

        int pv = random.nextInt(25,76);
        return pv;
    }

    /**
     * Création d'un nombre d'endurance Aléatoire entre 20 et 29
     * @return Un nombre entier
     */
    public int creationEndurance(){
        Random random = new Random();

        int endurance = random.nextInt(20,30);
        return endurance;
    }

    /**
     * Création d'une sacoche
     * @return Une Sacoche 
     */
    public Sacoche creationSacoche(){
        Sacoche sacoche = new Sacoche();
        return sacoche;
    }

    @Override
    public String toString() {
        return "Hero : " +super.toString();
    }
}
