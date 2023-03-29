package Woj.factory;
import Woj.personnage.Heros;

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
