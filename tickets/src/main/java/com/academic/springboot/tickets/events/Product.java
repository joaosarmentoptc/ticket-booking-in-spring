package com.academic.springboot.tickets.events;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @OneToOne(cascade = CascadeType.REMOVE)
        @JoinColumn(name = "event_id", referencedColumnName = "id")
        private Event event;

        @Column(nullable = false)
        private String name;

        @Column
        private String description;

        @Column(nullable = false)
        private BigDecimal price;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public Event getEvent() {
                return event;
        }

        public void setEvent(Event event) {
                this.event = event;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public void setPrice(BigDecimal price) {
                this.price = price;
        }
}