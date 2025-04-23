package at.fhv.sys.hotel.projection;

import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.commands.shared.events.RoomCreated;
import at.fhv.sys.hotel.models.BookingQueryModel;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.models.RoomQueryModel;
import at.fhv.sys.hotel.service.CustomerService;
import at.fhv.sys.hotel.service.RoomService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class RoomProjection {

    @Inject
    RoomService roomService;

    public List<RoomQueryModel> getAllRooms() {
        return roomService.getAllRooms();
    }

    public List<RoomQueryModel> getFreeRooms(LocalDate startDate, LocalDate endDate, int numberOfPersons, List<BookingQueryModel> bookings) {
        return roomService.getFreeRooms(startDate, endDate, numberOfPersons, bookings);
    }



    public void processCustomerCreatedEvent(RoomCreated roomCreatedEvent) {
        Logger.getAnonymousLogger().info("Processing event: " + roomCreatedEvent);

        roomService.createRoom(new RoomQueryModel(roomCreatedEvent.getRoomId(), roomCreatedEvent.getRoomNumber(), roomCreatedEvent.getCapacity(), roomCreatedEvent.getPrice(), roomCreatedEvent.getHasBalcony(), roomCreatedEvent.getDescription()));
    }
}
