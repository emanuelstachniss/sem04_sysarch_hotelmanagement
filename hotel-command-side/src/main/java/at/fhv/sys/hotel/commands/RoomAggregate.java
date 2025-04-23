package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.client.EventBusClient;
import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.commands.shared.events.RoomCreated;
import at.fhv.sys.hotel.domain.Customer;
import at.fhv.sys.hotel.domain.Room;
import at.fhv.sys.hotel.persistence.CustomerRepository;
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

    public String handle(CreateRoomCommand command) {

        try {
            Room room = Room.builder()
                    .roomNumber(command.roomNumber())
                    .capacity(command.capacity())
                    .price(command.price())
                    .hasBalcony(command.hasBalcony())
                    .description(command.description())
                    .build();

            roomRepository.save(room);

            RoomCreated event = new RoomCreated(room.getRoomId(), room.getRoomNumber(), room.getCapacity(), room.getPrice(), room.hasBalcony(), room.getDescription());

            Logger.getAnonymousLogger().info(eventClient.processRoomCreatedEvent(event).toString());

        } catch (IllegalArgumentException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }

        return "Room created";
    }

}
