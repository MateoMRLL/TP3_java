package robots;

import utilitaires.Printer;

public class SmartMission extends BasicMission {

    private AbstractPolicy policy; 
    
    public SmartMission(AbstractProblem pb, AbstractPolicy policy, int robots_num) {
        super(pb, robots_num); // Initialisation de la classe parente
        this.policy = policy;
        Point center = new Point(0.5, 0.5); // Point central pour les robots
        this.robots = new Robot[robots_num];
        for (int i = 0; i < robots_num; i++) {
            robots[i] = new Robot(center);
        }
    }

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
        
    public static void main(String[] args) {


        SimplePolicy SimplePolicy = new SimplePolicy(4);
        AbstractProblem pb = new Eggholder();

        SimplePolicy.add(new Behavior(), 50);
        SimplePolicy.add(new LocalBest(), 30);
        SimplePolicy.add(new Behavior(), 40);
        SimplePolicy.add(new Follow(), 30);


        SmartMission SmartMission = new SmartMission(pb, SimplePolicy, 30);
        SmartMission.run();
        System.out.println("Meilleure teneur obtenue : " + Robot.get_bestTeneurGlobale());

    }
}
