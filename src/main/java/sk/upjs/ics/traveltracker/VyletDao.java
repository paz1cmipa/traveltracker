
package sk.upjs.ics.traveltracker;

import java.util.List;

public interface VyletDao {
    public void pridat(Vylet vylet);
    public void odstranit (Vylet vylet);
    public void upravitVylet (Vylet vylet);
    public void upravitPodrobnosti(Vylet vylet);
    public List<Vylet> dajVsetky();
    
    
}
