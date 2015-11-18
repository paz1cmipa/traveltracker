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
        int cislo = vylet.getId();
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
    public Vylet hladatPreUpravu(String krajina, String mesto, String pamiatka) {
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

    @Override
    public void Upravit(Vylet vylet) {
         String sql = "UPDATE `traveltracker`.`vylet`" +
        " SET" +
        " `krajina` = ?," +
        " `mesto` = ?," +
        " `prirodna_a_kulturna_pamiatka` = ?" +
        " WHERE `id` = ?;";
        jdbcTemplate.update(sql, vylet.getKrajina(), vylet.getMesto(), vylet.getPrirodna_a_kulturna_pamiatka(), vylet.getId());
      
    }
   

}
