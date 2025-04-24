package at.fhv.sys.hotel.controller;

import at.fhv.sys.hotel.commands.BookRoomCommand;
import at.fhv.sys.hotel.commands.BookingAggregate;
import at.fhv.sys.hotel.commands.CancelBookingCommand;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingCommandController {

    BookingAggregate bookingAggregate;

    public BookingCommandController(BookingAggregate roomAggregate) {
        this.bookingAggregate = roomAggregate;
    }

    @POST
    @Path("/bookRoom")
    public String bookRoom(@QueryParam("startTime") String startTime, @QueryParam("endTime") String endTime, @QueryParam("roomNumber") int roomNumber, @QueryParam("capacity") int capacity, @QueryParam("lastname") String lastname, @QueryParam("firstname") String firstname) {
        return bookingAggregate.handle(new BookRoomCommand(startTime, endTime, roomNumber, capacity, lastname, firstname));
    }

    @DELETE
    @Path("/cancelBooking")
    public String cancelBooking(@QueryParam("bookingId") UUID bookingId) {
        return bookingAggregate.cancel(new CancelBookingCommand(bookingId));
    }

}
