package com.academic.springboot.tickets.events;

import java.math.BigDecimal;

public record Product(
                int id,
                Event event,
                String name,
                String description,
                BigDecimal price) {
}