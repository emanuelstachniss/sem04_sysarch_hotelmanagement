package at.fhv.sys.hotel.commands;

import java.time.LocalDate;

public record BookRoomCommand(
        String startTime,
        String endTime,
        int roomNumber,
        int capacity,
        String lastname,
        String firstname
) {
}
