package com.academic.springboot.tickets.registrations;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document("registrations")
public record Registration(
        @Id String id,
        @NotNull(message = "Product id is required") Integer productId,
        String eventName,
        BigDecimal amount,
        String ticketCode,
        @NotBlank(message = "Attendee name is required") String attendeeName) {
}
