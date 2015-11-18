package sk.upjs.ics.traveltracker;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySQLVyletDao implements VyletDao {

    private JdbcTemplate jdbcTemplate;


    public MySQLVyletDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/traveltracker");
        dataSource.setUser("TravelTracker");
        dataSource.setPassword("TravelTracker");

        jdbcTemplate = new JdbcTemplate(dataSource);
        
    }

    @Override
    public void pridat(Vylet vylet) {
        String sql = "INSERT INTO vylet VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, null, vylet.getKrajina(), vylet.getMesto(), vylet.getPrirodna_a_kulturna_pamiatka(), vylet.getDatum());
    
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
    /*   String sql = "select * from vylet" +
    " where" +
    " krajina like '?'" +
    " or mesto like '?'" +
    " or prirodna_a_kulturna_pamiatka like '?'";
       
     BeanPropertyRowMapper<Vylet> mapper = BeanPropertyRowMapper.newInstance(Vylet.class);
     
     return jdbcTemplate.query(sql, mapper);*/
        //prerobit na daj vsetky a v tom zozname to najst
        return null;
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
