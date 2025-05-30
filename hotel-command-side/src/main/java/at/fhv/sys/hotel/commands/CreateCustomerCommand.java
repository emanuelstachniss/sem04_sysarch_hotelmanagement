package at.fhv.sys.hotel.commands;

import java.time.LocalDate;

public record CreateCustomerCommand(
        String firstName,
        String lastName,
        String address,
        LocalDate birthday
) {
}
