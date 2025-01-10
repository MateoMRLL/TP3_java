package robots;

public class Sphere implements AbstractProblem {


    public double calcul_T(double a, double b) {
        return 1 - (a * a + b * b) / 2;
    }

    public double teneur(Point p) {
        double res; 
        final double tmax = 1.0;
        final double tmin = 0;
        res =  calcul_T(p.getx(), p.gety());
        res = (res-tmin)*255/(tmax-tmin);
        return res; 
    }

}
