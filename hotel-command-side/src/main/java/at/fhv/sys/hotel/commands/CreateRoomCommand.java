package at.fhv.sys.hotel.commands;

public record CreateRoomCommand(
        int roomNumber,
        int capacity,
        Double price,
        Boolean hasBalcony,
        String description
) {
}
