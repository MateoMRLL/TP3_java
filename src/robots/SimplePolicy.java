package robots; 

/**
 * La classe {@code SimplePolicy} représente une politique de déplacement pour un robot,
 * composée de plusieurs phases et comportements successifs.
 * Chaque phase est définie par un comportement et une durée d'exécution.
 * 
 * Elle permet de gérer un ensemble de comportements que le robot doit suivre durant
 * différentes phases de son action.
 * 
 * @author Matéo
 */

public class SimplePolicy extends AbstractPolicy {

    //implémente AbstractPolicy
    //PLusieurs phases et plusieurs comportements


    private Behavior BehaviorArray[]; //tableau des comp
    private int timeArray[];  //durée des phases
    private int phase_number = 0; //compteur


    /**
     * Constructeur pour initialiser la politique avec un nombre de phases.
     * 
     * @param size Le nombre de phases à gérer dans cette politique.
     */

    public SimplePolicy(int size) {
        BehaviorArray = new Behavior[size]; 
        timeArray = new int[size]; 
    }

    //functions

    /**
     * Ajoute une phase à la politique avec un comportement et une durée spécifiée.
     * 
     * @param behavior Le comportement à associer à cette phase.
     * @param iter_number La durée de la phase en nombre d'itérations.
     */

    public void add(Behavior behavior, int iter_number){
        BehaviorArray[phase_number] = behavior; 
        timeArray[phase_number] = iter_number; 
        phase_number++; 
    }

    /**
     * Récupère le comportement associé à une phase donnée.
     * 
     * @param p L'indice de la phase.
     * @return Le comportement associé à la phase spécifiée.
     */

    Behavior getBehavior(int p) {
        return BehaviorArray[p]; 
    }

    /**
     * Récupère la durée de la phase spécifiée.
     * 
     * @param p L'indice de la phase.
     * @return La durée de la phase en nombre d'itérations.
     */

    int getDuration(int p) {
        return timeArray[p]; 
    }
/**
     * Méthode principale pour tester la politique en ajoutant plusieurs phases.
     * Cette méthode crée une politique avec 3 phases avec des durées et comportements différents.
     * 
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String [] args){

        SimplePolicy policy=new SimplePolicy(3);    
        policy.add(new Behavior(),60); // phase 0 de durée 60 itérations
        policy.add(new LocalBest(),20); // phase 1 de durée 20 itérations
        policy.add(new Follow(),20); // phase 2 de durée 20 itérations

    }

     /**
     * Récupère le nombre total de phases définies dans la politique.
     * 
     * @return Le nombre de phases.
     */
    
    int getPhaseNumber() {
       return phase_number; 
    }
    
}
