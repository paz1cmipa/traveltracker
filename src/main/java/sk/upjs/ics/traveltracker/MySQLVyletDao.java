package sk.upjs.ics.traveltracker;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySQLVyletDao implements VyletDao {

    private JdbcTemplate jdbcTemplate;
    private int id;

    public MySQLVyletDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/traveltracker");
        dataSource.setUser("TravelTracker");
        dataSource.setPassword("TravelTracker");

        jdbcTemplate = new JdbcTemplate(dataSource);
        int max=0;
        List<Vylet> vylety=dajVsetky();
        for (Vylet vylet : vylety) {
           if(vylet.getId()<max){
           max=vylet.getId();
           }  
        }
        id=max+1;
    }

    @Override
    public void pridat(Vylet vylet) {
        String sql = "INSERT INTO vylet VALUES (?,?,?,?,?)";
          id++;
        vylet.setId(id);
        jdbcTemplate.update(sql, vylet.getId(), vylet.getKrajina(), vylet.getMesto(), vylet.getPrirodna_a_kulturna_pamiatka(), vylet.getDatum());
        String sql1 = "INSERT INTO podrobnosti VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql1, vylet.getId(), vylet.isNavstivenost(), vylet.getHodnotenie(), vylet.getPodrobnosti(), vylet.getPoznamka());

    }

    @Override
    public void odstranit(Vylet vylet) {
        int cislo=vylet.getId();
        String sql="DELETE FROM vylet where id=?";
        jdbcTemplate.update(sql,cislo);
         String sql1="DELETE FROM podrobnosti where id=?";
        jdbcTemplate.update(sql1,cislo);

    }

  

    @Override
    public List<Vylet> dajVsetky() {
        String sql = "SELECT * FROM vylet ORDER BY datum ASC";
      BeanPropertyRowMapper<Vylet> mapper = BeanPropertyRowMapper.newInstance(Vylet.class);
     
      return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public void upravitPodrobnosti(Vylet vylet) {
      String sql="UPDATE podrobnosti SET podrobnosti= ? where id=?";
       jdbcTemplate.update(sql,vylet.getPodrobnosti(),vylet.getId());
    }

    @Override
    public void upravitKrajina(Vylet vylet) {
        String sql="UPDATE vylet SET krajina= ? where id=?";
          jdbcTemplate.update(sql,vylet.getKrajina(),vylet.getId());
        
    }

    @Override
    public void upravitMesto(Vylet vylet) {
        String sql="UPDATE vylet SET mesto= ? where id=?";
            jdbcTemplate.update(sql,vylet.getMesto(),vylet.getId());
    }

    @Override
    public void upravitPamiatka(Vylet vylet) {
        String sql="UPDATE vylet SET Prirodna_a_kulturna_pamiatka= ? where id=?";
             jdbcTemplate.update(sql,vylet.getPrirodna_a_kulturna_pamiatka(),vylet.getId());
        
    }

    @Override
    public void upravitDatum(Vylet vylet) {
        String sql="UPDATE vylet SET datum= ? where id=?";
             jdbcTemplate.update(sql,vylet.getDatum(),vylet.getId());
        
        
         
    }
    

    @Override
    public void upravitNavstivene(Vylet vylet) {
        String sql="UPDATE podrobnosti SET Navstivenost= ? where id=?";
            jdbcTemplate.update(sql,vylet.isNavstivenost(),vylet.getId());
        
        
    }

    @Override
    public void upravitHodnotenie(Vylet vylet) {
        String sql="UPDATE podrobnosti SET Hodnotenie= ? where id=?";
            jdbcTemplate.update(sql,vylet.getHodnotenie(),vylet.getId());
        }

    @Override
    public void upravitPoznamky(Vylet vylet) {
        String sql="UPDATE podrobnosti SET Poznamky= ? where id=?";
            jdbcTemplate.update(sql,vylet.getPoznamka(),vylet.getId());
        
    }

    @Override
    public List<Vylet> Hladat(String s) {
       String sql = "select * from vylet" +
    " where" +
    " krajina like '?'" +
    " or mesto like '?'" +
    " or prirodna_a_kulturna_pamiatka like '?'";
       
     BeanPropertyRowMapper<Vylet> mapper = BeanPropertyRowMapper.newInstance(Vylet.class);
     
     return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Vylet hladatpreUpravu(String krajina, String mesto, String pamiatka) {
       List<Vylet> vylety=dajVsetky();
      
        for (Vylet vylet : vylety) {
           if((vylet.getKrajina().equals(krajina))
                   &&(vylet.getMesto().equals(mesto))
                   &&(vylet.getPrirodna_a_kulturna_pamiatka().equals(pamiatka))){
           return vylet;
           }
            
        }
    return null;
    }
   

}
