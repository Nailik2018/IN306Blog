package ch.hftm;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitialization {

    @Transactional
    public void init(@Observes StartupEvent event) {
//         Initialize Data only if there is no Data around
//        if (Entry.count() < 1) {
            // ... here you can create and persist your entities
//        }
    }
}