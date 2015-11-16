package art.world.jooq.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import artworld.generated.jooq.tables.daos.EventDao;
import artworld.generated.jooq.tables.daos.FoodDao;
import artworld.generated.jooq.tables.daos.SysLogDao;
import artworld.generated.jooq.tables.pojos.Event;
import artworld.generated.jooq.tables.pojos.Food;
import artworld.generated.jooq.tables.pojos.SysLog;

/**
 * 
 * @author xtutran
 *
 */
public class TestConverter {

  private Configuration configuration;

  @Before
  public void init() throws SQLException, ClassNotFoundException {
    String userName = "postgres";
    String password = "postgres";
    String url = "jdbc:postgresql://127.0.0.1:5432/jooqtest";

    // Connection is the only JDBC resource that we need
    // PreparedStatement and ResultSet are handled by jOOQ, internally
    Class.forName("org.postgresql.Driver");
    Connection conn = DriverManager.getConnection(url, userName, password);
    configuration = new DefaultConfiguration().set(conn).set(SQLDialect.POSTGRES);
  }

  @Test
  public void testLocalDateConverter() {
    FoodDao foodDao = new FoodDao(configuration);

    LocalDate expected = LocalDate.now();
    
    //insert a row with LocalDate
    Long foodId = 1l;
    if(foodDao.existsById(foodId)) {
      Food food = foodDao.findById(foodId);

      food.setExpiredDate(expected);
      foodDao.update(food);
    } else {
      foodDao.insert(new Food(foodId, "test LocalDate", LocalDate.now()));
    }

    //retrieve existing row
    LocalDate actual = foodDao.findById(foodId).getExpiredDate();
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testLocalTimeConverter() {
    EventDao eventDao = new EventDao(configuration);

    LocalTime expectedStart = LocalTime.now();
    LocalTime expectedEnd = expectedStart.plusHours(1);

    //insert a row with LocalTime
    Integer eventId = 1;
    if(eventDao.existsById(eventId)) {
      Event act = eventDao.findById(eventId);

      act.setStartTime(expectedStart);
      act.setEndTime(expectedEnd);

      eventDao.update(act);
    } else {
      eventDao.insert(new Event(eventId, "test LocalTime", expectedStart, expectedEnd));
    }

    //retrieve existing row
    LocalTime actualStart = eventDao.findById(eventId).getStartTime();
    LocalTime actualEnd = eventDao.findById(eventId).getEndTime();

    Assert.assertEquals(Time.valueOf(expectedStart), Time.valueOf(actualStart));
    Assert.assertEquals(Time.valueOf(expectedEnd), Time.valueOf(actualEnd));
  }

  @Test
  public void testInstantConverter() {
    SysLogDao logDao = new SysLogDao(configuration);

    Instant expected = Instant.now();
    
    //insert a row with LocalDate
    Long sysId = 1l;
    if(logDao.existsById(sysId)) {
      SysLog food = logDao.findById(sysId);

      food.setWhenUtc(expected);
      logDao.update(food);
    } else {
      logDao.insert(new SysLog(sysId, "test Instant", Instant.now()));
    }

    //retrieve existing row
    Instant actual = logDao.findById(sysId).getWhenUtc();
    Assert.assertEquals(Timestamp.from(expected), Timestamp.from(actual));
  }
}
