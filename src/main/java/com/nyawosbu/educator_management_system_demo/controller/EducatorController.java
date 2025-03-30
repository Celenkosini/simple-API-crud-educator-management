package com.nyawosbu.educator_management_system_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyawosbu.educator_management_system_demo.model.Educator;
import com.nyawosbu.educator_management_system_demo.service.EducatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/Educator")
public class EducatorController {
    
    EducatorService service;

    public EducatorController(EducatorService service) {
        this.service = service;
    }

    @PostMapping
    public String createEducator(@RequestBody Educator educator) {
        //TODO: process POST request
        service.createEducator(educator);
        return "educator created successfully";
    }

    @GetMapping
    public List<Educator> getAllEducators() {
        return service.getAllEducators();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Educator> geteducatorByID(@PathVariable long id) {
        Optional<Educator> educator = service.getEducatorByID(id);
        return educator.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Educator> updateEducator(@PathVariable Long id, @RequestBody Educator educator) {
        //TODO: process PUT request
        Optional<Educator> existingEducator = service.getEducatorByID(id);
        if (existingEducator.isPresent()) {  
            educator.setId(id);
            Educator updateEducator = service.createEducator(educator);
            return ResponseEntity.ok(updateEducator);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public String deleteEducator(@PathVariable Long id){
        service.deleteEducator(id);
        return "educator deleted successfully";
    }
    
}
