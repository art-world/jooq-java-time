package art.world.jooq.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

/*import artworld.generated.jooq.tables.daos.EventDao;
import artworld.generated.jooq.tables.daos.FoodDao;
import artworld.generated.jooq.tables.daos.SysLogDao;
import artworld.generated.jooq.tables.pojos.Event;
import artworld.generated.jooq.tables.pojos.Food;
import artworld.generated.jooq.tables.pojos.SysLog;*/

public class DaoTest {

    /*public static void main(String[] args) throws ClassNotFoundException {
        String userName = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://127.0.0.1:5433/jooqtest";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Class.forName("org.postgresql.Driver");

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            Configuration configuration = new DefaultConfiguration().set(conn).set(SQLDialect.POSTGRES);

            FoodDao bookDao = new FoodDao(configuration);
            EventDao eventDao = new EventDao(configuration);
            SysLogDao logDao = new SysLogDao(configuration);

            //List<Food> actors = bookDao.findAll();
            List<artworld.generated.jooq.tables.pojos.Event> events = eventDao.findAll();
            
            for(Event act : events) {
                //System.out.println(act.getExpiredDate());
                //act.setExpiredDate(LocalDate.now(ZoneId.of("America/Los_Angeles")));
                //bookDao.update(act);
                act.setStartTime(LocalTime.now());
                act.setEndTime(LocalTime.now().plusHours(1));
                eventDao.update(act);
            }
            
            System.out.println(logDao.findById(1l).getWhenUtc());
            
            
            //logDao.insert(new SysLog(1l, "Test1", Instant.now()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
