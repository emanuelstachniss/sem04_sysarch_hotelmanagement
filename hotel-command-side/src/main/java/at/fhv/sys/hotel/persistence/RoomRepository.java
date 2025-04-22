package at.fhv.sys.hotel.persistence;

import at.fhv.sys.hotel.domain.Customer;
import at.fhv.sys.hotel.domain.Room;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RoomRepository {

    private List<Room> rooms = new ArrayList<Room>();

    public void save(Room room) {
        rooms.add(room);
    }
    }

