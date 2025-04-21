package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.client.EventBusClient;
import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import at.fhv.sys.hotel.domain.Customer;
import at.fhv.sys.hotel.persistence.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.logging.Logger;

@ApplicationScoped
public class CustomerAggregate {

    @Inject
    @RestClient
    EventBusClient eventClient;

    @Inject
    CustomerRepository customerRepository;

    public String handle(CreateCustomerCommand command) {

        try {
            Customer customer = Customer.builder()
                    .firstName(command.firstName())
                    .lastName(command.lastName())
                    .address(command.address())
                    .birthday(command.birthday())
                    .build();

            customerRepository.save(customer);

            CustomerCreated event = new CustomerCreated(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getBirthday());

            Logger.getAnonymousLogger().info(eventClient.processCustomerCreatedEvent(event).toString());

        } catch (IllegalArgumentException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }

        return "Customer created";
    }

}
