package com.academic.springboot.tickets.events;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final List<Product> products = List.of(
            new Product(801, 501, "Standard", "Standard Conference Ticket", new BigDecimal(499.00)),
            new Product(802, 501, "Premium", "Premium Conference Ticket", new BigDecimal(899.00)),
            new Product(803, 503, "Standard", "Premium Conference Ticket", new BigDecimal(399.00)),
            new Product(804, 503, "Premium", "Premium Conference Ticket", new BigDecimal(699.00)));

    public List<Product> findByEventId(int eventId) {
        return products.stream().filter(product -> product.eventId() == eventId).toList();
    }

}
