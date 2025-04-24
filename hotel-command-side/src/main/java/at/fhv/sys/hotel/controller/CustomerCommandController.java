package at.fhv.sys.hotel.controller;

import at.fhv.sys.hotel.commands.CreateCustomerCommand;
import at.fhv.sys.hotel.commands.CustomerAggregate;
import at.fhv.sys.hotel.commands.UpdateCustomerCommand;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerCommandController {

    CustomerAggregate customerAggregate;

    public CustomerCommandController(CustomerAggregate customerAggregate) {
        this.customerAggregate = customerAggregate;
    }

    @POST
    @Path("/createCustomer")
    public String createCustomer(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("address") String address, @QueryParam("birthday") LocalDate birthday) {
        return customerAggregate.handle(new CreateCustomerCommand(firstName, lastName, address, birthday));
    }

    @POST
    @Path("/updateCustomer")
    public String updateCustomer(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("newFirstName") String newFirstName, @QueryParam("newLastName") String newLastName, @QueryParam("newAddress") String newAddress, @QueryParam("newBirthday") LocalDate newBirthday) {
        return customerAggregate.update(new UpdateCustomerCommand(firstName, lastName, newFirstName, newLastName, newAddress, newBirthday));
    }
}