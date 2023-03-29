package Woj.factory;

import Woj.objets.Epee;
import Woj.objets.Gourdin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArmesFactory {

    private List<Gourdin> listGourdin;
    private List<Epee> listEpee;

    public void creationArme(int nbrArmes){
        creationEpee(nbrArmes);
        creationGourdin(nbrArmes);
    }

    /**
     * Permet de creer une liste d'épee
     * @param nbrEpee Nombre d'épée a creer
     */
    public void creationEpee(int nbrEpee) {
        List<Epee> epee = new ArrayList<>();
        for (int i = 0; i < nbrEpee; i++) {
            Random random = new Random();
            int epeeAleatoire = random.nextInt(0, 20);
            if (epeeAleatoire < 2) {
                Epee epeeDiamant = new Epee("Epée en diamant", 20, 75, 1450);
                epee.add(epeeDiamant);
            } else if (epeeAleatoire > 2 && epeeAleatoire <= 5) {
                Epee epeeOr = new Epee("Epée en or ", 15, 70, 1100);
                epee.add(epeeOr);
            } else {
                Epee epeeBois = new Epee("Epée en bois ", 10, 65, 900);
                epee.add(epeeBois);
            }
        }
        this.listEpee = epee;
    }

    /**
     * Creation d'une liste de gourdin
     * @param nbrGourdin nombre de gourdin à créer
     */
    public void creationGourdin(int nbrGourdin) {
        List<Gourdin> gourdin = new ArrayList<>();
        for (int i = 0; i < nbrGourdin; i++) {
            Random random = new Random();
            int gourdinAleatoire = random.nextInt(0, 20);
            if (gourdinAleatoire < 2) {
                Gourdin gourdinElectrique = new Gourdin("Gourdin Electrique", 20, 70, 1450);
                gourdin.add(gourdinElectrique);
            } else if (gourdinAleatoire > 2 && gourdinAleatoire <= 5) {
                Gourdin gourdinOr = new Gourdin("Gourdin en Or", 15, 65, 1100);
                gourdin.add(gourdinOr);
            } else {
                Gourdin gourdinBois = new Gourdin("Gourdin en bois", 10, 60, 900);
                gourdin.add(gourdinBois);
            }
        }
        this.listGourdin = gourdin;
    }

    public List<Gourdin> getListGourdin() {
        return listGourdin;
    }

    public List<Epee> getListEpee() {
        return listEpee;
    }

    @Override
    public String toString() {
        return "----------Creation des armes-------" +"\n"+
                "----------gourdin---------" + "\n"+ listGourdin +
                "\n"+
                "----------Epée---------" +"\n"+ listEpee +"\n";
    }
}
