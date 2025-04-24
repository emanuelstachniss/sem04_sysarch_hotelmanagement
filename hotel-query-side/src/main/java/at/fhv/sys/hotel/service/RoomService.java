package at.fhv.sys.hotel.service;

import at.fhv.sys.hotel.dto.RoomDTO;
import at.fhv.sys.hotel.models.BookingQueryModel;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.models.RoomQueryModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class RoomService {

    @PersistenceContext
    EntityManager entityManager;

    public List<RoomQueryModel> getAllRooms() {
        return entityManager.createQuery("SELECT r FROM RoomQueryModel r", RoomQueryModel.class)
                .getResultList();
    }

    public List<RoomQueryModel> getFreeRooms(LocalDate startDate, LocalDate endDate, int numberOfPersons, List<BookingQueryModel> bookings) {
        List<RoomQueryModel> allRooms = getAllRooms();

        List<RoomQueryModel> suitableRooms = allRooms.stream()
                .filter(room -> room.getCapacity() >= numberOfPersons)
                .collect(Collectors.toList());

        List<UUID> bookedRoomIds = bookings.stream()
                .filter(b -> b.getBookingStartDate().isBefore(endDate) && b.getBookingEndDate().isAfter(startDate))
                .map(BookingQueryModel::getRoomNumber)
                .map(roomNumber -> suitableRooms.stream()
                        .filter(r -> r.getRoomNumber() == roomNumber)
                        .map(RoomQueryModel::getRoomId)
                        .findFirst()
                        .orElse(null))
                .filter(id -> id != null)
                .collect(Collectors.toList());

        return suitableRooms.stream()
                .filter(room -> !bookedRoomIds.contains(room.getRoomId()))
                .collect(Collectors.toList());
    }


    @Transactional
    public void createRoom(RoomQueryModel room) {
        entityManager.persist(room);
    }
}

