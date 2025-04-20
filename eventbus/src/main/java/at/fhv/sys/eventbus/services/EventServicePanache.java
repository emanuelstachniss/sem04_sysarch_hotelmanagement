package at.fhv.sys.eventbus.services;

import at.fhv.sys.eventbus.domain.EventEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EventServicePanache {

    @Transactional
    public void createEvent(EventEntity eventEntity) {
        eventEntity.persist();
    }
}
