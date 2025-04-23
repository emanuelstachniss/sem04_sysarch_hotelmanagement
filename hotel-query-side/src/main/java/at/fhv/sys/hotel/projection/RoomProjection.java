package at.fhv.sys.hotel.projection;

import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.commands.shared.events.RoomCreated;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.models.RoomQueryModel;
import at.fhv.sys.hotel.service.CustomerService;
import at.fhv.sys.hotel.service.RoomService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class RoomProjection {

    @Inject
    RoomService roomService;

    public List<RoomQueryModel> getAllRooms() {
        return roomService.getAllRooms();
    }

    public void processCustomerCreatedEvent(RoomCreated roomCreatedEvent) {
        Logger.getAnonymousLogger().info("Processing event: " + roomCreatedEvent);

        roomService.createRoom(new RoomQueryModel(roomCreatedEvent.getRoomId(), roomCreatedEvent.getRoomNumber(), roomCreatedEvent.getCapacity(), roomCreatedEvent.getPrice(), roomCreatedEvent.getHasBalcony(), roomCreatedEvent.getDescription()));
    }
}
