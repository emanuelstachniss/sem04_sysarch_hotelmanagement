package at.fhv.sys.eventbus.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class EventEntity extends PanacheEntity {

    //Panache makes id

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
}
