package at.fhv.sys.hotel.models;

import at.fhv.sys.hotel.commands.shared.events.PaymentMethod;
import at.fhv.sys.hotel.dto.InvoiceDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class InvoiceQueryModel {

    @Id
    private UUID invoiceId;
    private UUID bookingId;
    private PaymentMethod paymentMethod;
    private LocalDateTime paymentDate;
    private Double amount;

    public InvoiceQueryModel() {

    }

    public InvoiceQueryModel(UUID invoiceId, UUID bookingId, PaymentMethod paymentMethod, LocalDateTime paymentDate, Double amount) {
        this.invoiceId = invoiceId;
        this.bookingId = bookingId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public InvoiceDTO toDTO() {
        return new InvoiceDTO(this.invoiceId, this.bookingId, this.paymentMethod, this.paymentDate, this.amount);
    }
}
