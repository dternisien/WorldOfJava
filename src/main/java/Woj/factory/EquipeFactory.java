package Woj.factory;

import Woj.personnage.Equipe;
import Woj.personnage.Heros;
import Woj.personnage.Monstre;
import Woj.personnage.Personnage;

import java.util.ArrayList;
import java.util.List;

public class EquipeFactory {

    /**
     * Permet de créer une Equipe de Monstres
     * @param nbrdeMonstreCreer Nombre de monstre que l'on souhaite créer
     * @return Equipe de monstres
     */
    public Equipe creerEquipeMonstre(int nbrdeMonstreCreer){
        List<Personnage> listMonstre = new ArrayList<>();
        for (int i = 0; i < nbrdeMonstreCreer; i++) {
            listMonstre.add(ajoutMonstre());
        }
        return new Equipe(listMonstre);
    }

    /**
     * Permet de créer une Equipe de Héros
     * @param nbrdeHeroCreer Nombre de Héros a créer
     * @return Equipe de Héros
     */
    public Equipe creerEquipeHero(int nbrdeHeroCreer){
        List<Personnage> listHero = new ArrayList<>();
        for (int i = 0; i < nbrdeHeroCreer; i++) {
            listHero.add(ajoutHero());
        }
        return new Equipe(listHero);
    }

    /**
     * Permet d'ajouter un Héro à une Equipe de Héros
     * @return Un Héro
     */
    public Heros ajoutHero(){
        HeroFactory creationHero = new HeroFactory();
        Heros hero = creationHero.creerHero();
        return hero;
    }

    /**
     * Permet d'ajouter un Monstre à une Equipe de Monstres
     * @return Un Monstre
     */
    public Monstre ajoutMonstre(){
        MonstreFactory creationMonstre = new MonstreFactory();
        Monstre monstre = creationMonstre.creerMonstre();
        return monstre;
    }
}
