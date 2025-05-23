package com.nyawosbu.educator_management_system_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyawosbu.educator_management_system_demo.model.Educator;

@Repository
public interface EducatorRepository extends JpaRepository <Educator,Long> {
    
}
/*
 * EducatorRepository provides CRUD operations for Educator entities.
 * Extend this interface with custom query methods as needed.
 */