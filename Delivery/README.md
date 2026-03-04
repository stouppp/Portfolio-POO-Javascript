# 🚚 Optimisation de Tournées (Vehicle Routing Problem) - Java

Ce projet est une implémentation algorithmique en Java visant à résoudre une version simplifiée du problème de tournées de véhicules (VRP). L'objectif est de planifier des itinéraires de livraison optimisés pour une flotte de camions sous contrainte de capacité.

## 🚀 Fonctionnalités et Logique Métier

* **Modélisation du réseau :** Création d'un graphe spatial où chaque `Point` possède des coordonnées (x, y). Le réseau est composé d'un `Depot` (point de départ) et de multiples `Client` avec une demande spécifique (nombre de colis).
* **Calcul des distances :** Initialisation des routes avec calcul automatique des distances euclidiennes entre tous les points du réseau.
* **Algorithme de planification :** Implémentation d'une heuristique gloutonne (`basicPlanning`) qui remplit les véhicules (`Tour`) un par un en respectant leur capacité maximale.
* **Gestion des données :** Sauvegarde des résultats d'optimisation (nombre de tournées, distance totale, colis livrés) dans des fichiers textes, et lecture d'instances de test (File I/O).

## 🏗️ Concepts Techniques Abordés

* **Collections Java Avancées :** Utilisation intensive de `HashMap` (pour lier les destinations à leurs distances), `HashSet` (pour garantir l'unicité des clients/tours) et `LinkedList` (pour maintenir la séquence des livraisons).
* **Programmation Orientée Objet :** * Abstraction et Héritage (`Point` étendu par `Client` et `Depot`).
  * Surcharge des méthodes `equals()` et `hashCode()` pour la comparaison d'objets dans les Collections.
* **Gestion des Erreurs :** Création et levée d'une exception personnalisée (`ExceptionQuantity`) pour empêcher la création de clients avec des demandes négatives ou nulles.
* **Flux de Fichiers (I/O) :** Utilisation de `PrintWriter`, `FileReader` et `BufferedReader` pour l'écriture et la lecture d'instances.

## 🛠️ Exécution

Le projet contient un jeu de données de test intégré. Pour lancer la simulation et générer le fichier de planification (`test.txt`) :

1. Compiler le projet :
`javac -d bin src/exceptions/*.java src/network/*.java src/planning/*.java src/routing/*.java`

2. Exécuter la classe principale :
`java -cp bin routing.Routing`