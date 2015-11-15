package sk.upjs.ics.traveltracker;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
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

    }

  

    @Override
    public List<Vylet> dajVsetky() {
        String sql = "SELECT * FROM vylet ORDER BY datum DESC";
      BeanPropertyRowMapper<Vylet> mapper = BeanPropertyRowMapper.newInstance(Vylet.class);
     
      return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public void upravitPodrobnosti(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravitKrajina(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravitMesto(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravitPamiatka(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravitDatum(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravitNavstivene(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravitHodnotenie(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upravitPoznamky(Vylet vylet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
