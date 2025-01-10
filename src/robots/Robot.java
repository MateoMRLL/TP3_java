package robots;

public class Robot {

    private Point posCourante; // position courante
    private double tenCourante; // teneur courante

    private Point bestPositionLocale; // dernière position locale (max teneur)
    private double bestTeneurLocale; // meilleure teneur capturée

    private static Point bestPositionGlobale = new Point(0, 0);; // meilleure position globale
    private static double bestTeneurGlobale = -1.0 ; // meilleure teneur globale
        
    private Behavior behavior = null;

    public Robot(Point P) {
        this.posCourante = P; 
        this.bestPositionLocale = P; 
        this.bestTeneurLocale = 0.0; 
        this.tenCourante = 0.0; 

    }

    public void walk() {
        if (behavior != null)
            behavior.move(this);
    }

    public void setBehavior(Behavior newbehavior) {
        this.behavior = newbehavior;
    }

    //getters

    public Point get_posCourante() {
        return posCourante;
    }

    public Point get_bestPositionLocale() {
        return bestPositionLocale;
    }

    public static double get_bestTeneurGlobale() { 
        return bestTeneurGlobale;
    }

    public static Point get_bestPositionGlobale() {
        return bestPositionGlobale;
    }

    // setters

    public void set_posCourante(Point posCourante) {
        this.posCourante = posCourante;
    }

    public void set_tenCourante(double tenCourante) { 
        this.tenCourante = tenCourante;
    }

    // functions

    public void set_Teneur(double teneurActuelle) {

        //set la meilleure teneur

        this.tenCourante = teneurActuelle; 
        
        if (this.tenCourante > this.bestTeneurLocale) {
            this.bestTeneurLocale = this.tenCourante;
            this.bestPositionLocale = this.posCourante;
        }

        if (this.tenCourante > bestTeneurGlobale) {
            bestTeneurGlobale = this.tenCourante;
            bestPositionGlobale = this.posCourante;
        }
    }

    public static void main(String[] args) {
        // Créer un robot avec une position initiale 
        Point initialPosition = new Point(0.5, 0.5);
        Robot robot = new Robot(initialPosition);
        Behavior behavior = new Behavior();
        robot.setBehavior(behavior);

        for (int i = 0; i < 100; i++) {
            robot.walk();
            System.out.println("Iteration " + i + ": Position actuelle -> (" + robot.get_posCourante().getx() + ", " + robot.get_posCourante().gety() + ")");
        }
    }
}
