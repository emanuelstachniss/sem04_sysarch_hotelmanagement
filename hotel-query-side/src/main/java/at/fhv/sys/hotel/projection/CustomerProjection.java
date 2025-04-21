package at.fhv.sys.hotel.projection;

import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.service.CustomerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class CustomerProjection {

    @Inject
    CustomerService customerService;

    public List<CustomerQueryModel> getCustomersByLastName(String lastName) {
        return customerService.getCustomersByLastName(lastName);
    }

    public List<CustomerQueryModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void processCustomerCreatedEvent(CustomerCreated customerCreatedEvent) {
        Logger.getAnonymousLogger().info("Processing event: " + customerCreatedEvent);

        customerService.createCustomer(new CustomerQueryModel(customerCreatedEvent.getCustomerId(), customerCreatedEvent.getFirstName(), customerCreatedEvent.getLastName(), customerCreatedEvent.getAddress(), customerCreatedEvent.getBirthday()));
    }
}
