package robots;
import java.util.Random;

public class Point {

    private double x;
    private double y;

    // Constructors
    private static Random random = new Random();

    public Point() {
        
        this.x = random.nextDouble();
        this.y = random.nextDouble();

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // getters

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }


    //functions

    public double distance(Point p) {
        //calcule la distance
        return Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
    }

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