package at.fhv.sys.hotel.persistence;

import at.fhv.sys.hotel.domain.Booking;
import at.fhv.sys.hotel.domain.Room;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingRepository {

    private List<Booking> bookings = new ArrayList<Booking>();

    public void save(Booking booking) {
        bookings.add(booking);
    }

    public Booking findById(UUID id) {
        return bookings.stream()
                .filter(b -> b.getBookingId().equals(id))
                .findFirst()
                .orElse(null);
    }
}