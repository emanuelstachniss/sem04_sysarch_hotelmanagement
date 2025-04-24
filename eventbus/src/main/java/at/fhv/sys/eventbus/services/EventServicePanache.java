package at.fhv.sys.eventbus.services;

import at.fhv.sys.eventbus.domain.EventEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EventServicePanache {

    @Transactional
    public void createEvent(EventEntity eventEntity) {
        eventEntity.persist();
    }

    @Transactional
    public List<EventEntity> getAllEvents() {
        return EventEntity.listAll();
    }

}
