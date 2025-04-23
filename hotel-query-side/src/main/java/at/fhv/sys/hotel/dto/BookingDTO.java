package at.fhv.sys.hotel.dto;

import java.time.LocalDate;
import java.util.UUID;

public record BookingDTO(
        UUID bookingId,
        CustomerDTO customer,
        int roomNumber,
        LocalDate bookingStartDate,
        LocalDate bookingEndDate
) {
}
