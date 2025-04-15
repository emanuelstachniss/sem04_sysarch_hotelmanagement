package at.fhv.sys.hotel.service;

import at.fhv.sys.hotel.models.CustomerQueryModel;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CustomerService {

    @PersistenceContext
    EntityManager entityManager;

    public List<CustomerQueryModel> getAllCustomers() {
        return entityManager.createQuery("SELECT c FROM CustomerQueryModel c", CustomerQueryModel.class).getResultList();
    }

    public CustomerQueryModel findById(String customerId) {
        return entityManager.find(CustomerQueryModel.class, customerId);
    }

    @Transactional
    public void createCustomer(CustomerQueryModel customer) {
        entityManager.persist(customer);
    }
}
