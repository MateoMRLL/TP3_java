package robots;

/**
 * La classe {@code Robot} représente un robot avec une position et une teneur associée.
 * Elle permet de gérer les déplacements du robot, de suivre la meilleure position locale et globale,
 * ainsi que de mettre à jour la teneur du robot.
 * <p>
 * Chaque robot peut être associé à un comportement spécifique pour déterminer son déplacement.
 * </p>
 * 
 * @author Matéo
 */

public class Robot {

    private Point posCourante; // position courante
    private double tenCourante; // teneur courante

    private Point bestPositionLocale; // dernière position locale (max teneur)
    private double bestTeneurLocale; // meilleure teneur capturée

    private static Point bestPositionGlobale = new Point(0, 0);; // meilleure position globale
    private static double bestTeneurGlobale = -1.0 ; // meilleure teneur globale
        
    private Behavior behavior = null;


    /**
     * Constructeur pour initialiser un robot avec une position donnée.
     * 
     * @param P La position initiale du robot.
     */


    public Robot(Point P) {
        this.posCourante = P; 
        this.bestPositionLocale = P; 
        this.bestTeneurLocale = 0.0; 
        this.tenCourante = 0.0; 

    }


     /**
     * Déplace le robot selon son comportement actuel.
     * Si un comportement est défini, il appelle la méthode {@code move} du comportement.
     */

    public void walk() {
        if (behavior != null)
            behavior.move(this);
    }


    /**
     * Définit le comportement du robot.
     * 
     * @param newbehavior Le comportement à associer au robot.
     */


    public void setBehavior(Behavior newbehavior) {
        this.behavior = newbehavior;
    }

    //getters


    /**
     * Récupère la position actuelle du robot.
     * 
     * @return La position actuelle du robot.
     */

    public Point get_posCourante() {
        return posCourante;
    }

    /**
     * Récupère la meilleure position locale du robot (avec la teneur maximale locale).
     * 
     * @return La meilleure position locale.
     */

    public Point get_bestPositionLocale() {
        return bestPositionLocale;
    }

    /**
     * Récupère la meilleure teneur globale connue parmi tous les robots.
     * 
     * @return La meilleure teneur globale.
     */

    public static double get_bestTeneurGlobale() { 
        return bestTeneurGlobale;
    }

    /**
     * Récupère la meilleure position globale parmi tous les robots.
     * 
     * @return La meilleure position globale.
     */

    public static Point get_bestPositionGlobale() {
        return bestPositionGlobale;
    }

    // setters


    /**
     * Définit la position actuelle du robot.
     * 
     * @param posCourante La nouvelle position du robot.
     */

    public void set_posCourante(Point posCourante) {
        this.posCourante = posCourante;
    }

     /**
     * Définit la teneur actuelle du robot.
     * 
     * @param tenCourante La nouvelle teneur du robot.
     */

    public void set_tenCourante(double tenCourante) { 
        this.tenCourante = tenCourante;
    }

    // functions


     /**
     * Met à jour la teneur et les positions locales et globales si nécessaire.
     * Si la teneur actuelle dépasse la meilleure teneur locale, elle est mise à jour.
     * Si la teneur dépasse la meilleure teneur globale, la teneur et la position globale sont mises à jour.
     * 
     * @param teneurActuelle La teneur actuelle du robot à enregistrer.
     */


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

    /**
     * Méthode de test pour vérifier le fonctionnement du robot et de ses déplacements.
     * Elle crée un robot, lui assigne un comportement, et fait avancer le robot pendant 100 itérations.
     * 
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */
    
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
