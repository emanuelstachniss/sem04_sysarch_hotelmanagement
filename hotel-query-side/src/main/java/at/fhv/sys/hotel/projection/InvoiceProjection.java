package at.fhv.sys.hotel.projection;

import at.fhv.sys.hotel.commands.shared.events.BookingPaid;
import at.fhv.sys.hotel.models.InvoiceQueryModel;
import at.fhv.sys.hotel.service.InvoiceService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.logging.Logger;

@ApplicationScoped
public class InvoiceProjection {

    @Inject
    InvoiceService invoiceService;

    public void processBookingPaidEvent(BookingPaid event) {
        Logger.getAnonymousLogger().info("Processing event: " + event);
        invoiceService.createInvoice(new InvoiceQueryModel(event.getInvoiceId(), event.getBookingId(), event.getPaymentMethod(), event.getPaymentDate(), event.getAmount()));
    }
}
