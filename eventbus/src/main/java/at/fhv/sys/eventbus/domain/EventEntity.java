package at.fhv.sys.eventbus.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EventEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String stream;
    private String type;
    @Lob
    private String payload;
    private LocalDateTime timestamp;


    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
