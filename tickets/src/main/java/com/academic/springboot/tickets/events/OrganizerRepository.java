package com.academic.springboot.tickets.events;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OrganizerRepository {

    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Globalmantics", "Globalmantics Tech Corp"),
            new Organizer(102, "Carved Rock", "Carved Rock Sports Eqpmt"));

    public List<Organizer> findAll() {
        return organizers;
    }

}
