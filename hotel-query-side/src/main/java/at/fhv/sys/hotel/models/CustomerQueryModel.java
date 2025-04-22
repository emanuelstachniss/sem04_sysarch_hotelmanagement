package at.fhv.sys.hotel.models;

import at.fhv.sys.hotel.dto.CustomerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class CustomerQueryModel {

    @Id
    private UUID customerId;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate birthday;

    public CustomerQueryModel() {}

    public CustomerQueryModel(UUID customerId, String firstName, String lastName, String address, LocalDate birthday) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
    }

    public CustomerDTO toDTO() {
        return new CustomerDTO(this.firstName, this.lastName, this.address, this.birthday);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
}
