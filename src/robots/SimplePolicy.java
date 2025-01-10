package robots; 
    
public class SimplePolicy extends AbstractPolicy {

    //implémente AbstractPolicy
    //PLusieurs phases et plusieurs comportements


    private Behavior BehaviorArray[]; //tableau des comp
    private int timeArray[];  //durée des phases
    private int phase_number = 0; //compteur


    public SimplePolicy(int size) {
        BehaviorArray = new Behavior[size]; 
        timeArray = new int[size]; 
    }

    //functions

    public void add(Behavior behavior, int iter_number){
        BehaviorArray[phase_number] = behavior; 
        timeArray[phase_number] = iter_number; 
        phase_number++; 
    }

    Behavior getBehavior(int p) {
        return BehaviorArray[p]; 
    }

    int getDuration(int p) {
        return timeArray[p]; 
    }

    public static void main(String [] args){

        SimplePolicy policy=new SimplePolicy(3);    
        policy.add(new Behavior(),60); // phase 0 de durée 60 itérations
        policy.add(new LocalBest(),20); // phase 1 de durée 20 itérations
        policy.add(new Follow(),20); // phase 2 de durée 20 itérations

    }

    int getPhaseNumber() {
       return phase_number; 
    }
    
}
