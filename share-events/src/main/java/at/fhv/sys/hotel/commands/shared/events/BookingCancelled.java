package at.fhv.sys.hotel.commands.shared.events;

public class BookingCancelled {

    private Long bookingId;

    public BookingCancelled(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getBookingId() {
        return bookingId;
    }
}
