    package robots;

/**
 * La classe {@code Eggholder} représente un problème basé sur la fonction mathématique "Eggholder". 
 * Elle permet de calculer une valeur associée à un point donné, appelée "teneur", 
 * qui est utilisée pour simuler un problème d'optimisation.
 * 
 * @author Matéo
 */


    public class Eggholder implements AbstractProblem {


     /**
     * Calcule la valeur de la fonction Eggholder pour deux coordonnées.
     * <p>
     * Cette fonction permet d'évaluer une valeur selon les coordonnées fournies.
     * </p>
     * 
     * @param a La première coordonnée (normalisée entre 0 et 1).
     * @param b La seconde coordonnée (normalisée entre 0 et 1).
     * @return La valeur calculée de la fonction Eggholder.
     */

        private double calcul_function(double a, double b) {
            double k = 1024;
            double x = k*(a-0.5);
            double y = k*(b-0.5);

            return -(y + 47) * Math.sin(Math.sqrt(Math.abs(x / 2 + (y + 47))))
                    - x * Math.sin(Math.sqrt(Math.abs(x - (y + 47))));
        }


          /**
     * Calcule la teneur pour un point donné en appliquant la fonction Eggholder.
     * <p>
     * Le résultat est normalisé entre 0 et 255.
     * </p>
     * 
     * @param p Le point pour lequel calculer la teneur.
     * @return La teneur normalisée pour le point {@code p}.
     */

        public double teneur(Point p){
            double res;
            final double tmax = 959.64;
            final double tmin = -1049.13;
            res =  -calcul_function(p.getx(), p.gety());
            res = (res-tmin)*255/(tmax-tmin);
            return res;
        }
    }



