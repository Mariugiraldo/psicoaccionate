package com.psicologia.controller;

import com.psicologia.model.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.psicologia.service.ExpertService;
import java.util.List;

@RestController
@RequestMapping("/experts")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @GetMapping
    public List<Expert> getAllexperts() {
        return expertService.getAllExperts();
    }

    @PostMapping
    public Expert saveExpert(@RequestBody Expert expert) {
        return expertService.saveExpert(expert);
    }

}
