package robots;

/**
 * La classe {@code Behavior} représente le comportement d'un robot.
 * Elle définit les règles de déplacement du robot en fonction de sa position actuelle
 * et d'un point calculé selon un modèle prédéfini.
 * <p>
 * Cette classe peut être utilisée pour implémenter différents comportements 
 * et logiques de déplacement dans une simulation.
 * </p>
 * 
 * @author Matéo
 */

public class Behavior {


      /**
     * Déplace un robot en calculant une nouvelle position basée sur sa position actuelle 
     * et un point intermédiaire déterminé par une logique prédéfinie.
     * <p>
     * La nouvelle position est déterminée par :
     * <ul>
     * <li>Un point de départ fixe ({@code pointM} = (0.5, 0.5)).</li>
     * <li>Un point cible temporaire ({@code pointA}) utilisé pour définir la direction.</li>
     * <li>Une translation proportionnelle ({@code 0.05}) appliquée pour limiter l'amplitude du déplacement.</li>
     * </ul>
     * La position actuelle du robot est mise à jour après le calcul.
     * </p>
     * 
     * @param robot Le robot dont la position doit être mise à jour.
     */


    public void move(Robot robot) {

        Point pointA = new Point();
        Point pointM = new Point(0.5, 0.5);
        
        Point posCourante = robot.get_posCourante();
        Point pointPprime = new Point( // P' = P + MA
            posCourante.getx() + (pointA.getx() - pointM.getx()), //P'x
            posCourante.gety() + (pointA.gety() - pointM.gety()) //P'y
        );

        Point pos_nouvelle = posCourante.move(pointPprime, 0.05);
        robot.set_posCourante(pos_nouvelle);  //ne pas oublier de set la nouvelle position à la position courante
    }
}
