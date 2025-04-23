package at.fhv.sys.eventbus.services;

import at.fhv.sys.eventbus.client.QueryClient;
import at.fhv.sys.eventbus.domain.EventEntity;
import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.commands.shared.events.RoomBooked;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;

@ApplicationScoped
public class EventProcessingService {

    @Inject
    @RestClient
    QueryClient queryClient;

    @Inject
    EventServicePanache eventServicePanache;

    public void processEvent(String stream, Object eventObject) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setStream(stream);
        eventEntity.setPayload(eventObject.toString());
        eventEntity.setTimestamp(LocalDateTime.now());
        eventEntity.setType(eventObject.getClass().getSimpleName());

        eventServicePanache.createEvent(eventEntity);

        //queryClient.forwardCustomerCreatedEvent((CustomerCreated) eventObject);

        if (eventObject instanceof CustomerCreated) {
            queryClient.forwardCustomerCreatedEvent((CustomerCreated) eventObject);
        } else if (eventObject instanceof RoomBooked) {
            queryClient.forwardRoomBookedEvent((RoomBooked) eventObject);
            System.out.println("Test");
        } else {
            System.out.println("Unsupported event type: " + eventObject.getClass().getName());
        }
    }
}