# Projet de Java : Colonie de robots

## Description

Ce projet implémente des robots autonomes capables de se déplacer dans un environnement pour collecter une ressource à différentes positions. Les robots suivent une politique définie en plusieurs phases pour optimiser la collecte.

## Composants du projet

### Classes principales :
- **`BasicMission`** : Gère la mission avec les robots et leurs comportements.
- **`SmartMission`** : Étend `BasicMission` avec une politique d'actions définissant les phases.
- **`Robot`** : Représente un robot, gère sa position, teneur, et son comportement.
- **`Point`** : Représente une position dans un espace à 2 dimensions, avec des méthodes de calculs.
- **`Behavior`** : Classe de base pour définir le comportement des robots (mouvement).

### Interfaces et classes abstraites :
- **`AbstractPolicy`** : Interface pour définir une politique d'action.
- **`AbstractProblem`** : Interface pour définir des problèmes (ex : calcul de la teneur).
  - **`Eggholder`**, **`Sphere`** : Implémentations de problèmes avec des fonctions pour calculer la teneur.

### Comportements spécifiques :
- **`Follow`** : Suivre la meilleure position globale.
- **`LocalBest`** : Suivre la meilleure position locale.



