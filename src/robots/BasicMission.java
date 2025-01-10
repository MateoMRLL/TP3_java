package robots;

import utilitaires.Printer;
/**
 * La classe {@code BasicMission} représente une simulation où des robots
 * exécutent une mission pour explorer et collecter des ressources. 
 * Les robots interagissent avec un problème défini (un gisement) 
 * et enregistrent leur progression au fil des itérations.
 * <p>
 * La classe initialise une colonie de robots, leur attribue des comportements, 
 * simule leur déplacement et collecte des données sur plusieurs itérations.
 * </p>
 * 
 * @author Matéo
 */

public class BasicMission {

    /** Tableau de robots participant à la mission. */

    protected Robot[] robots;

    /** Le problème ou site de ressources avec lequel les robots interagissent. */

    private AbstractProblem gisement;

    /** Utilitaire d'écriture pour enregistrer les données des robots dans un fichier. */

    protected Printer printer = new Printer("data/robots.txt");

    /**
     * Construit une instance de {@code BasicMission}.
     * Initialise un groupe de robots et les associe à un problème donné.
     * 
     * @param gisement    Le site de ressources ou problème à explorer.
     * @param robots_num  Le nombre de robots dans la mission.
     */


    public BasicMission(AbstractProblem gisement, int robots_num) {
        this.gisement = gisement;
        this.robots = new Robot[robots_num]; //colonie de robots
        init();

    }

    /**
     * Définit un robot à un index spécifique dans le tableau des robots.
     * 
     * @param index L'index où affecter le robot.
     * @param robot Le robot à affecter.
     * @throws ArrayIndexOutOfBoundsException si l'index est invalide.
     */

    
    public void set_robot(int index, Robot robot) {
        if (index >= 0 && index < robots.length) {
            robots[index] = robot;
        }
    }

     /**
     * Récupère le robot à un index spécifique dans le tableau des robots.
     * 
     * @param index L'index du robot à récupérer.
     * @return Le robot à l'index donné, ou {@code null} si l'index est invalide.
     */

    public Robot get_robot(int index) {
        if (index >= 0 && index < robots.length) {
            return robots[index];
        }
        return null;
    }


    /**
     * Initialise les robots avec des comportements et des positions de départ par défaut.
     * Chaque robot est placé au centre (0.5, 0.5) avec un comportement par défaut.
     */

    private void init() {
        Point center = new Point(0.5, 0.5);
        Behavior behavior = new Behavior();
        for (int i = 0; i < robots.length; i++) {
            robots[i] = new Robot(center);
            robots[i].setBehavior(behavior);
        }
    }

    /**
     * Simule une action de déplacement pour tous les robots de la mission.
     */

    protected void walk() {
        for (Robot robot : robots) {
            robot.walk();
        }
    }

    /**
     * Collecte les données des ressources pour tous les robots en fonction de leur position actuelle.
     * Met à jour la teneur actuelle de chaque robot selon les caractéristiques du problème.
     */

    protected void collect() {
        for (Robot robot : robots) {
            double Oregrade = gisement.teneur(robot.get_posCourante()); // Récupère la teneur pour la position actuelle
            robot.set_tenCourante(Oregrade);
            robot.set_Teneur(Oregrade);
        }
    }

    /**
     * Exécute la simulation de la mission pour un nombre fixe d'itérations.
     * À chaque itération, les robots collectent des ressources, enregistrent des données et se déplacent.
     * Les résultats sont enregistrés dans un fichier via l'utilitaire {@link Printer}.
     */

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

     /**
     * Stocke les positions actuelles de tous les robots de la mission.
     * Enregistre les positions dans le fichier spécifié par {@link Printer}.
     */

    protected void store() {
        printer.println("-1");
        for (Robot robot : robots) {
            Point pos = robot.get_posCourante();
            printer.println(pos.getx() + "\t" + pos.gety());
        }
    }

    /**
     * Méthode principale pour exécuter la mission.
     * Initialise un problème exemple, crée une mission et lance la simulation.
     * 
     * @param args Arguments de la ligne de commande (non utilisés).
     */

    public static void main(String[] args) {
        Sphere pb = new Sphere();
        int numberOfRobots = 100;
        BasicMission mission = new BasicMission(pb, numberOfRobots);
        mission.run();
        System.out.println("Meilleure teneur obtenue : " + Robot.get_bestTeneurGlobale());
    }

}
