package at.fhv.sys.hotel.commands;

public record BookRoomCommand(
        String startTime,
        String endTime,
        int roomNumber,
        int customerId
) {
}