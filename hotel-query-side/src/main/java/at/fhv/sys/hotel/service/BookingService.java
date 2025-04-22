package at.fhv.sys.hotel.service;

import at.fhv.sys.hotel.models.BookingQueryModel;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.projection.BookingProjection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class BookingService {

    @PersistenceContext
    EntityManager entityManager;

    public List<BookingQueryModel> getBookings(LocalDate bookingStartDate, LocalDate bookingEndDate) {
        return entityManager.createQuery(
                        "SELECT b FROM BookingQueryModel b WHERE b.bookingStartDate >= :startDate AND b.bookingEndDate <= :endDate",
                        BookingQueryModel.class)
                .setParameter("startDate", bookingStartDate)
                .setParameter("endDate", bookingEndDate)
                .getResultList();
    }


    @Transactional
    public void createBooking(BookingQueryModel booking) {
        entityManager.persist(booking);
    }
}
