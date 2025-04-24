package at.fhv.sys.hotel.persistence;

import at.fhv.sys.hotel.domain.Invoice;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class InvoiceRepository {

    private List<Invoice> invoices = new ArrayList<>();

    public void save(Invoice invoice) {
        invoices.add(invoice);
    }

    public Invoice findById(UUID invoiceId) {
        return invoices.stream()
                .filter(c -> c.getInvoiceId().equals(invoiceId))
                .findFirst()
                .orElse(null);
    }
}
