package Woj;

import Woj.objets.Aliments;
import Woj.objets.Bouclier;
import Woj.objets.Epee;
import Woj.objets.Gourdin;
import Woj.action.Combattre;
import Woj.factory.ArmesFactory;
import Woj.factory.BouclierFactory;
import Woj.factory.EquipeFactory;
import Woj.factory.NouritureFactory;
import Woj.personnage.Equipe;
import Woj.personnage.Personnage;

import java.util.List;
import java.util.Random;

public class Monde {
    private Equipe equipeHeros;
    private Equipe equipeMonstres;
    private List<Epee> listEpee;
    private List<Gourdin> listGourdin;
    private List<Bouclier> listBoucliers;
    private List<Aliments> listNouriture;
    public Monde() {
    }
    public void initialiserMonde(int nbrPersonnageEquipe){

        //creation d'une equipe de Monstre en fonction de nbrPersonnageEquipe
        creationEquipeMonstres(nbrPersonnageEquipe);
        //creation d'une equipe de Héros en fonction de nbrPersonnageEquipe
        creationEquipeHeros(nbrPersonnageEquipe);
        System.out.println(Couleur.ANSI_CYAN+"-----------Creation des Monstres-----------");
        afficherEquipeMonstres(this.equipeMonstres);
        System.out.println("------------Creation des Héros----------");
        afficherEquipeHeros(this.equipeHeros);
        System.out.println("------------Création des Armes----------");
        creationArmes(20);
        afficherArmes();
        System.out.println("---------Création des boucliers----------");
        creationBouclier(20);
        System.out.println("-------Creation de la nourriture-------");
        creationNourriture(20);
        System.out.println(Couleur.ANSI_PURPLE+"-------Les Héros s'équipes------");
        equiperHeros(this.equipeHeros,this.listEpee,this.listBoucliers);
        rangerItemsHeros(this.equipeHeros,this.listNouriture,this.listEpee,this.listBoucliers,5);
        afficherArmesHeros(this.equipeHeros);
        System.out.println("-------Les Monstres s'équipes------");
        equiperMonstres(this.equipeMonstres,this.listGourdin,this.listBoucliers);
        rangerItemsMonstre(this.equipeMonstres,this.listNouriture,this.listGourdin,this.listBoucliers,5);
        afficherArmesMonstres(this.equipeMonstres);
        creationCombat(equipeMonstres,equipeHeros);


    }

    /**
     * Création d'une equipe de monstres en fonction du nombre de monstres que l'on veut dans l'equipe
     * @param nbrPersonnageEquipe
     */
    public void creationEquipeMonstres(int nbrPersonnageEquipe){
        EquipeFactory equipeFactory = new EquipeFactory();
        Equipe equipeMonstres = equipeFactory.creerEquipeMonstre(nbrPersonnageEquipe);
        this.equipeMonstres = equipeMonstres;

    }

    /**
     * Création d'une equipe de Héros en fonction du nombre de Héros que l'on veut dans l'équipe
     * @param nbrPersonnageEquipe
     */
    public void creationEquipeHeros(int nbrPersonnageEquipe){
        EquipeFactory equipeFactory = new EquipeFactory();
        Equipe equipeHero = equipeFactory.creerEquipeHero(nbrPersonnageEquipe);
        this.equipeHeros=equipeHero;
    }

    /**
     * Création d'une liste d'épée en fonction du nombre d'épée que l'on veut
     * @param nombreArmes Nombre d'épée
     */
    public void creationEpee(int nombreArmes){
        ArmesFactory epee = new ArmesFactory();
        epee.creationEpee(nombreArmes);
        this.listEpee = epee.getListEpee();
    }

    /**
     * Création d'une liste de Gourdins en fonction du nombre que l'on veut
     * @param nombreArmes Nombre de Gourdin
     */
    public void creationGourdin(int nombreArmes){
        ArmesFactory gourdin = new ArmesFactory();
        gourdin.creationGourdin(nombreArmes);
        this.listGourdin = gourdin.getListGourdin();
    }

    /**
     * Création d'une liste d'arme en fonction du nombre d'arme que l'on veut
     * On créer nbrArmes de épée
     * on créer nbrArmes de Gourdin
     * @param nombreArmes
     */
    public void creationArmes(int nombreArmes){
        creationEpee(nombreArmes);
        creationGourdin(nombreArmes);
    }

    /**
     * Afficher la liste des Armes
     * Liste des Epées
     * Liste des Gourdins
     */
    public void afficherArmes(){
        System.out.println(this.listGourdin);
        System.out.println(this.listEpee);
        System.out.println();
    }

    /**
     * Création d'un combats entre une Equipe de monstres et une Equipe de Héros
     * @param equipeMonstres
     * @param equipeHeros
     */
    public void creationCombat(Equipe equipeMonstres, Equipe equipeHeros){
        Combattre combat = new Combattre();
        combat.combatsEquipe(equipeHeros,equipeMonstres);
    }

    /**
     * Equiper une liste de Héros avec une épée et un bouclier
     * Le héro est obligé d'avoir une Epée
     * Le héro a 1 chance sur 3 d'avoir un bouclier équipé
     * @param equipeHeros
     * @param epee Liste d'épées
     * @param bouclier Liste de Boucliers
     */
    public void equiperHeros(Equipe equipeHeros, List<Epee> epee,List<Bouclier> bouclier){
        for (Personnage hero: equipeHeros.getMembreEquipe()) {
            Random random = new Random();
            int epeeAleatoire = random.nextInt(0,epee.size());
            int chanceAvoirBouclier = random.nextInt(0, 3);
            int typeBouclier = random.nextInt(0,bouclier.size());
            hero.setArme(epee.get(epeeAleatoire));
            epee.remove(epeeAleatoire);
            if (chanceAvoirBouclier == 0){
                hero.setBouclier(bouclier.get(typeBouclier));
                bouclier.remove(typeBouclier);
            }
        }
    }

    /**
     * Equiper une list de monstres de Gourdins et de boucliers
     *Le Monstre est équipé d'un Gourdin
     * Le Monstre a 1 chance sur 3 d'avoir un Bouclier
     * @param equipeMonstres
     * @param gourdin Liste de Gourdin
     * @param bouclier Liste de Bouclier
     */
    public void equiperMonstres(Equipe equipeMonstres, List<Gourdin> gourdin,List<Bouclier> bouclier){
        for (Personnage monstre: equipeMonstres.getMembreEquipe()) {
            Random random = new Random();
            int gourdinAleatoire = random.nextInt(0,gourdin.size());
            int chanceAvoirBouclier = random.nextInt(0, 3);
            int typeBouclier = random.nextInt(0,bouclier.size());
            monstre.setArme(gourdin.get(gourdinAleatoire));
            gourdin.remove(gourdinAleatoire);
            if (chanceAvoirBouclier == 0){
                monstre.setBouclier(bouclier.get(typeBouclier));
                bouclier.remove(typeBouclier);
            }
        }
    }

    /**
     * Permet d'afficher une equipe de Monstres
     * @param equipeMonstres
     */
    public void afficherEquipeMonstres(Equipe equipeMonstres){
        for (int i = 0; i < equipeMonstres.getMembreEquipe().size(); i++) {
            System.out.print("Nom : "+this.equipeMonstres.getMonstres(i).getNom()+" , ");
            System.out.print("PV : "+this.equipeMonstres.getMonstres(i).getPoint_de_vie()+" , ");
            System.out.println("Endurance: "+this.equipeMonstres.getMonstres(i).getEndurance());
        }
        System.out.println();
    }

    /**
     * Permet d'afficher une Equipe de héros
     * @param equipeHeros
     */
    public void afficherEquipeHeros(Equipe equipeHeros){
        for (int i = 0; i < equipeHeros.getMembreEquipe().size(); i++) {
            System.out.print("Nom : "+ this.equipeHeros.getHeros(i).getNom()+" , ");
            System.out.print("PV : "+ this.equipeHeros.getHeros(i).getPoint_de_vie()+" , ");
            System.out.println("Endurance: "+ this.equipeHeros.getHeros(i).getEndurance());
        }
        System.out.println();
    }

    /**
     * Permet d'afficher l'équipement de chaque héros d'une Equipe de héros
     * @param equipeHeros
     */
    public void afficherArmesHeros(Equipe equipeHeros){
        for (int i = 0; i < equipeHeros.getMembreEquipe().size(); i++) {
            System.out.print("Nom : "+ this.equipeHeros.getHeros(i).getNom()+" , ");
            System.out.print("Armes : "+ this.equipeHeros.getHeros(i).getArme()+" , ");
            System.out.print("Bouclier : "+this.equipeHeros.getHeros(i).getBouclier()+" , ");
            System.out.println("Sacoche : "+this.equipeHeros.getHeros(i).getSacoche());
        }
        System.out.println();
    }

    /**
     * Permet d'afficher l'equipement de Chaque Monstre d'une Equipe de monstres
     * @param equipeMonstres
     */
    public void afficherArmesMonstres(Equipe equipeMonstres){
        for (int i = 0; i < equipeMonstres.getMembreEquipe().size(); i++) {
            System.out.print("Nom : "+this.equipeMonstres.getMonstres(i).getNom()+" , ");
            System.out.print("Armes : "+this.equipeMonstres.getMonstres(i).getArme()+" , ");
            System.out.print("Bouclier : "+this.equipeMonstres.getMonstres(i).getBouclier()+" , ");
            System.out.println("Sacoche : "+this.equipeMonstres.getMonstres(i).getSacoche());
        }
        System.out.println(Couleur.ANSI_RESET);
    }

    /**
     * Permet de créer une list de Bouclier
     * @param nbrBouclier
     */
    public void creationBouclier(int nbrBouclier){
        BouclierFactory listBoucliers = new BouclierFactory();
        listBoucliers.creationBouclier(nbrBouclier);
        this.listBoucliers = listBoucliers.getListBoucliers();
        System.out.println(this.listBoucliers);
        System.out.println();
    }

    /**
     * Permet de créer une list de nouriture
     * @param nbrNouriture
     */
    public void creationNourriture(int nbrNouriture){
        NouritureFactory creationItems = new NouritureFactory();
        creationItems.creationNouriture(nbrNouriture);

        this.listNouriture = creationItems.getListNouriture();
        System.out.println(this.listNouriture);
        System.out.println(Couleur.ANSI_RESET);
    }

    /**
     * Permet de ranger les Items d'un Héro dans sa sacoche en fonction
     * @param equipeHeros
     * @param listNourriture Une liste d'aliments
     * @param listEpee Une liste d'épée
     * @param listBoulier une liste de boucliers
     * @param nbrItemsRanger Nombre d'items que l'on veut mettre à l'intérieur de la sacoche
     */
    public void rangerItemsHeros(Equipe equipeHeros, List<Aliments> listNourriture,List<Epee>listEpee,List<Bouclier>listBoulier, int nbrItemsRanger){
        Random random = new Random();
        for (int i = 0; i < nbrItemsRanger; i++) {
            for (Personnage hero : equipeHeros.getMembreEquipe()) {
                int aleatoire = random.nextInt(0, 20);
                if(aleatoire == 0){
                    Epee epee = listEpee.get(aleatoire);
                    hero.getSacoche().ajouterArmes(epee);
                }else if ( aleatoire < 3 && aleatoire > 0){
                    Bouclier bouclier = listBoulier.get(aleatoire);
                    hero.getSacoche().ajouterBouclier(bouclier);
                }else {
                    Aliments nourriture = listNourriture.get(aleatoire);
                    hero.getSacoche().ajouterAliment(nourriture);
                }
            }
        }
    }

    /**
     * Permet de ranger les Items d'un Monstre dans sa sacoche en fonction
     * @param equipeMonstres
     * @param listNourriture Liste de nouriture
     * @param listGourdin Liste de gourdin
     * @param listBoulier Liste de bouclier
     * @param nbrItemsRanger Nombre d'items à ranger dans la sacoche
     */
    public void rangerItemsMonstre(Equipe equipeMonstres, List<Aliments> listNourriture,List<Gourdin>listGourdin,List<Bouclier>listBoulier, int nbrItemsRanger){
        Random random = new Random();
        for (int i = 0; i < nbrItemsRanger; i++) {
            for (Personnage monstre : equipeMonstres.getMembreEquipe()) {
                int aleatoire = random.nextInt(0, 20);
                if(aleatoire == 0){
                    Gourdin gourdin = listGourdin.get(aleatoire);
                    monstre.getSacoche().ajouterArmes(gourdin);
                }else if ( aleatoire < 3 && aleatoire > 0){
                    Bouclier bouclier = listBoulier.get(aleatoire);
                    monstre.getSacoche().ajouterBouclier(bouclier);
                }else {
                    Aliments nourriture = listNourriture.get(aleatoire);
                    monstre.getSacoche().ajouterAliment(nourriture);
                }
            }
        }
    }
}
