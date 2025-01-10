package robots;

/**
 * La classe abstraite {@code AbstractPolicy} définit un contrat pour les différentes politiques
 * que les robots peuvent suivre. Une politique détermine les phases de comportements et la durée de chaque phase.
 * 
 * @author Matéo
 */


public abstract class AbstractPolicy {

      /**
     * Récupère le comportement associé à une phase donnée.
     * Chaque phase correspond à un comportement spécifique que les robots adopteront.
     * 
     * @param p Le numéro de la phase (index de la phase).
     * @return Le comportement à adopter pendant la phase spécifiée.
     */


    abstract Behavior getBehavior(int p); 

     /**
     * Récupère la durée d'une phase spécifiée.
     * La durée est le nombre d'itérations pendant lequel le comportement associé à cette phase
     * doit être exécuté.
     * 
     * @param p Le numéro de la phase (index de la phase).
     * @return La durée (en nombre d'itérations) de la phase spécifiée.
     */

    abstract int getDuration(int p); 


    /**
     * Récupère le nombre total de phases dans cette politique.
     * Cette méthode permet de connaître le nombre de comportements à suivre dans la mission.
     * 
     * @return Le nombre de phases dans cette politique.
     */
    
    abstract int getPhaseNumber(); 
}
