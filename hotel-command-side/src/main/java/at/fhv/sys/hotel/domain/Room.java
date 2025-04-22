package at.fhv.sys.hotel.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Room {
    private Integer roomNumber;
    private Integer capacity;

    private Room (Builder builder) {
        this.roomNumber = builder.roomNumber;
        this.capacity = builder.capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public static Room.Builder builder() {
        return new Room.Builder();
    }

    public static class Builder {
        private Integer roomNumber;
        private Integer capacity;

        public Room.Builder roomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Room.Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Room build() {
            validate();
            return new Room(this);
        }

        private void validate() {
            if (roomNumber == null || capacity == null) throw new IllegalArgumentException();
        }

    }
}
