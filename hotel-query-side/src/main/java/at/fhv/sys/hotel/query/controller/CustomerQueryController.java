package at.fhv.sys.hotel.query.controller;

import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.dto.BookingDTO;
import at.fhv.sys.hotel.dto.CustomerDTO;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.projection.CustomerProjection;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logmanager.Logger;

import java.util.ArrayList;
import java.util.List;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerQueryController {

    @Inject
    CustomerProjection customerProjection;

    public CustomerQueryController() {
    }

    @GET
    @Path("/getCustomers")
    public List<CustomerDTO> getCustomers(@QueryParam("lastName") String lastName) {
        List<CustomerQueryModel> customers;

        if (lastName != null && !lastName.isBlank()) {
            customers = customerProjection.getCustomersByLastName(lastName);
        } else {
            customers = customerProjection.getAllCustomers();
        }

        List<CustomerDTO> customersDTO = new ArrayList<>();
        for (CustomerQueryModel customer : customers) {
            customersDTO.add(customer.toDTO());
        }

        return customersDTO;
    }

    @POST
    @Path("/customerCreated")
    public Response customerCreated(CustomerCreated event) {
        Logger.getAnonymousLogger().info("Received event: " + event);
        customerProjection.processCustomerCreatedEvent(event);
        return Response.ok(event).build();
    }
}