package at.fhv.sys.hotel.persistence;

import at.fhv.sys.hotel.domain.Booking;
import at.fhv.sys.hotel.domain.Room;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookingRepository {

    private List<Booking> bookings = new ArrayList<Booking>();

    public void save(Booking booking) {
        bookings.add(booking);
    }
    }

