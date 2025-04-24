package at.fhv.sys.hotel.service;

import at.fhv.sys.hotel.models.CustomerQueryModel;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CustomerService {

    @PersistenceContext
    EntityManager entityManager;

    public List<CustomerQueryModel> getAllCustomers() {
        return entityManager.createQuery("SELECT c FROM CustomerQueryModel c", CustomerQueryModel.class)
                .getResultList();
    }

    public List<CustomerQueryModel> getCustomersByLastName(String lastName) {
        return entityManager.createQuery("SELECT c FROM CustomerQueryModel c WHERE LOWER(c.lastName) LIKE :lastName", CustomerQueryModel.class)
                .setParameter("lastName", "%" + lastName.toLowerCase() + "%")
                .getResultList();
    }

    public CustomerQueryModel getCustomerById(UUID customerId) {
        return entityManager.find(CustomerQueryModel.class, customerId);
    }

    @Transactional
    public void createCustomer(CustomerQueryModel customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public void updateCustomer(CustomerQueryModel customer) {
        entityManager.merge(customer);
    }
}
