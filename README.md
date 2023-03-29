# WorldOfJava

Bienvenue dans le README de l'exercice World of Java !

Ce projet est un jeu qui permet de jouer avec deux équipes : l'équipe des héros et l'équipe des monstres. 

Les héros possèdent des épées, une probabilité d'avoir un bouclier équipé, des points de vie, de l'endurance et une sacoche qui contient de la nourriture et une probabilité d'avoir des boucliers et d'autres épées.
Les monstres possèdent des gourdins, une probabilité d'avoir un bouclier équipé, une sacoche qui contient de la nourriture et une probabilité d'avoir des boucliers et des gourdins.

Les deux équipes peuvent s'affronter en faisant des combats à mort entre les héros et les monstres de chaque équipe. 
Le but du jeu est de vaincre l'équipe adverse en éliminant tous ses membres. 
Le jeu se termine lorsque l'une des équipes n'a plus aucun membre vivant.

Le jeu a été réalisé en Java en utilisant des classes et des méthodes pour gérer les différents éléments du jeu, tels que les personnages, les armes, les sacoches et les combats. 
Le jeu peut être joué en modifiant la classe "Woj.Main".

Pour exécuter le jeu, vous devez exécuter la classe principale "Woj.Main" qui se trouve dans le dossier "src".

## Code couleur 
* Cyan: Génération du monde 
* Violet: Les Personnages s'équipes 
* Gris : Les rounds 
* Rouge: Les Personnages qui attaques 
* Bleu: Les Personnages qui défendes 
* Jaune: L'équipe Gagnante 

## Changer le nombre de Personnages par équipes

Vous pouvez changer le nombres de Personnages par équipes en vous rendant dans la class "Woj.Main" puis changer initialiserMonde(nbrDePersonnagesParEquipe) en remplaçant entre les parenthèses par le nombre de Personnages dans chaque équipe que vous voulez.

## Ajout d'object lors de la création du monde

Vous pouvez modifier le nombre d'arme , de nourriture , et de bouclier qui vont être créer lors de la création du monde. 

* Rendez vous dans la class "Woj.Monde"
* Aller dans la Fonction initialisation du monde 
* Modifiez les paramètre de fonction creationArmes(nbrArmes),creationBouclier(nbrBouclier),creationNourriture(nbrNourriture)

## Modifer les degats des armes 

Vous pouvez modifier les degats des Armes en vous rendant dans le package Factory et dans Armes factory.
            
        
