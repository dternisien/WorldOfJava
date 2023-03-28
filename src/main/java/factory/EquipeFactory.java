package factory;

import objets.Bouclier;
import objets.Epee;
import objets.Gourdin;
import objets.Sacoche;
import personnage.Equipe;
import personnage.Heros;
import personnage.Monstre;
import personnage.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
