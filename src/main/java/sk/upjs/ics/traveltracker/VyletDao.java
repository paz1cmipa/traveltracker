
package sk.upjs.ics.traveltracker;

import java.util.Date;
import java.util.List;

public interface VyletDao {
    public void pridat(Vylet vylet);
    public void odstranit (Vylet vylet);
    public void Upravit (Vylet vylet);
    public List<Vylet> dajVsetky();
    public List<Vylet> Hladat(String s);
    public Vylet hladatPreUpravu(String krajina, String mesto, String pamiatka);
    
    
}
