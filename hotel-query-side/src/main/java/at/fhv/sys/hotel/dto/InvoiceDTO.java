package at.fhv.sys.hotel.dto;

import at.fhv.sys.hotel.commands.shared.events.PaymentMethod;

import java.time.LocalDateTime;
import java.util.UUID;

public record InvoiceDTO(
        UUID invoiceId,
        UUID bookingId,
        PaymentMethod paymentMethod,
        LocalDateTime paymentDate,
        Double amount
) {
}
