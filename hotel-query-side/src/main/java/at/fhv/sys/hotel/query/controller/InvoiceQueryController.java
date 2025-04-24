package at.fhv.sys.hotel.query.controller;

import at.fhv.sys.hotel.commands.shared.events.BookingPaid;
import at.fhv.sys.hotel.projection.InvoiceProjection;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logmanager.Logger;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InvoiceQueryController {

    @Inject
    InvoiceProjection invoiceProjection;

    public InvoiceQueryController (){

    }

    @POST
    @Path("/bookingPaid")
    public Response bookingPaid(BookingPaid event) {
        Logger.getAnonymousLogger().info("Received event: " + event);
        invoiceProjection.processBookingPaidEvent(event);
        return Response.ok(event).build();
    }

}
