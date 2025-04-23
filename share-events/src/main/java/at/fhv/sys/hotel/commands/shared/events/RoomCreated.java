package at.fhv.sys.hotel.commands.shared.events;

import java.util.UUID;

public class RoomCreated {
    private UUID roomId;
    private Integer roomNumber;
    private Integer capacity;
    private Double price;
    private Boolean hasBalcony;
    private String description;

    public RoomCreated() {}

    public RoomCreated(UUID roomId, Integer roomNumber, Integer capacity, Double price, Boolean hasBalcony, String description) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.hasBalcony = hasBalcony;
        this.description = description;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getHasBalcony() {
        return hasBalcony;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "RoomCreated{" +
                "roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                ", price=" + price +
                ", hasBalcony=" + hasBalcony +
                ", description='" + description + '\'' +
                '}';
    }
}
