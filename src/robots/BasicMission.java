package robots;

import utilitaires.Printer;

public class BasicMission {
    protected Robot[] robots;
    private AbstractProblem gisement;
    protected Printer printer = new Printer("data/robots.txt");


    public BasicMission(AbstractProblem gisement, int robots_num) {
        this.gisement = gisement;
        this.robots = new Robot[robots_num]; //colonie de robots
        init();

    }

    public void set_robot(int index, Robot robot) {
        if (index >= 0 && index < robots.length) {
            robots[index] = robot;
        }
    }

    public Robot get_robot(int index) {
        if (index >= 0 && index < robots.length) {
            return robots[index];
        }
        return null;
    }

    private void init() {
        Point center = new Point(0.5, 0.5);
        Behavior behavior = new Behavior();
        for (int i = 0; i < robots.length; i++) {
            robots[i] = new Robot(center);
            robots[i].setBehavior(behavior);
        }
    }

    //protected !

    protected void walk() {
        for (Robot robot : robots) {
            robot.walk();
        }
    }

    protected void collect() {
        for (Robot robot : robots) {
            double Oregrade = gisement.teneur(robot.get_posCourante()); // Récupère la teneur pour la position actuelle
            robot.set_tenCourante(Oregrade);
            robot.set_Teneur(Oregrade);
        }
    }

    protected void run() {
        printer = new Printer("data/robots.txt"); 
        for (int iter = 0; iter < 100; iter++) {
            collect();
            System.out.println("iter=" + iter + " " + Robot.get_bestTeneurGlobale());
            store();
            walk(); 
        }
        printer.close();
    }

    protected void store() {
        printer.println("-1");
        for (Robot robot : robots) {
            Point pos = robot.get_posCourante();
            printer.println(pos.getx() + "\t" + pos.gety());
        }
    }

    public static void main(String[] args) {
        Sphere pb = new Sphere();
        int numberOfRobots = 100;
        BasicMission mission = new BasicMission(pb, numberOfRobots);
        mission.run();
        System.out.println("Meilleure teneur obtenue : " + Robot.get_bestTeneurGlobale());
    }

}
