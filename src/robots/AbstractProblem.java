package robots;

/**
 * L'interface {@code AbstractProblem} définit un contrat pour les problèmes que les robots
 * peuvent résoudre. Chaque problème fournit une méthode pour évaluer la teneur 
 * à une position donnée dans un espace.
 * 
 * Les classes qui implémentent cette interface doivent fournir une méthode pour calculer
 * la teneur à une position donnée.
 * @author Matéo
 */

public interface AbstractProblem {

     /**
     * Calcule la teneur à une position donnée dans l'espace.
     * @param position Le point (x, y) où la teneur doit être calculée.
     * @return La teneur  à la position donnée.
     */

    double teneur(Point position); 
    
}
