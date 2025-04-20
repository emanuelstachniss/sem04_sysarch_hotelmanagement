package at.fhv.sys.hotel.commands;

import at.fhv.sys.hotel.client.EventBusClient;
import at.fhv.sys.hotel.commands.shared.events.RoomBooked;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.logging.Logger;

@ApplicationScoped
public class RoomAggregate {

    @Inject
    @RestClient
    EventBusClient eventClient;

    public int handle(BookRoomCommand command) {
        RoomBooked event = new RoomBooked(command.startTime(), command.endTime(), command.roomNumber(), command.customerId());

        Logger.getAnonymousLogger().info(eventClient.processRoomBookedEvent(event).toString());

        return command.roomNumber();
    }

}