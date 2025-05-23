package com.nyawosbu.educator_management_system_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an educator in the system.
 * Stores basic information such as name, email, and specialization.
 */
@Entity
@Table(name = "educator")
@Data // Lombok: generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok: generates a no-args constructor
@AllArgsConstructor // Lombok: generates an all-args constructor
public class Educator {

    /**
     * Unique identifier for the educator.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Educator's first name.
     */
    private String firstName;

    /**
     * Educator's last name.
     */
    private String lastName;

    /**
     * Educator's email address.
     */
    private String email;

    /**
     * Educator's area of specialization.
     */
    private String specialization;
}
