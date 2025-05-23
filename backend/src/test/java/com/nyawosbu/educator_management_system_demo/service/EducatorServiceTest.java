package com.nyawosbu.educator_management_system_demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nyawosbu.educator_management_system_demo.model.Educator;
import com.nyawosbu.educator_management_system_demo.repository.EducatorRepository;

class EducatorServiceTest {

    @Mock
    private EducatorRepository educatorRepository;

    @InjectMocks
    private EducatorService educatorService;

    private Educator educator1;
    private Educator educator2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        educator1 = new Educator(1L, "John", "Doe","email1", "Math");
        educator2 = new Educator(2L, "Jane", "Smith","email2","Science");
    }

    @Test
    void createEducator_shouldReturnSavedEducator() {
        when(educatorRepository.save(educator1)).thenReturn(educator1);
        Educator savedEducator = educatorService.createEducator(educator1);
        assertEquals(educator1, savedEducator);
        verify(educatorRepository, times(1)).save(educator1);
    }

    @Test
    void getAllEducators_shouldReturnListOfAllEducators() {
        List<Educator> educators = Arrays.asList(educator1, educator2);
        when(educatorRepository.findAll()).thenReturn(educators);
        List<Educator> allEducators = educatorService.getAllEducators();
        assertEquals(2, allEducators.size());
        assertEquals(educator1, allEducators.get(0));
        assertEquals(educator2, allEducators.get(1));
        verify(educatorRepository, times(1)).findAll();
    }

    @Test
    void getEducatorByID_shouldReturnEducatorIfExists() {
        when(educatorRepository.findById(1L)).thenReturn(Optional.of(educator1));
        Optional<Educator> foundEducator = educatorService.getEducatorByID(1L);
        assertTrue(foundEducator.isPresent());
        assertEquals(educator1, foundEducator.get());
        verify(educatorRepository, times(1)).findById(1L);
    }

    @Test
    void getEducatorByID_shouldReturnEmptyOptionalIfNotExists() {
        when(educatorRepository.findById(3L)).thenReturn(Optional.empty());
        Optional<Educator> foundEducator = educatorService.getEducatorByID(3L);
        assertTrue(foundEducator.isEmpty());
        verify(educatorRepository, times(1)).findById(3L);
    }

    @Test
    void deleteEducator_shouldDeleteEducatorAndReturnSuccessMessage() {
        doNothing().when(educatorRepository).deleteById(1L);
        String message = educatorService.deleteEducator(1L);
        assertEquals("Educator deleted successfully", message);
        verify(educatorRepository, times(1)).deleteById(1L);
    }
}