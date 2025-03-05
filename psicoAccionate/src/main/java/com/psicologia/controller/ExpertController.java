package com.psicologia.controller;

import com.psicologia.dto.ExpertDTO;
import com.psicologia.exception.ResourceNotFoundException;
import com.psicologia.model.Expert;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ExpertController(ExpertService expertService){
        this.expertService = expertService;
    }

    @GetMapping
    public List<ExpertDTO> getAllexperts() {
        return expertService.getAllExperts();
    }

    @GetMapping("/{id}")
    public Expert findExpertById(@PathVariable ("id") Long id) {
        return expertService.findById(id);}


    @PostMapping
    public ExpertDTO saveExpert(@Valid @RequestBody ExpertDTO expertDTO) {
//        if (expertDTO == null){
//            throw new IllegalArgumentException("The expert's data cannot be null");
//        }
//        Expert expert = new Expert();

        return expertService.saveExpert(expertDTO);
    }



    @DeleteMapping("/{id}")
    public String deleteByIdexpert (@PathVariable("id") Long id ){
        return expertService.deleteByIdExpert(id);
    }

    @PutMapping
    public Expert updateExpert(@PathVariable Long id, @RequestBody ExpertDTO expertDTO) throws  ResourceNotFoundException{
        return expertService.updateExpert(id, expertDTO);
    }
}
