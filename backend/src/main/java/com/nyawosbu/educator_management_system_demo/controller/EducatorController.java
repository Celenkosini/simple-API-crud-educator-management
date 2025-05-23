package com.nyawosbu.educator_management_system_demo.controller;

import com.nyawosbu.educator_management_system_demo.model.Educator;
import com.nyawosbu.educator_management_system_demo.service.EducatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Educator entities.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/educators")
public class EducatorController {

    private final EducatorService service;

    /**
     * Constructor for dependency injection of EducatorService.
     */
    @Autowired
    public EducatorController(EducatorService service) {
        this.service = service;
    }

    /**
     * Create a new Educator.
     *
     * @param educator the educator to create
     * @return ResponseEntity with created educator or bad request if ID is present
     */
    @PostMapping
    public ResponseEntity<Educator> createEducator(@RequestBody Educator educator) {
        // Prevent creation if educator already has an ID
        Educator createdEducator = service.createEducator(educator);
        if (createdEducator == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(URI.create("/educators/" + createdEducator.getId())).body(createdEducator);
    }

    /**
     * Get all educators.
     *
     * @return ResponseEntity with list of educators or no content if empty
     */
    @GetMapping
    public ResponseEntity<List<Educator>> getAllEducators() {
        List<Educator> educators = service.getAllEducators();
        if (educators.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(educators);
    }

    /**
     * Get an educator by ID.
     *
     * @param id the educator ID
     * @return ResponseEntity with educator or not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Educator> getEducatorById(@PathVariable Long id) {
        return service.getEducatorByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update an existing educator.
     *
     * @param id the educator ID
     * @param educator the educator data to update
     * @return ResponseEntity with updated educator or not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Educator> updateEducator(@PathVariable Long id, @RequestBody Educator educator) {
        Optional<Educator> existingEducator = service.getEducatorByID(id);
        if (existingEducator.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        educator.setId(id);
        Educator updated = service.createEducator(educator);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete an educator by ID.
     *
     * @param id the educator ID
     * @return ResponseEntity with no content or not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducator(@PathVariable Long id) {
        Optional<Educator> existingEducator = service.getEducatorByID(id);
        if (existingEducator.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteEducator(id);
        return ResponseEntity.noContent().build();
    }
}
