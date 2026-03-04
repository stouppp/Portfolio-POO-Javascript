# ⏱️ Ordonnancement de Tâches sur Machines Parallèles - Java

Ce projet est une application Java orientée objet permettant de simuler et d'optimiser l'allocation de tâches sur un atelier de machines parallèles. L'objectif principal est de minimiser le temps d'achèvement global (makespan) ainsi que les coûts de pénalité liés aux retards.



## 🚀 Fonctionnalités et Logique Métier

* **Modélisation d'Atelier :** Un `Workshop` est composé de plusieurs `Machine`s travaillant en parallèle.
* **Gestion des Tâches :** Chaque `Task` possède un temps de traitement, une date limite de livraison (deadline) et un coût de pénalité unitaire en cas de retard.
* **Moteur d'Évaluation :** Calcul automatique de la date de fin de chaque machine et du coût total des pénalités à chaque ajout de tâche.
* **Comparateur d'Algorithmes :** Le projet intègre une classe `SchedulingTester` permettant de lancer plusieurs stratégies d'ordonnancement sur un même jeu de données pour comparer leurs performances.

## 🏗️ Architecture et Design Pattern

Ce projet met en pratique des concepts avancés d'architecture logicielle, et plus particulièrement le **Design Pattern Strategy** :

* **L'Interface `Scheduling` :** Définit le contrat global pour tout algorithme d'ordonnancement. 
* **Les Stratégies Concrètes :** Implémentation de plusieurs heuristiques interchangeables sans modifier le cœur du programme :
  * `SchedulingIncreasingTime` : Tri les tâches de la plus courte à la plus longue (Shortest Processing Time).
  * `SchedulingDecreasingTime` : Tri les tâches de la plus longue à la plus courte (Longest Processing Time).
  * `SchedulingMisterSafety` : Algorithme alternatif d'allocation de sécurité.
* **Encapsulation et Tri :** Utilisation de l'interface `Comparable<Task>` pour définir l'ordre naturel des tâches, et copie profonde (Deep Copy) des listes pour ne pas altérer les données initiales entre les différents tests.

## 🛠️ Exécution et Tests

Le projet inclut un jeu d'instances de test pré-configurées. Pour lancer l'évaluation comparative des algorithmes :

1. Compiler le projet :
`javac -d bin src/workshop/*.java src/scheduling/*.java`

2. Lancer les tests comparatifs :
`java -cp bin scheduling.SchedulingTester`