package at.fhv.sys.hotel.commands.shared.events;

import java.time.LocalDate;
import java.util.UUID;

public class CustomerUpdated {

    private UUID customerId;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate birthday;

    public CustomerUpdated() {}

    public CustomerUpdated(UUID customerId, String firstName, String lastName, String address, LocalDate birthday) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
