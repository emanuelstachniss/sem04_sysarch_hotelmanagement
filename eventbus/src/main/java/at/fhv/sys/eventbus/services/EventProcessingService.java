package at.fhv.sys.eventbus.services;

import at.fhv.sys.eventbus.client.QueryClient;
import at.fhv.sys.hotel.commands.shared.events.CustomerCreated;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class EventProcessingService {

    @Inject
    @RestClient
    QueryClient queryClient;

    public EventProcessingService() {
    }

    public void processEvent(String stream, Object eventObject) {
        queryClient.forwardCustomerCreatedEvent((CustomerCreated) eventObject);
        // TBD process Events in EventDBStore
    }
}