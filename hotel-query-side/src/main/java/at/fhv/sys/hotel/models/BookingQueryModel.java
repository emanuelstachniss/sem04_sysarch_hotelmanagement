package at.fhv.sys.hotel.models;


import at.fhv.sys.hotel.dto.BookingDTO;
import at.fhv.sys.hotel.dto.CustomerDTO;
import at.fhv.sys.hotel.dto.RoomDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class BookingQueryModel {

    @Id
    private UUID bookingId;
    private UUID customerId;
    private int roomNumber;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;

    public BookingQueryModel() {}

    public BookingQueryModel(UUID bookingId, UUID customerId, int roomNumber, LocalDate bookingStartDate, LocalDate bookingEndDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.roomNumber = roomNumber;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public BookingDTO toDTO(CustomerDTO customerDTO) {
        return new BookingDTO(bookingId, customerDTO, this.roomNumber, this.bookingStartDate, this.bookingEndDate);
    }
}
