package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.commands.shared.events.PaymentMethod;

import java.util.UUID;

public record PayBookingCommand(
        UUID bookingId,
        PaymentMethod paymentMethod
) {
}
