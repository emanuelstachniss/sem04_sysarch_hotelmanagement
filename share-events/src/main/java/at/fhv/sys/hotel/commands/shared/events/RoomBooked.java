package at.fhv.sys.hotel.commands.shared.events;

import java.time.LocalDate;
import java.util.UUID;

public class RoomBooked {

    private UUID bookingId;
    private UUID customerId;
    private LocalDate startTime;
    private LocalDate endTime;
    private int roomNumber;
    private int capacity;

    public RoomBooked() {}

    public RoomBooked(UUID bookingId, UUID customerId, LocalDate startTime, LocalDate endTime, int roomNumber, int capacity) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "RoomBooked{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                '}';
    }
}
