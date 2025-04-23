package at.fhv.sys.hotel.controller;

import at.fhv.sys.hotel.commands.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomCommandController {

    RoomAggregate roomAggregate;

    public RoomCommandController(RoomAggregate roomAggregate) {
        this.roomAggregate = roomAggregate;
    }

    @POST
    @Path("/createRoom")
    public String createRoom(@QueryParam("roomNumber") int roomNumber, @QueryParam("capacity") int capacity, @QueryParam("price") Double price, @QueryParam("hasBalcony") boolean hasbalcony, @QueryParam("description") String description) {
        return roomAggregate.handle(new CreateRoomCommand(roomNumber, capacity, price, hasbalcony, description));
    }

}