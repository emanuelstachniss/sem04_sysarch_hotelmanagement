package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.domain.Customer;
import at.fhv.sys.hotel.persistence.CustomerRepository;

public record BookRoomCommand(
        String startTime,
        String endTime,
        int roomNumber,
        int capacity,
        String lastname,
        String firstname
) {
}