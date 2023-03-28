package factory;
import objets.Armes;
import objets.Bouclier;
import objets.Epee;
import personnage.Heros;
import personnage.Monstre;

import java.util.Random;

public class HeroFactory {

    /**
     * Permet de creer un Hero
     * @return Nous retourne un Héro
     */
    public Heros creerHero(){
            Heros hero = new Heros();
            return hero;
    }
}
