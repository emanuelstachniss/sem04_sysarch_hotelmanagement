package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.client.EventBusClient;
import at.fhv.sys.hotel.commands.shared.events.RoomBooked;
import at.fhv.sys.hotel.domain.Room;
import at.fhv.sys.hotel.persistence.RoomRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.logging.Logger;

@ApplicationScoped
public class RoomAggregate {

    @Inject
    @RestClient
    EventBusClient eventClient;

    @Inject
    RoomRepository roomRepository;

    public String handle(BookRoomCommand command) {
        try {
            Room room = Room.builder()
                    .roomNumber(command.roomNumber())
                    .capacity(command.capacity())
                    .build();

            // Im Repository speichern
            roomRepository.save(room);

            // Event erzeugen
            RoomBooked event = new RoomBooked(
                    command.startTime(),
                    command.endTime(),
                    command.roomNumber(),
                    command.lastname(),
                    command.firstname()
            );

            // Event verarbeiten
            Logger.getAnonymousLogger().info(eventClient.processRoomBookedEvent(event).toString());

            return "Room booked successfully";

        } catch (IllegalArgumentException e) {
            Logger.getAnonymousLogger().info("Booking failed: " + e.getMessage());
            return "Booking failed";
        }
    }
}
