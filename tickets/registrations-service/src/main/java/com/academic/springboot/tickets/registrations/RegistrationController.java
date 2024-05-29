package com.academic.springboot.tickets.registrations;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.academic.springboot.tickets.events.Event;
import com.academic.springboot.tickets.events.EventsClient;
import com.academic.springboot.tickets.events.Product;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

        private final EventsClient eventsClient;
        private final RegistrationRepository registrationRepository;

        public RegistrationController(EventsClient eventsClient, RegistrationRepository registrationRepository) {
                this.eventsClient = eventsClient;
                this.registrationRepository = registrationRepository;
        }

        @PostMapping
        public Registration create(@RequestBody @Valid Registration registration) {
                Product product = eventsClient.getProductById(registration.productId());
                Event event = eventsClient.getEventById(product.event().id());

                String ticketCode = UUID.randomUUID().toString();

                return registrationRepository
                                .save(new Registration(null, registration.productId(), event.name(), product.price(),
                                                ticketCode,
                                                registration.attendeeName()));
        }

        @GetMapping(path = "/{ticketCode}")
        public Registration get(@PathVariable("ticketCode") String ticketCode) {
                return registrationRepository.findByTicketCode(ticketCode)
                                .orElseThrow(
                                                () -> new NoSuchElementException("Registration with ticketCode "
                                                                + ticketCode + " not found!"));
        }

        @PatchMapping
        public Registration update(@RequestBody Registration registration) {
                String ticketCode = registration.ticketCode();
                var existing = registrationRepository.findByTicketCode(ticketCode).orElseThrow(
                                () -> new NoSuchElementException(
                                                "Registration with ticket code " + ticketCode + " not found"));

                return registrationRepository
                                .save(new Registration(existing.id(), existing.productId(), null, null, ticketCode,
                                                registration.attendeeName()));

        }

        @DeleteMapping(path = "/{ticketCode}")
        public void delete(@PathVariable("ticketCode") String ticketCode) {
                registrationRepository.deleteByTicketCode(ticketCode);
        }

}
