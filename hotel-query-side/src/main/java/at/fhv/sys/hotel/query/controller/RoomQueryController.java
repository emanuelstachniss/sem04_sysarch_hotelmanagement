package at.fhv.sys.hotel.query.controller;

import at.fhv.sys.hotel.commands.shared.events.RoomCreated;
import at.fhv.sys.hotel.dto.RoomDTO;
import at.fhv.sys.hotel.models.BookingQueryModel;
import at.fhv.sys.hotel.models.RoomQueryModel;
import at.fhv.sys.hotel.projection.RoomProjection;
import at.fhv.sys.hotel.service.BookingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logmanager.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomQueryController {

    @Inject
    RoomProjection roomProjection;

    @Inject
    BookingService bookingService;

    public RoomQueryController() {
    }

    @GET
    @Path("/getAllRooms")
    public List<RoomDTO> getAllRooms() {
        List<RoomQueryModel> rooms = roomProjection.getAllRooms();

        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (RoomQueryModel room : rooms) {
            roomsDTO.add(room.toDTO());
        }

        return roomsDTO;
    }

    @GET
    @Path("/getFreeRooms")
    public List<RoomDTO> getFreeRooms(@QueryParam("startDate") LocalDate startDate,
                                      @QueryParam("endDate") LocalDate endDate,
                                      @QueryParam("numberOfPersons") int numberOfPersons) {
        List<BookingQueryModel> bookings = bookingService.getBookings(startDate, endDate);
        List<RoomQueryModel> freeRooms = roomProjection.getFreeRooms(startDate, endDate, numberOfPersons, bookings);

        return freeRooms.stream()
                .map(RoomQueryModel::toDTO)
                .collect(Collectors.toList());
    }




    @POST
    @Path("/roomCreated")
    public Response roomCreated(RoomCreated event) {
        Logger.getAnonymousLogger().info("Received event: " + event);
        roomProjection.processCustomerCreatedEvent(event);
        return Response.ok(event).build();
    }
}