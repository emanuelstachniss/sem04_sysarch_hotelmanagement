package at.fhv.sys.hotel.dto;

import java.time.LocalDate;

public record CustomerDTO(
        String firstName,
        String lastName,
        String address,
        LocalDate birthday
) {
}
