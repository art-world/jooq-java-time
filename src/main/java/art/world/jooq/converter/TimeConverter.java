package art.world.jooq.converter;

import java.sql.Time;
import java.time.LocalTime;

import org.jooq.Converter;

public class TimeConverter implements Converter<Time, LocalTime> {

    /**
     * 
     */
    private static final long serialVersionUID = -3225887438025636404L;

    @Override
    public LocalTime from(Time databaseObject) {
        
        return (databaseObject != null) ? databaseObject.toLocalTime() : null;
    }

    @Override
    public Time to(LocalTime userObject) {
        return (userObject != null) ? Time.valueOf(userObject) : null;
    }

    @Override
    public Class<Time> fromType() {
        return Time.class;
    }

    @Override
    public Class<LocalTime> toType() {
        return LocalTime.class;
    }

}
