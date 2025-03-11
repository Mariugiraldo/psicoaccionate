package com.psicologia.controller;

import com.psicologia.dto.ExpertDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.psicologia.service.ExpertService;
import java.util.List;


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
    public ExpertDTO findExpertById(@PathVariable ("id") Long id) {
        return expertService.findById(id);}


    @PostMapping
    public ExpertDTO saveExpert(@Valid @RequestBody ExpertDTO expertDTO) {
        return expertService.saveExpert(expertDTO);
    }



    @DeleteMapping("/{id}")
    public String deleteByIdExpert (@PathVariable Long id ) {
        return expertService.deleteByIdExpert(id);
    }

    @PutMapping("/{id}")
    public ExpertDTO updateExpert(@PathVariable Long id, @RequestBody ExpertDTO expertDTO) {
        return expertService.updateExpert(id,expertDTO);
    }
}
