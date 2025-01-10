package robots;
public abstract class AbstractPolicy {

    //classe abstraite
    //Méthodes que les sous classes doivent implémenter pour gérer comportement

    abstract Behavior getBehavior(int p); 
    abstract int getDuration(int p); 
    abstract int getPhaseNumber(); 
}
