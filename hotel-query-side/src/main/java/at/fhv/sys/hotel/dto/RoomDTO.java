package at.fhv.sys.hotel.dto;

public record RoomDTO (
    Integer roomNumber,
    Integer capacity,
    Double price,
    Boolean hasBalcony,
    String description
){}
