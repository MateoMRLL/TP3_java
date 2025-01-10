package robots;
public class Eggholder implements AbstractProblem {

    private double calcul_function(double a, double b) {
        double k = 1024;
        double x = k*(a-0.5);
        double y = k*(b-0.5);

        return -(y + 47) * Math.sin(Math.sqrt(Math.abs(x / 2 + (y + 47))))
                - x * Math.sin(Math.sqrt(Math.abs(x - (y + 47))));
    }

    public double teneur(Point p){
        double res;
        final double tmax = 959.64;
        final double tmin = -1049.13;
        res =  -calcul_function(p.getx(), p.gety());
        res = (res-tmin)*255/(tmax-tmin);
        return res;
    }
}



