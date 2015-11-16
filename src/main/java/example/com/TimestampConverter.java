package example.com;

import java.sql.Timestamp;
import java.time.Instant;

import org.jooq.Converter;

public class TimestampConverter implements Converter<Timestamp, Instant>{

    /**
     * 
     */
    private static final long serialVersionUID = -6989063642943228603L;

    @Override
    public Instant from(Timestamp databaseObject) {
        return (databaseObject != null) ? databaseObject.toInstant() : null;
    }

    @Override
    public Timestamp to(Instant userObject) {
        return (userObject != null) ? Timestamp.from(userObject) : null;
    }

    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    @Override
    public Class<Instant> toType() {
        return Instant.class;
    }
}
