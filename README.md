# ForRogue

Participants :

-NAPPEE Thomas
-LONGUEVILLE Edouard
-DEMONTI Pierre
-BOUVET Mathieu


Caractéristiques du projet :
Fait dans le projet :
-Univers de jeu généré aléatoirement
-Evolution du PJ au tour par tour
-PNJ ennemis (monstres) et neutre (vendeurs)
-stats et équipements pour le PJ et les PNJ
-Interaction avec l'environnement : combat, loot, ect...
-Sauvegarde de la partie
-Interface de création de personnage


Compilation et exécution :

Invite de commande à la racine du projet puis entrez gradle build pour compiler et ./ForRogue pour exécuter
Il est possible de préciser un fichier de sauvegarde : ./ForRogue [FILENAME]

Scénario de démonstration :

L'utilisateur selectionne son genre, la sauvegarde qu'il souhaite charger, la seed de la carte, le nom du joueur et
le skin du joueur puis il appuie sur le bouton create.
On se retrouve dans le hub du donjon où l'on peut choisir parmi 3 portes qui ouvrent chacune un donjon d'une difficulté
différente. Une fois dans le donjon le but est de tuer les monstres pour récupérer des gemmes et de récupérer de
l'équipement dans les coffres. On peut échanger les gemmes contre des potions dans le hub.
Lorsque le joueur souhaite arréter de jouer il entre la commande quit et on lui propose de sauvegarder.


Manuel de l'utilisateur :

Général :
-TAB pour se déplacer entre les différents menus
-ENTREE pour selectionner une option

En jeu dans l'invite de commande :
-FLECHE DU HAUT pour monter
-FLECHE DU BAS pour descendre
-FLECHE GAUCHE pour aller a gauche
-FLECHE DROITE pour aller a droite
-"quit" pour quitter le jeu

En jeu dans le menu équipement :
-ENTREE pour selectionner un equipement/potion
-FLECHE DU HAUT pour monter dans le menu
-FLECHE DU BAS pour descendre dans le menu


Manuel technique :

-Game generator est une classe qui ouvre le menu de départ et qui crée une Game Window avec un GameEngine., ainsi que
la map.
-La map est une matrice d'objet avec des items, des coffres, des donjons et une liste d'ennemis.
-La classe personnage contient deux autres classes, enemy et player qui les matérialise par un symbole et leur donne
un inventaire c'est à dire un vector (structure similaire à une liste) d'item. Le player a en plus des gems qui
représentent une monnaie d'échange chez un marchand vendant des potions.
-Les commandes sont gérées par la classe command Prompt et l'ensemble des caractères ascii correspondant à des skin
sont stockés dans GameConstant
-Les ennemis suivent l'agorithme a* qui leur permettent de se déplacer vers le personnage. Ils ont cependant une limite
de perception du joueur qui les empêches de suivre le joueur de trop loin.
-La classe Serialization Driver permet de sauvegarder le GameEngine (contenant toutes les données de jeu ) dans le
fichier "file.save", puis de le relire pour charger la partie.
-Il y a 3 types de donjons correspondant à des 3 niveaux de difficultés. Lorsque l'on choisit une difficulté la classe
donjon ouvre un dossier contenant une succession de fichier de niveau avec des objets et des ennemis plus ou moins rares.
L'ordre d'affichage dépend du numéro de génération de niveau à choisir au début(la seed).
-La GameWIndow utilise la bibliothèque charva et particulièrement les fonctions de JPanle pour afficher séparément
l'inventaire , le gestionnaire de commande et la Game View( le jeu ).
-La GameView est un parcours de la matrice pour afficher un point s'il n'y a rien ou le skin correspondant si il y a
un PJ,un PNJ, un mur ou un coffre.
-La GameView affiche également les stats du joueur , ses gems(argent du jeu), le nom du personnage et son genre ainsi
que son équipement sous la forme d'un string. Cette écriture est possible grace au curseur de la classe Toolkit
de charva.
-Les item: Classe avec des attributs (int) de vie, d'attaque, de défense et de vitesse . Chaque type d'item(Potion,
Arme, armure ), modifie des stats différentes(attaque pour les armes ...). La méthode use permet d'attacher au
personnage l'objet et de modifier en conséquence ses stats.
-Chaque fois que l'on déplace le personnage, avec la méthode movePlayer de la Classe map on vérifie ce qu'il y a sur
l'emplacement sur lequel le personnage se dirige. Sur une porte de donjon(on entre dedans ou on en sort en redéfinissant
une nouvelle matrice correspondant au fichier du niveau choisi), un ennemi (on vérifie alors la vitesse pour voir qui
attaque en premier, puis execute la méthode attack ).Si à la suite du combat cet ennemi a moins de 0 de vie alors  il
est effacé et on récupère des gems.
-La classe hub est la matrice de départ avec le marchand et les portes menants aux différents donjons.
