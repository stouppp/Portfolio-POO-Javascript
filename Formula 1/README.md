# 🏎️ Simulation d'Écurie Automobile - Java POO

Ce projet est une application développée en Java visant à démontrer la maîtrise des concepts fondamentaux de la Programmation Orientée Objet (POO). Il modélise la gestion complète d'une écurie automobile, allant du recrutement du personnel à la gestion de la flotte de véhicules.


## 🚀 Concepts POO Abordés

* **Héritage & Abstraction :** Création de classes mères abstraites (`Car`, `Person`) pour factoriser le code, étendues par des classes filles concrètes (`Formula1`, `Truck` pour les véhicules ; `Driver`, `Technician` pour le personnel).
* **Polymorphisme :** Implémentation de méthodes au comportement dynamique, comme `isCompatible()`, qui s'assure qu'un pilote de course (`Driver`) ne conduit qu'une `Formula1` et qu'un technicien ne conduit qu'un `Truck`.
* **Encapsulation :** Protection stricte de l'état interne des objets (données `private`) et utilisation de méthodes mutateurs/accesseurs (getters/setters) sécurisées.
* **Composition & Agrégation :** Modélisation de relations complexes : une `Team` gère des listes de `Person` et de `Car`, et chaque `Car` possède un composant `Engine`.

## 🏗️ Architecture du Projet

* **Gestion Centrale :**
  * `Team` : Classe gérant la logique métier (recrutement, achat de véhicules, assignation du personnel aux voitures).
* **Flotte de Véhicules (`Car`) :**
  * `Formula1` : Véhicules de course avec gestion des sponsors.
  * `Truck` : Camions logistiques définis par leur tonnage.
  * `Engine` : Caractéristiques motrices (carburant, puissance).
* **Personnel (`Person`) :**
  * `Driver` : Pilotes avec suivi des palmarès et abandons.
  * `Technician` : Membres du staff technique avec leurs spécialités.

## 🛠️ Test et Exécution

La logique de l'application et les différents scénarios de test (recrutement, achat, assignation avec vérification de compatibilité) sont exécutables via les méthodes `main` intégrées dans les classes principales, notamment `Team.java`.