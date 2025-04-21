package at.fhv.sys.hotel.controller;

import at.fhv.sys.hotel.commands.BookRoomCommand;
import at.fhv.sys.hotel.commands.CreateCustomerCommand;
import at.fhv.sys.hotel.commands.RoomAggregate;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomCommandController {

    private final RoomAggregate roomAggregate;

    @jakarta.inject.Inject
    public RoomCommandController(RoomAggregate roomAggregate) {
        this.roomAggregate = roomAggregate;
    }

    @POST
    @Path("/bookRoom")
    public int bookRoom(@QueryParam("startTime") String startTime, @QueryParam("endTime") String endTime, @QueryParam("roomNumber") int roomNumber, @QueryParam("customerId") int customerId){
        return roomAggregate.handle(new BookRoomCommand(startTime, endTime, roomNumber, customerId));
    }
}
