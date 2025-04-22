package at.fhv.sys.hotel.query.controller;

import at.fhv.sys.hotel.dto.BookingDTO;
import at.fhv.sys.hotel.dto.CustomerDTO;
import at.fhv.sys.hotel.models.BookingQueryModel;
import at.fhv.sys.hotel.models.CustomerQueryModel;
import at.fhv.sys.hotel.projection.BookingProjection;
import at.fhv.sys.hotel.service.BookingService;
import at.fhv.sys.hotel.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingQueryController {

    @Inject
    BookingService bookingService;

    @Inject
    CustomerService customerService;


    public BookingQueryController() {}

    @GET
    @Path("/getBookings")
    public List<BookingDTO> getBookings(@QueryParam("bookingStartDate") LocalDate bookingStartDate,
                                        @QueryParam("bookingEndDate") LocalDate bookingEndDate) {
        List<BookingQueryModel> bookings = bookingService.getBookings(bookingStartDate, bookingEndDate);
        List<BookingDTO> bookingDTOs = new ArrayList<>();

        for (BookingQueryModel booking : bookings) {
            CustomerDTO customerDTO = customerService.getCustomerById(booking.getCustomerId()).toDTO();
            bookingDTOs.add(booking.toDTO(customerDTO));
        }

        return bookingDTOs;
    }
}

