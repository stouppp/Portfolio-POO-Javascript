# 🎨 Mini-Paint : Application de Dessin Vectoriel - Java Swing

Ce projet est une application de dessin interactive développée en Java. Il met en pratique la création d'Interfaces Homme-Machine (IHM) avec les bibliothèques **Swing** et **AWT**, ainsi que l'utilisation de l'architecture MVC (Modèle-Vue-Contrôleur) et la gestion événementielle.

## 🚀 Fonctionnalités

* **Dessin interactif :** Tracé de formes géométriques variées (lignes, cercles, etc.).
* **Personnalisation :** Sélection dynamique de la couleur et du type de forme via des menus déroulants (implémentation avec des `Enum`).
* **Outils d'édition :** * Fonctionnalité `Undo` pour annuler la dernière action.
  * Fonctionnalité `Clear` pour effacer toute la zone de dessin.
  * Outil Gomme (`Eraser`) pour corriger des tracés.

## 🏗️ Architecture Technique et Concepts POO

Ce projet sépare proprement la logique métier de l'interface graphique :

* **Package `model` (Logique & Géométrie) :**
  * Modélisation mathématique via la classe `Point`.
  * Hiérarchie de classes de dessin : Une classe abstraite `Shape` étendue par des classes concrètes comme `Line` et `Circle`.
  * Utilisation d'énumérations (`EnumColour`, `EnumShape`) pour sécuriser les choix de l'utilisateur.
* **Package `viewcontrol` (IHM & Événements) :**
  * Création de la fenêtre principale avec `JFrame` (`Window`).
  * Découpage de l'interface en panneaux interactifs (`TopBar`, `BottomBar`, zone de dessin `GraphicalArea`).
  * **Gestion événementielle :** Utilisation intensive du design pattern *Observer* via les `ActionListener` pour capturer les clics sur les boutons/menus, et `WindowListener` pour le cycle de vie de l'application.

## 🛠️ Compilation et Exécution

L'application peut être lancée en exécutant la classe principale gérant la fenêtre graphique :

1. Compiler le projet :
`javac -d bin src/model/*.java src/viewcontrol/*.java Main.java`

2. Exécuter l'application :
`java -cp bin viewcontrol.Window`