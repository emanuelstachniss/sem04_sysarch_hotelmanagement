package at.fhv.sys.hotel.models;

import at.fhv.sys.hotel.dto.CustomerDTO;
import at.fhv.sys.hotel.dto.RoomDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class RoomQueryModel {

    @Id
    private UUID roomId;
    private int roomNumber;
    private int capacity;
    private double price;
    private boolean hasBalcony;
    private String description;

    public RoomQueryModel() {}

    public RoomQueryModel(UUID roomId, int roomNumber, int capacity, double price, boolean hasBalcony, String description) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.hasBalcony = hasBalcony;
        this.description = description;
    }

    public RoomDTO toDTO() {
        return new RoomDTO(this.roomNumber, this.capacity, this.price, this.hasBalcony, this.description);
    }

    public UUID getRoomId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public String getDescription() {
        return description;
    }
}
