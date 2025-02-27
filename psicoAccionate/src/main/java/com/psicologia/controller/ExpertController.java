package com.psicologia.controller;

import com.psicologia.dto.ExpertDTO;
import com.psicologia.exception.ResourceNotFoundException;
import com.psicologia.model.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.psicologia.service.ExpertService;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/experts")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @GetMapping
    public List<Expert> getAllexperts() {
        return expertService.getAllExperts();
    }

    @GetMapping("/{id}")
    public Expert findExpertById(@PathVariable Long id) throws ResourceNotFoundException{
       Expert expert = expertService.findById(id);
       if(expert == null){
           throw new ResourceNotFoundException("Expert not found with id: " + id);
       }
        return expert;
    }

    @PostMapping
    public Expert saveExpert(@RequestBody Expert expertDTO) throws ResourceNotFoundException{
        return expertService.saveExpert(expertDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteByIdexpert (@PathVariable("id") Long id ){ return expertService.deleteByIdExpert(id);
    }

    @PutMapping
    public Expert updateExpert(@PathVariable Long id, @RequestBody ExpertDTO expertDTO) throws  ResourceNotFoundException{
        return expertService.updateExpert(id, expertDTO);
    }
}
