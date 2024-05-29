package com.academic.springboot.tickets.events;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByEventId(int eventId);

}
