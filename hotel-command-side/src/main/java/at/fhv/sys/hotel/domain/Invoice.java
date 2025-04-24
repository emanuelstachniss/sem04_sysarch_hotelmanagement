package at.fhv.sys.hotel.domain;

import at.fhv.sys.hotel.commands.shared.events.PaymentMethod;

import java.time.LocalDateTime;
import java.util.UUID;

public class Invoice {

    private UUID invoiceId;
    private Booking booking;
    private PaymentMethod paymentMethod;
    private LocalDateTime paymentDate;
    private Double amount;

    private Invoice(Builder builder) {
        this.invoiceId = builder.invoiceId;
        this.booking = builder.booking;
        this.paymentMethod = builder.paymentMethod;
        this.paymentDate = builder.paymentDate;
        this.amount = builder.amount;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }

    public Booking getBooking() {
        return booking;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID invoiceId = UUID.randomUUID();
        private Booking booking;
        private PaymentMethod paymentMethod;
        private LocalDateTime paymentDate;
        private Double amount;

        public Builder booking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder paymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder paymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Invoice build() {
            validate();
            return new Invoice(this);
        }

        private void validate() {
            if (booking == null | paymentMethod == null)
                throw new IllegalArgumentException();
        }
    }
}
