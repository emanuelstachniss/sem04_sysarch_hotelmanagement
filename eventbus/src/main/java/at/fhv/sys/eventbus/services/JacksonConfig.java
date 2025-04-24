package at.fhv.sys.eventbus.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class JacksonConfig {

    @Produces
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Registriere das JavaTimeModule, um Java 8 Zeittypen zu verarbeiten
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
