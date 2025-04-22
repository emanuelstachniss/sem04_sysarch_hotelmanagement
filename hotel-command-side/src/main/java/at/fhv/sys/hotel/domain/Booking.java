package at.fhv.sys.hotel.domain;

import java.time.LocalDate;

public class Booking {

    private Customer customer;
    private Room room;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;

    public Booking(Builder builder) {
        this.customer = builder.customer;
        this.room = builder.room;
        this.bookingStartDate = builder.bookingStartDate;
        this.bookingEndDate = builder.bookingEndDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getBookingStartDate() {
        return bookingStartDate;
    }

    public LocalDate getBookingEndDate() {
        return bookingEndDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Customer customer;
        private Room room;
        private LocalDate bookingStartDate;
        private LocalDate bookingEndDate;

        public Booking.Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Booking.Builder room(Room room) {
            this.room = room;
            return this;
        }

        public Booking.Builder bookingStartDate(LocalDate bookingStartDate) {
            this.bookingStartDate = bookingStartDate;
            return this;
        }

        public Booking.Builder bookingEndDate(LocalDate bookingEndDate) {
            this.bookingEndDate = bookingEndDate;
            return this;
        }

        public Booking build() {
            validate();
            return new Booking(this);
        }

        private void validate() {
            if (customer == null || room == null || bookingStartDate == null || bookingEndDate == null
                    || bookingEndDate.isBefore(bookingStartDate)
                    || bookingStartDate.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Invalid booking parameters");
            }
        }

    }
}
