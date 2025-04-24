package at.fhv.sys.hotel.commands.shared.events;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingPaid {
    private UUID invoiceId;
    private UUID bookingId;
    private PaymentMethod paymentMethod;
    private LocalDateTime paymentDate;
    private Double amount;

    public BookingPaid() {

    }

    public BookingPaid(UUID invoiceId, UUID bookingId, PaymentMethod paymentMethod, LocalDateTime paymentDate, Double amount) {
        this.invoiceId = invoiceId;
        this.bookingId = bookingId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }

    public UUID getBookingId() {
        return bookingId;
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
}
