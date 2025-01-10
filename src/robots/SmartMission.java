package robots;

import utilitaires.Printer;


/**
 * La classe {@code SmartMission} hérite de {@code BasicMission} et permet d'exécuter
 * une mission où les robots suivent une politique de comportement définie par une série de phases.
 * Chaque phase correspond à un comportement différent appliqué pendant un nombre d'itérations donné.
 * 
 * Cette classe permet aux robots de suivre une séquence dynamique de comportements
 * définis dans une politique, et d'évaluer la meilleure teneur obtenue au cours de la mission.
 * 
 * @author Matéo
 */


public class SmartMission extends BasicMission {

    private AbstractPolicy policy; 

    /**
     * Constructeur pour initialiser une mission avec une politique et un nombre de robots spécifiés.
     * 
     * @param pb Le problème abstrait (ex. : modèle de gisement) à résoudre.
     * @param policy La politique définissant les comportements des robots pendant la mission.
     * @param robots_num Le nombre de robots participant à la mission.
     */
    
    public SmartMission(AbstractProblem pb, AbstractPolicy policy, int robots_num) {
        super(pb, robots_num); // Initialisation de la classe parente
        this.policy = policy;
        Point center = new Point(0.5, 0.5); // Point central pour les robots
        this.robots = new Robot[robots_num];
        for (int i = 0; i < robots_num; i++) {
            robots[i] = new Robot(center);
        }
    }

    /**
     * Exécute la mission en suivant les différentes phases définies par la politique.
     * 
     * Pour chaque phase, tous les robots adoptent le comportement associé à la phase
     * et l'exécutent pendant le nombre d'itérations spécifié.
     * 
     * À chaque itération, les robots collectent les informations, les stockent et
     * se déplacent selon leur comportement.
     */

    public void run() {
        // Affecte le comportement de chaque robot pour chaque phase
            for (int phase = 0; phase < this.policy.getPhaseNumber(); phase++) {
                for (int i = 0; i < robots.length; i++) {
                    robots[i].setBehavior(policy.getBehavior(phase));
                }
                for (int iter = 0; iter < policy.getDuration(phase); iter++) {
                    collect();  
                    store();
                    walk();
                }
            }
            printer.close();
        }
        
    /**
     * Méthode principale pour tester la mission avec une politique spécifique.
     * Elle crée une mission avec un problème, une politique et un ensemble de robots,
     * puis exécute la mission en appelant {@code run()}.
     * 
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */

    public static void main(String[] args) {

         // Création d'une politique simple avec 4 phases

        SimplePolicy SimplePolicy = new SimplePolicy(4);
        AbstractProblem pb = new Eggholder();

        // Définition des phases et des comportements associés
        SimplePolicy.add(new Behavior(), 50);
        SimplePolicy.add(new LocalBest(), 30);
        SimplePolicy.add(new Behavior(), 40);
        SimplePolicy.add(new Follow(), 30);

    // Création et exécution de la mission avec 30 robots
        SmartMission SmartMission = new SmartMission(pb, SimplePolicy, 30);
        SmartMission.run();
        System.out.println("Meilleure teneur obtenue : " + Robot.get_bestTeneurGlobale());

    }
}
