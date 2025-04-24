package at.fhv.sys.hotel.service;

import at.fhv.sys.hotel.models.InvoiceQueryModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InvoiceService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void createInvoice(InvoiceQueryModel invoice) {
        entityManager.persist(invoice);
    }
}
