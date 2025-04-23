package at.fhv.sys.eventbus.client;

import at.fhv.sys.hotel.commands.shared.events.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="hotel-query-api-client")
@Path("/api")
public interface QueryClient {

    @POST
    @Path("/customerCreated")
    @Consumes(MediaType.APPLICATION_JSON)
    void forwardCustomerCreatedEvent(CustomerCreated event);

    @POST
    @Path("/roomBooked")
    @Consumes(MediaType.APPLICATION_JSON)
    void forwardRoomBookedEvent(RoomBooked event);

    @POST
    @Path("/roomCreated")
    @Consumes(MediaType.APPLICATION_JSON)
    void forwardRoomCreatedEvent(RoomCreated event);

   }
