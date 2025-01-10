package robots;

/**
 * La classe {@code Sphere} implémente l'interface {@code AbstractProblem} et représente
 * un problème spécifique dont les robots doivent résoudre. Ce problème consiste à
 * évaluer la teneur à une position donnée sur une sphère, selon une
 * fonction de calcul spécifique.
 * 
 * Cette classe utilise une fonction de calcul spécifique pour obtenir la teneur en
 * fonction des coordonnées (x, y) d'un point donné dans un espace à deux dimensions.
 * 
 * @author Matéo
 */

public class Sphere implements AbstractProblem {

/**
     * Fonction de calcul de la teneur basée sur une formule spécifique.
     * Cette fonction représente un problème où la teneur dépend de la distance
     * par rapport au centre d'une sphère dans un espace bidimensionnel.
     * 
     * @param a La coordonnée x d'un point.
     * @param b La coordonnée y d'un point.
     * @return La valeur de la fonction de teneur pour les coordonnées (a, b).
     */

    public double calcul_T(double a, double b) {
        return 1 - (a * a + b * b) / 2;
    }

     /**
     * Calcule la teneur à une position donnée (x, y) dans l'espace.
     * Cette méthode utilise la fonction {@code calcul_T} pour obtenir une valeur
     * qui est ensuite normalisée dans un intervalle entre 0 et 255.
     * 
     * @param p Le point (x, y) où la teneur doit être calculée.
     * @return La teneur normalisée à la position donnée.
     */
    
    public double teneur(Point p) {
        double res; 
        final double tmax = 1.0;
        final double tmin = 0;
        res =  calcul_T(p.getx(), p.gety());
        res = (res-tmin)*255/(tmax-tmin);
        return res; 
    }

}
