package at.fhv.sys.hotel.controller;

import at.fhv.sys.hotel.commands.BookRoomCommand;
import at.fhv.sys.hotel.commands.BookingAggregate;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingCommandController {

    private final BookingAggregate roomAggregate;

    public BookingCommandController(BookingAggregate roomAggregate) {
        this.roomAggregate = roomAggregate;
    }

    @POST
    @Path("/bookRoom")
    public String bookRoom(@QueryParam("startTime") String startTime, @QueryParam("endTime") String endTime, @QueryParam("roomNumber") int roomNumber, @QueryParam("capacity") int capacity, @QueryParam("lastname") String lastname, @QueryParam("firstname") String firstname) {
        return roomAggregate.handle(new BookRoomCommand(startTime, endTime, roomNumber, capacity, lastname, firstname));
    }
}
