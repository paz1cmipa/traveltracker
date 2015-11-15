package sk.upjs.ics.traveltracker;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
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
    public void upravit(Vylet vylet) {

    }

}
