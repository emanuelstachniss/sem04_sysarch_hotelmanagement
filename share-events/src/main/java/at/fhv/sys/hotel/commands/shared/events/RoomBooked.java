package at.fhv.sys.hotel.commands.shared.events;

import java.time.LocalDate;
import java.util.UUID;

public class RoomBooked {
    private UUID customerId;
    private LocalDate startTime;
    private LocalDate endTime;
    private int roomNumber;
    private int capacity;

    public RoomBooked() {}

    public RoomBooked(UUID customerId, LocalDate startTime, LocalDate endTime, int roomNumber, int capacity) {
        this.customerId = customerId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "RoomBooked{" +
                "customerId=" + customerId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                '}';
    }
}
