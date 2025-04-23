package at.fhv.sys.hotel.projection;

import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.commands.shared.events.RoomBooked;
import at.fhv.sys.hotel.models.BookingQueryModel;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.service.BookingService;
import at.fhv.sys.hotel.service.CustomerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class BookingProjection {

    @Inject
    BookingService bookingService;

    public List<BookingQueryModel> getBookings(LocalDate bookingStartDate, LocalDate bookingEndDate) {
        return bookingService.getBookings(bookingStartDate, bookingEndDate);
    }


    public void processRoomBookedEvent(RoomBooked roomBooked) {
        Logger.getAnonymousLogger().info("Processing event: " + roomBooked);

        bookingService.createBooking(new BookingQueryModel(roomBooked.getBookingId(), roomBooked.getCustomerId(), roomBooked.getRoomNumber(), roomBooked.getStartTime(), roomBooked.getEndTime()));
    }
}
