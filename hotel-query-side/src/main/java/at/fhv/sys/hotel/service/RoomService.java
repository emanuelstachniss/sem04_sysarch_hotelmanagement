package at.fhv.sys.hotel.service;

import at.fhv.sys.hotel.dto.RoomDTO;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.models.RoomQueryModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RoomService {

    @PersistenceContext
    EntityManager entityManager;

    public List<RoomQueryModel> getAllRooms() {
        return entityManager.createQuery("SELECT r FROM RoomQueryModel r", RoomQueryModel.class)
                .getResultList();
    }


    @Transactional
    public void createRoom(RoomQueryModel room) {
        entityManager.persist(room);
    }
}

