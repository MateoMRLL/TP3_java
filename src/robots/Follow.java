package robots;

public class Follow extends Behavior {

  public void move(Robot robot) {

    Point position_actuelle = robot.get_posCourante();
    Point objectif = Robot.get_bestPositionGlobale();
    robot.set_posCourante(position_actuelle.move(objectif, 0.05));
    
  }
} 