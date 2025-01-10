package robots;

/**
 * La classe {@code Follow} représente un comportement où le robot 
 * se déplace vers la meilleure position globale trouvée par l'ensemble des robots.
 * <p>
 * Ce comportement hérite de la classe {@link Behavior}.
 * </p>
 * 
 * @author Matéo

 */


public class Follow extends Behavior {

   /**
     * Déplace le robot vers la meilleure position globale connue. 
     * @param robot Le robot dont la position doit être mise à jour.
     */

  public void move(Robot robot) {

    Point position_actuelle = robot.get_posCourante();
    Point objectif = Robot.get_bestPositionGlobale();
    robot.set_posCourante(position_actuelle.move(objectif, 0.05));
    
  }
} 