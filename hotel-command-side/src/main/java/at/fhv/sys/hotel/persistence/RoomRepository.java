package at.fhv.sys.hotel.persistence;

import at.fhv.sys.hotel.domain.Room;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RoomRepository {

    private final List<Room> rooms = new ArrayList<>();

    public RoomRepository() {
        rooms.add(createRoom(101, 1, 89.99, false, "Kleines Einzelzimmer ohne Balkon"));
        rooms.add(createRoom(102, 2, 129.99, true, "Doppelzimmer mit Balkon und Stadtblick"));
        rooms.add(createRoom(201, 4, 199.99, true, "Familienzimmer mit Balkon"));
        rooms.add(createRoom(202, 2, 119.99, false, "Klassisches Doppelzimmer"));
        rooms.add(createRoom(301, 1, 94.50,  false, "Einzelzimmer mit Schreibtisch"));
        rooms.add(createRoom(302, 2, 135.00, true, "Komfortzimmer mit großem Bad"));
        rooms.add(createRoom(401, 3, 179.90, true, "Deluxe-Zimmer mit Lounge-Bereich"));
        rooms.add(createRoom(402, 2, 125.00, false, "Standard Doppelzimmer"));
        rooms.add(createRoom(501, 1, 99.90,  false, "Einzelzimmer mit Gartenblick"));
        rooms.add(createRoom(502, 2, 139.99, true, "Modernes Doppelzimmer mit Balkon"));
    }

    private Room createRoom(int number, int capacity, double price, boolean hasBalcony, String description) {
        return Room.builder()
                .roomNumber(number)
                .capacity(capacity)
                .price(price)
                .hasBalcony(hasBalcony)
                .description(description)
                .build();
    }

    public void save(Room room) {
        rooms.add(room);
    }

    public List<Room> findAll() {
        return new ArrayList<>(rooms);
    }

    public Room findByRoomNumber(int roomNumber) {
        return rooms.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }
}

