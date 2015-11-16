
package sk.upjs.ics.traveltracker;


public enum VyletDaoFactory {
    INSTANCE;
    
    public VyletDao getVyletDao(){
        return new MySQLVyletDao();
    }
    
}
