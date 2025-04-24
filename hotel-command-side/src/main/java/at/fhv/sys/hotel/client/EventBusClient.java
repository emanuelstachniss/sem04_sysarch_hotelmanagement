package at.fhv.sys.hotel.client;

import at.fhv.sys.hotel.commands.shared.events.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.Path;

@RegisterRestClient(configKey="hotel-eventbus-api-client")
@Path("/api")
public interface EventBusClient {

    @POST
    @Path("/customerCreated")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CustomerCreated processCustomerCreatedEvent(CustomerCreated event);

    @POST
    @Path("/customerUpdated")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CustomerUpdated processCustomerUpdatedEvent(CustomerUpdated event);

    @POST
    @Path("/roomBooked")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    RoomBooked processRoomBookedEvent(RoomBooked event);

    @POST
    @Path("/roomCreated")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    RoomCreated processRoomCreatedEvent(RoomCreated event);

    @POST
    @Path("/bookingPaid")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    BookingPaid processBookingPaidEvent(BookingPaid event);
}
