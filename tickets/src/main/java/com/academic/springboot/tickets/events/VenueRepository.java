package com.academic.springboot.tickets.events;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class VenueRepository {
    private final List<Venue> venues = List.of(
            new Venue(201, "Globalmantics Main Office", "Test Street 123", "New York", "USA"),
            new Venue(202, "Sea View Hotel", "Beach Boulevard 69", "Los Angeles", "USA"));

    public Optional<Venue> findById(int id) {
        return venues.stream().filter(venue -> venue.id() == id).findAny();
    }
}
