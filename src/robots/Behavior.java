package robots;

public class Behavior {

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
