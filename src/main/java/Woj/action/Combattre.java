package Woj.action;

import Woj.Couleur;
import Woj.personnage.Equipe;
import Woj.personnage.Personnage;

import java.util.Random;

public class Combattre {

    /**
     * Création d'un combats entre un héro et un monstre
     * @param hero
     * @param monstre
     */
    public void combats(Personnage hero, Personnage monstre){
        int rounds = 0;

        while (checkPersonnageEnVie(hero, monstre)){
            rounds++;
            System.out.println(Couleur.ANSI_WHITE);
            System.out.println("Round :"+rounds);
            if (choixAttaquant()){
                if (decisionPersonnage(hero) == 1){
                    attaquer(hero,monstre);
                }else {
                    attaquer(monstre,hero);
                }
            }else {
                if (decisionPersonnage(monstre) == 0) {
                    attaquer(monstre, hero);
                }else {
                    attaquer(hero,monstre);
                }
            }
        }
        finCombats(hero,monstre);
    }

    /**
     * Décision d'un personnage de manger ou d'attaquer en fonction de son endurance
     * @param personnage
     * @return Un entier 1 ou 0
     */
    public int decisionPersonnage(Personnage personnage){
        if (personnage.getEndurance() < 10){
            if (!personnage.getSacoche().getListNouriture().isEmpty()){
                System.out.println(Couleur.ANSI_BLUE+personnage.getNom()+" n'a plus d'endurances"+Couleur.ANSI_RESET);
                personnage.manger();
                return 0;
            }
        }
        return 1;
    }

    /**
     * Permet à une Equipe de heros et une Equipe de Monstres
     * de combattre jusqu'a ce q'une des deux Equipe n'ai plus de membre vivants
     * @param heros Equipe de Héros
     * @param monstres Equipe de Monstres
     */
    public void combatsEquipe(Equipe heros, Equipe monstres){
        int numCombat = 0;
        while (checkPersonnageVivant(heros,monstres)) {
            Personnage hero = heros.getMembreVivantAleatoire();
            Personnage monstre = monstres.getMembreVivantAleatoire();

            numCombat++;
            System.out.println();
            System.out.print("Combat: "+numCombat);
            System.out.println();
            combats(hero, monstre);
        }
    }

    /**
     * Permet de checker si une Equipe de Héros et une Equipe de Monstre possède encore des membre vivant
     * Si l'une des deux equipe n'a plus de membre vivant la fonction retourne false
     * @param hero
     * @param monstre
     * @return Boolean
     */
    public boolean checkPersonnageVivant(Equipe hero, Equipe monstre){

        if (hero.getNbrMembreVivant() > 0 && monstre.getNbrMembreVivant() > 0){
            return true;
        }else if (hero.getNbrMembreVivant() == 0 ){
            System.out.println(Couleur.ANSI_YELLOW);
            System.out.println("L'equipe des Monstre gagne avec : "+monstre.getNbrMembreVivant()+ " Personnages vivant"+ Couleur.ANSI_RESET);
            return false;
        }else if (monstre.getNbrMembreVivant() == 0){
            System.out.println(Couleur.ANSI_YELLOW);
            System.out.println("L'équipe des Héro gagne avec : "+hero.getNbrMembreVivant()+" Personnages Vivant"+ Couleur.ANSI_RESET);
            return false;
        }
        return false;
    }

    /**
     * Permet d'attaquer
     * @param attaquant
     * @param defenseur
     */
    public void attaquer(Personnage attaquant, Personnage defenseur){
            if (defenseur.checkBouclier()){
                attaquant.attaquer(defenseur);
                System.out.println(Couleur.ANSI_BLUE+defenseur.getNom()+" Se defend !"+Couleur.ANSI_RESET);
                System.out.println(Couleur.ANSI_RED+"Attaquant: "+attaquant.getNom()+" PV : "+attaquant.getPoint_de_vie()+" Endurance : "+ attaquant.getEndurance()+" Degats: "+attaquant.getArme().getPoint_de_degats()+Couleur.ANSI_RESET);
                System.out.println(Couleur.ANSI_BLUE+"Defenseur: "+defenseur.getNom()+" PV : "+defenseur.getPoint_de_vie()+" Endurance : "+defenseur.getEndurance()+" Degats: "+defenseur.getArme().getPoint_de_degats()+" Bouclier: "+defenseur.getBouclier().getNom()+Couleur.ANSI_RESET);
            }else {
                attaquant.attaquer(defenseur);
                System.out.println(Couleur.ANSI_RED+"Attaquant: "+attaquant.getNom()+" PV : "+attaquant.getPoint_de_vie()+" Endurance : "+ attaquant.getEndurance()+" Degats: "+attaquant.getArme().getPoint_de_degats()+Couleur.ANSI_RESET);
                System.out.println(Couleur.ANSI_BLUE+"Defenseur: "+defenseur.getNom()+" PV : "+defenseur.getPoint_de_vie()+" Endurance : "+defenseur.getEndurance()+" Degats: "+defenseur.getArme().getPoint_de_degats()+Couleur.ANSI_RESET);
            }
    }

    /**
     * Afficher la fin du combats entre un Hero et un Monstre
     * @param hero
     * @param monstre
     */
    public void finCombats(Personnage hero, Personnage monstre){
        System.out.println();
        System.out.println("Fin du combats ");
        if (hero.getPoint_de_vie() <=0 ){
            System.out.println();
            System.out.println(Couleur.ANSI_RED+"Le Héro "+hero.getNom()+ " est mort "+Couleur.ANSI_RESET);
            System.out.println(Couleur.ANSI_BLUE+"Le Monstre "+monstre.getNom()+" Gagne !"+Couleur.ANSI_RESET);
        }else {
            System.out.println();
            System.out.println(Couleur.ANSI_RED+"Le Monstre "+monstre.getNom()+" est mort "+Couleur.ANSI_RESET);
            System.out.println(Couleur.ANSI_BLUE+"Le Héro "+hero.getNom() + " Gagne !"+Couleur.ANSI_RESET);
        }
    }

    /**
     * Renvois un boolean true ou un boolean false
     * @return Boolean
     */
    public boolean choixAttaquant(){
        Random random = new Random();
        int choix = random.nextInt(0,2);
        if (choix == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Checker si les 2 personnage Hero et Monstre sont encore en vie
     * @param hero
     * @param monstre
     * @return Boolean 
     */
    public boolean checkPersonnageEnVie(Personnage hero, Personnage monstre){
        if (hero.getPoint_de_vie() > 0 && monstre.getPoint_de_vie() > 0){
            return true;
        }else {
            return false;
        }
    }
}
