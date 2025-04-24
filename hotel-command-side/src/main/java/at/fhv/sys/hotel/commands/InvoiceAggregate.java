package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.client.EventBusClient;
import at.fhv.sys.hotel.commands.shared.events.BookingPaid;
import at.fhv.sys.hotel.domain.Booking;
import at.fhv.sys.hotel.domain.Invoice;
import at.fhv.sys.hotel.persistence.BookingRepository;
import at.fhv.sys.hotel.persistence.InvoiceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@ApplicationScoped
public class InvoiceAggregate {

    @Inject
    @RestClient
    EventBusClient eventClient;

    @Inject
    InvoiceRepository invoiceRepository;

    @Inject
    BookingRepository bookingRepository;

    public Double calculateTotalAmount(Booking booking){
        Double pricePerDay = booking.getRoom().getPrice();
        Integer amountOfDays = booking.getBookingStartDate().until(booking.getBookingEndDate()).getDays();
        return pricePerDay * amountOfDays;
    }

    public String handle(PayBookingCommand command) {
        try {
            Booking booking = bookingRepository.findById(command.bookingId());
            Double amount = calculateTotalAmount(booking);

            Invoice invoice = Invoice.builder()
                    .booking(booking)
                    .paymentMethod(command.paymentMethod())
                    .paymentDate(LocalDateTime.now())
                    .amount(amount)
                    .build();

            invoiceRepository.save(invoice);

            BookingPaid event = new BookingPaid(invoice.getInvoiceId(), invoice.getBooking().getBookingId(), invoice.getPaymentMethod(), invoice.getPaymentDate(), invoice.getAmount());

            Logger.getAnonymousLogger().info(eventClient.processBookingPaidEvent(event).toString());

        } catch (Exception e) {
            Logger.getAnonymousLogger().info(e.getMessage());
            return "Booking failed: " + e.getMessage();
        }
        return "Booking paid";
    }
}