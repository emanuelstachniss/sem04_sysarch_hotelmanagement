package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.client.EventBusClient;
import at.fhv.sys.hotel.commands.shared.events.BookingCancelled;
import at.fhv.sys.hotel.commands.shared.events.RoomBooked;
import at.fhv.sys.hotel.domain.Booking;
import at.fhv.sys.hotel.domain.Customer;
import at.fhv.sys.hotel.domain.Room;
import at.fhv.sys.hotel.persistence.BookingRepository;
import at.fhv.sys.hotel.persistence.CustomerRepository;
import at.fhv.sys.hotel.persistence.RoomRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.logging.Logger;

@ApplicationScoped
public class BookingAggregate {

    @Inject
    @RestClient
    EventBusClient eventClient;

    @Inject
    BookingRepository bookingRepository;

    @Inject
    RoomRepository roomRepository;

    @Inject
    CustomerRepository customerRepository;

    public String handle(BookRoomCommand command) {
        try {
            Room room = roomRepository.findByRoomNumber(command.roomNumber());
            if (room == null) {
                throw new IllegalArgumentException("Room not found");
            }

            Customer customer = customerRepository.findByName(command.firstname(), command.lastname());

            Booking booking = Booking.builder()
                    .room(room)
                    .customer(customer)
                    .bookingStartDate(LocalDate.parse(command.startTime()))
                    .bookingEndDate(LocalDate.parse(command.endTime()))
                    .build();
            bookingRepository.save(booking);

            RoomBooked event = new RoomBooked(
                    booking.getBookingId(),
                    booking.getCustomer().getCustomerId(),
                    booking.getBookingStartDate(),
                    booking.getBookingEndDate(),
                    room.getRoomNumber(),
                    room.getCapacity()
            );

            Logger.getAnonymousLogger().info("Sending RoomBooked event...");
            Logger.getAnonymousLogger().info(eventClient.processRoomBookedEvent(event).toString());

            return "Room booked successfully";

        } catch (IllegalArgumentException e) {
            Logger.getAnonymousLogger().warning("Booking failed: " + e.getMessage());
            return "Booking failed: " + e.getMessage();
        }
    }

    public String cancel(CancelBookingCommand command) {
        try {
            Booking booking = bookingRepository.findById(command.bookingId());
            if (booking == null) {
                return "Booking not found";
            }

            bookingRepository.remove(command.bookingId());

            BookingCancelled event = new BookingCancelled(command.bookingId());

            Logger.getAnonymousLogger().info("Sending BookingCancelled event...");
            Logger.getAnonymousLogger().info(eventClient.processBookingCancelledEvent(event).toString());

            return "Booking cancelled successfully";

        } catch (Exception e) {
            Logger.getAnonymousLogger().warning("Cancellation failed: " + e.getMessage());
            return "Cancellation failed: " + e.getMessage();
        }
    }
}
