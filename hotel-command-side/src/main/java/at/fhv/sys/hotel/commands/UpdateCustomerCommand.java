package at.fhv.sys.hotel.commands;

import java.time.LocalDate;

public record UpdateCustomerCommand(
        String firstName,
        String lastName,
        String newFirstName,
        String newLastName,
        String newAddress,
        LocalDate newBirthday
) {
}
