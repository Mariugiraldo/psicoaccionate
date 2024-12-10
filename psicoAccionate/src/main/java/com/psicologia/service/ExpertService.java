package com.psicologia.service;

import com.psicologia.model.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.psicologia.repository.IExpertRepository;

import java.util.List;

@Service
public class ExpertService {
    @Autowired
    private IExpertRepository iExpertRepository;

    public List<Expert> getAllExperts() {
        return iExpertRepository.findAll();
    }

    public Expert saveExpert(Expert expert) {
        return iExpertRepository.save(expert);
    }

}
