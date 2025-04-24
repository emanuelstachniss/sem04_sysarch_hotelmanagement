package at.fhv.sys.hotel.persistence;

import at.fhv.sys.hotel.domain.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    public void save(Customer customer) {
        customers.add(customer);
    }

    public Customer findByName(String firstName, String lastName) {
        return customers.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(firstName) &&
                        c.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
