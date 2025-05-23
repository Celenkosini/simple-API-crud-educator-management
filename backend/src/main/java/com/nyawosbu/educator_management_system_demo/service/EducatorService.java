package com.nyawosbu.educator_management_system_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nyawosbu.educator_management_system_demo.model.Educator;
import com.nyawosbu.educator_management_system_demo.repository.EducatorRepository;

/**
 * Service class for managing Educator entities.
 */
@Service
public class EducatorService {

    private final EducatorRepository educatorRepository;

    /**
     * Constructor for dependency injection.
     * 
     * @param educatorRepository the educator repository
     */
    public EducatorService(EducatorRepository educatorRepository) {
        this.educatorRepository = educatorRepository;
    }

    /**
     * Creates a new educator.
     * 
     * @param educator the educator to create
     * @return the saved educator
     */
    public Educator createEducator(Educator educator) {
        return educatorRepository.save(educator);
    }

    /**
     * Retrieves all educators.
     * 
     * @return list of all educators
     */
    public List<Educator> getAllEducators() {
        return educatorRepository.findAll();
    }

    /**
     * Retrieves an educator by ID.
     * 
     * @param id the educator's ID
     * @return an Optional containing the educator if found, or empty otherwise
     */
    public Optional<Educator> getEducatorByID(Long id) {
        return educatorRepository.findById(id);
    }

    /**
     * Deletes an educator by ID.
     * 
     * @param id the educator's ID
     * @return a confirmation message
     */
    public String deleteEducator(Long id) {
        educatorRepository.deleteById(id);
        return "Educator deleted successfully";
    }
}
