package at.fhv.sys.eventbus.services;

import at.fhv.sys.eventbus.client.QueryClient;
import at.fhv.sys.eventbus.domain.EventEntity;
import at.fhv.sys.hotel.commands.shared.events.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class EventProcessingService {

    @Inject
    @RestClient
    QueryClient queryClient;

    @Inject
    EventServicePanache eventServicePanache;

    @Inject
    ObjectMapper objectMapper; // Jackson ObjectMapper wird hier injiziert

    public void processEvent(String stream, Object eventObject) {
        try {
            EventEntity eventEntity = new EventEntity();
            eventEntity.setStream(stream);
            String jsonPayload = objectMapper.writeValueAsString(eventObject);
            eventEntity.setPayload(jsonPayload);
            eventEntity.setTimestamp(LocalDateTime.now());
            eventEntity.setType(eventObject.getClass().getSimpleName());

            eventServicePanache.createEvent(eventEntity);

            if (eventObject instanceof CustomerCreated) {
                queryClient.forwardCustomerCreatedEvent((CustomerCreated) eventObject);
            } else if (eventObject instanceof RoomBooked) {
                queryClient.forwardRoomBookedEvent((RoomBooked) eventObject);
            } else if (eventObject instanceof RoomCreated) {
                queryClient.forwardRoomCreatedEvent((RoomCreated) eventObject);
            } else if (eventObject instanceof BookingCancelled) {
                queryClient.forwardBookingCancelledEvent((BookingCancelled) eventObject);
            } else if (eventObject instanceof BookingPaid) {
                queryClient.forwardBookingPaidEvent((BookingPaid) eventObject);
            } else {
                System.out.println("Unsupported event type: " + eventObject.getClass().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error processing event: " + e.getMessage());
        }
    }

    public List<EventEntity> getAllEvents() {
        return eventServicePanache.getAllEvents();
    }
}
