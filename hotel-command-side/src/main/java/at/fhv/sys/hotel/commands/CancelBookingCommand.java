package at.fhv.sys.hotel.commands;

import java.util.UUID;

public record CancelBookingCommand(UUID bookingId) {
}

