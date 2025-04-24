package at.fhv.sys.eventbus.services;

import at.fhv.sys.eventbus.client.QueryClient;
import at.fhv.sys.eventbus.domain.EventEntity;
import at.fhv.sys.hotel.commands.shared.events.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@Startup
public class EventRestoreService {

    @Inject
    EventServicePanache eventServicePanache;

    @Inject
    @RestClient
    QueryClient queryClient;

    @Inject
    ObjectMapper objectMapper;

    @PostConstruct
    public void restore() {
        System.err.println("Restoring Events...");

        List<EventEntity> allEvents = eventServicePanache.getAllEvents();

        for (EventEntity eventEntity : allEvents) {
            try {
                switch (eventEntity.getType()) {
                    case "CustomerCreated":
                        CustomerCreated customerEvent = objectMapper.readValue(eventEntity.getPayload(), CustomerCreated.class);
                        queryClient.forwardCustomerCreatedEvent(customerEvent);
                        //commandClient.handleCustomerCreated(customerEvent);  // An Command Side weiterleiten
                        break;

                    case "RoomCreated":
                        RoomCreated roomEvent = objectMapper.readValue(eventEntity.getPayload(), RoomCreated.class);
                        queryClient.forwardRoomCreatedEvent(roomEvent);
                        //commandClient.handleRoomCreated(roomEvent);  // An Command Side weiterleiten
                        break;

                    case "BookingCancelled":
                        BookingCancelled bookingCanceled = objectMapper.readValue(eventEntity.getPayload(), BookingCancelled.class);
                        queryClient.forwardBookingCancelledEvent(bookingCanceled);
                        //commandClient.handleBookingCancelled(bookingCanceled);  // An Command Side weiterleiten
                        break;

                    default:
                        System.out.println("Processing event: " + eventEntity.getType());
                        System.out.println("Payload: " + eventEntity.getPayload());
                        break;
                }
            } catch (Exception e) {
                System.err.println("Failed to process event: " + eventEntity.getType() + ", Error: " + e.getMessage());
            }
        }
    }
}

