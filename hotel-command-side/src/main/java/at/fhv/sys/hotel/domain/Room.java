package at.fhv.sys.hotel.domain;

public class Room {
    private Integer roomNumber;
    private Integer capacity;
    private Double price;
    private Boolean hasBalcony;
    private String description;

    private Room(Builder builder) {
        this.roomNumber = builder.roomNumber;
        this.capacity = builder.capacity;
        this.price = builder.price;
        this.hasBalcony = builder.hasBalcony;
        this.description = builder.description;
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

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public String getDescription() {
        return description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer roomNumber;
        private Integer capacity;
        private Double price;
        private Boolean hasBalcony;
        private String description;

        public Builder roomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder hasBalcony(boolean hasBalcony) {
            this.hasBalcony = hasBalcony;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Room build() {
            validate();
            return new Room(this);
        }

        private void validate() {
            if (roomNumber == null || capacity == null || price == null || hasBalcony == null || description == null) {
                throw new IllegalArgumentException("Room has invalid or missing values.");
            }
        }
    }
}
