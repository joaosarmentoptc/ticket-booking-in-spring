package com.academic.springboot.tickets.events;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {
    private final List<Event> events = List.of(
            new Event(501, "Globalmantics Tech Conference",
                    new Organizer(101, "Globalmantics", "Globalmantics Tech Corp"),
                    new Venue(201, "Globalmantics Main Office", "Test Street 123", "New York", "USA"),
                    LocalDate.of(2024, 06, 01), LocalDate.of(2024, 06, 02)),

            new Event(503, "Globalmantics Tech Conference",
                    new Organizer(102, "Carved Rock", "Carved Rock Sports Eqpmt"),
                    new Venue(202, "Sea View Hotel", "Beach Boulevard 69", "Los Angeles", "USA"),
                    LocalDate.of(2024, 06, 10), LocalDate.of(2024, 06, 22)));

    public List<Event> findByOrganizerId(int organizerId) {
        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(event -> event.id() == id).findAny();
    }
}
