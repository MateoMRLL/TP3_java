package robots;
import java.util.Random;


/**
 * La classe {@code Point} représente un point dans un plan à deux dimensions
 * avec des coordonnées {@code x} et {@code y}.
 * Elle fournit des méthodes pour manipuler des points, notamment pour calculer 
 * la distance entre deux points et déplacer un point vers un autre.
 * 
 * @author Matéo
 */


public class Point {

    private double x;
    private double y;

    // Constructors
    private static Random random = new Random();

      /**
     * Crée un point avec des coordonnées aléatoires dans l'intervalle [0, 1].
     */

    public Point() {
        
        this.x = random.nextDouble();
        this.y = random.nextDouble();

    }

    /**
     * Crée un point avec des coordonnées spécifiées.
     * 
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     */

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // getters


        /**
     * Récupère la coordonnée x du point.
     * 
     * @return La coordonnée x du point.
     */

    public double getx() {
        return x;
    }

    /**
     * Récupère la coordonnée y du point.
     * 
     * @return La coordonnée y du point.
     */


    public double gety() {
        return y;
    }


    //functions


    /**
     * Calcule la distance entre ce point et un autre point donné.
     * 
     * @param p Le point auquel calculer la distance.
     * @return La distance entre ce point et le point {@code p}.
     */


    public double distance(Point p) {
        //calcule la distance
        return Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
    }

    /**
     * Déplace ce point vers un autre point cible, en ne parcourant qu'une distance maximale donnée.
     * Si la distance entre les deux points est inférieure ou égale à cette distance maximale,
     * le point cible est directement atteint. Sinon, un nouveau point est calculé en fonction de la
     * distance maximale autorisée.
     * <p>
     * Le résultat est limité aux coordonnées dans l'intervalle [0, 1].
     * </p>
     * 
     * @param cible Le point vers lequel se déplacer.
     * @param d La distance maximale à parcourir.
     * @return Le nouveau point après déplacement.
     */

    public Point move(Point cible, double d) {

        double dist_cible = this.distance(cible);
        if (dist_cible <= d) {
            return new Point(cible.x, cible.y);
        } else {

            double ratio = d / dist_cible;

            double newX = this.x + (cible.x - this.x) * ratio;
            double newY = this.y + (cible.y - this.y) * ratio;

            newX = Math.max(0, Math.min(1, newX));
            newY = Math.max(0, Math.min(1, newY));

            return new Point(newX, newY);
        }
    }

     /**
     * Méthode de test pour vérifier les fonctionnalités de la classe {@code Point}.
     * Elle crée deux points et affiche leurs positions ainsi que la distance entre eux.
     * 
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */

    public static void main(String[] args) {
        Point test = new Point(0, 0);
        Point test2 = new Point(2, 2);
        System.out.println("(" + test.getx() + "," + test.gety() + ")");
        Point test3 = test.move(test2, 1);
        double dist = test.distance(test2);
        System.out.println(dist);
        System.out.println("(" + test3.getx() + "," + test3.gety() + ")");
    }
}