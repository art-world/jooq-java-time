package art.world.jooq.converter;

import java.sql.Date;
import java.time.LocalDate;

import org.jooq.Converter;

//You may prefer Java Calendars over JDBC Timestamps
public class DateConverter implements Converter<Date, LocalDate> {

    /**
     * 
     */
    private static final long serialVersionUID = -2936439676859292073L;

    @Override
    public LocalDate from(Date databaseObject) {
        return (databaseObject != null) ? databaseObject.toLocalDate() : null;
    }

    @Override
    public Date to(LocalDate userObject) {
        return (userObject != null) ? Date.valueOf(userObject) : null;
    }

    @Override
    public Class<Date> fromType() {
        return Date.class;
    }

    @Override
    public Class<LocalDate> toType() {
        return LocalDate.class;
    }
}
