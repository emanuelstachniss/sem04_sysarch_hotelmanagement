package at.fhv.sys.eventbus;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.event.Observes;
import org.jboss.logging.Logger;

@QuarkusMain
public class HotelEventBusApplication {
    void onStart(@Observes StartupEvent ev) {
        Logger.getLogger(HotelEventBusApplication.class).info("Starting Hotel Eventbus Application");
    }

    public static void main(String[] args) {
        Quarkus.run(args);
    }
}
