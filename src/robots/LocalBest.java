package robots;

public class LocalBest extends Behavior{
  
	public void move(Robot robot) {
		Point curr_pos = robot.get_posCourante();
		
		Point objectif = robot.get_bestPositionLocale();
		Point new_pos = curr_pos.move(objectif, 0.05);
		
		robot.set_posCourante(new_pos);
	}
}
