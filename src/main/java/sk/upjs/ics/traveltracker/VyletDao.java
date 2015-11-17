
package sk.upjs.ics.traveltracker;

import java.util.Date;
import java.util.List;

public interface VyletDao {
    public void pridat(Vylet vylet);
    public void odstranit (Vylet vylet);
    public void upravitKrajina (Vylet vylet);
    public void upravitMesto(Vylet vylet);
    public void upravitPamiatka(Vylet vylet);
    public void upravitDatum(Vylet vylet);
    public void upravitNavstivene(Vylet vylet);
    public void upravitHodnotenie(Vylet vylet);
    public void upravitPoznamky(Vylet vylet);
    public void upravitPodrobnosti(Vylet vylet);
    public List<Vylet> dajVsetky();
    public List<Vylet> Hladat(String s);
    public Vylet hladatpreUpravu(String krajina, String mesto, String pamiatka);
    
    
}
