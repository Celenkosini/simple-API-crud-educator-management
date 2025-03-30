package com.nyawosbu.educator_management_system_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nyawosbu.educator_management_system_demo.model.Educator;
import com.nyawosbu.educator_management_system_demo.repository.EducatorRepository;

@Service
public class EducatorService {

    EducatorRepository educatorRepository;

    public EducatorService(EducatorRepository educatorRepository) {
        this.educatorRepository = educatorRepository;
    }
    
    //create educator
    public Educator createEducator(Educator educator){
        return educatorRepository.save(educator);
    }

    //get list of educators
    public List<Educator> getAllEducators(){
        return educatorRepository.findAll();
    }

    //get educator by id
    public Optional<Educator> getEducatorByID(Long id){
        return educatorRepository.findById(id);
    }


    //delete educator
    public String deleteEducator(Long id){
        educatorRepository.deleteById(id);
        return"educator deleted successfully";
    }


}
