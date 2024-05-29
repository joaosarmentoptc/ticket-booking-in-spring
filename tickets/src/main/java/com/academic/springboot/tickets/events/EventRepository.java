package com.academic.springboot.tickets.events;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOrganizerId(int organizerId);

}
