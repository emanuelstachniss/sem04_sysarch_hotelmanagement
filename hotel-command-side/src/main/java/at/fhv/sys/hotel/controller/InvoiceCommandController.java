package at.fhv.sys.hotel.controller;

import at.fhv.sys.hotel.commands.InvoiceAggregate;
import at.fhv.sys.hotel.commands.PayBookingCommand;
import at.fhv.sys.hotel.commands.shared.events.PaymentMethod;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InvoiceCommandController {

    private final InvoiceAggregate invoiceAggregate;

    public InvoiceCommandController(InvoiceAggregate invoiceAggregate) {
        this.invoiceAggregate = invoiceAggregate;
    }

    @POST
    @Path("/payBooking")
    public String payBooking(@QueryParam("bookingId") UUID bookingId, @QueryParam("paymentMethod") PaymentMethod paymentMethod) {
        return invoiceAggregate.handle(new PayBookingCommand(bookingId, paymentMethod));
    }
}
