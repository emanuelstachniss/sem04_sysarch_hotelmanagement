package at.fhv.sys.hotel.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {

    private UUID customerId;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate birthday;

    private Customer (Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.birthday = builder.birthday;
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

    public static Builder builder() {
        return new Builder();
    }

    public static Builder from(Customer existing) {
        Builder builder = new Builder();
        builder.customerId = existing.getCustomerId();
        builder.firstName = existing.getFirstName();
        builder.lastName = existing.getLastName();
        builder.address = existing.getAddress();
        builder.birthday = existing.getBirthday();
        return builder;
    }

    public static class Builder {
        private UUID customerId = UUID.randomUUID();
        private String firstName;
        private String lastName;
        private String address;
        private LocalDate birthday;


        public Builder customerId(UUID id) {
            this.customerId = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Customer build() {
            validate();
            return new Customer(this);
        }

        private void validate() {
            if (firstName == null || lastName == null || address == null || birthday == null) throw new IllegalArgumentException();
        }
    }
}
