package robots;
/**
 * La classe {@code LocalBest} représente un comportement où le robot 
 * se déplace vers sa meilleure position locale connue.
 * <p>
 * Ce comportement hérite de la classe {@link Behavior}.
 * </p>
 * 
 * @author Matéo
 */

public class LocalBest extends Behavior{

	  /**
     * Déplace le robot vers sa meilleure position locale. 
     * @param robot Le robot dont la position doit être mise à jour.
     */
  
	public void move(Robot robot) {
		Point curr_pos = robot.get_posCourante();
		
		Point objectif = robot.get_bestPositionLocale();
		Point new_pos = curr_pos.move(objectif, 0.05);
		
		robot.set_posCourante(new_pos);
	}
}
