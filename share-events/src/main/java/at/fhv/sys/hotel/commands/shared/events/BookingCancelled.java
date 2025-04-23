package at.fhv.sys.hotel.commands.shared.events;

import java.util.UUID;

public record BookingCancelled(
        UUID bookingId
) {}
