package com.psicologia.service;

import com.psicologia.dto.ExpertDTO;
import com.psicologia.exception.ResourceNotFoundException;
import com.psicologia.model.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.psicologia.repository.IExpertRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpertService {
    @Autowired
    private IExpertRepository iExpertRepository;

    public List<Expert> getAllExperts() {
        return iExpertRepository.findAll();
    }

    public Expert saveExpert(Expert expert) {
        if(expert == null){
            throw new ResourceNotFoundException("Expert cannot be null");
        }

        return iExpertRepository.save(expert);
    }

    public Expert findById(Long id) throws ResourceNotFoundException{
        Expert expert = iExpertRepository.findById(id).orElse(null);
        if (expert== null){
            throw new ResourceNotFoundException("Expert not found with id: " + id);
        }
        return expert;

    }

    public String deleteByIdExpert(Long id) {
        Optional<Expert> expertOptional = this.iExpertRepository.findById(id);

        if (!expertOptional.isPresent()) {
            throw new ResourceNotFoundException("There is no registered expert with the id: " + id);
        }

        iExpertRepository.delete(expertOptional.get());
        return "The expert registered with the id was successfully deleted: " + id;
    }

    public Expert updateExpert(Long id, ExpertDTO expertDTO) throws ResourceNotFoundException{
        Expert existingExpert = iExpertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expert not found with id: " + id));
        if (expertDTO != null) {
            Optional<Expert> expertOptional = iExpertRepository.findById(expertDTO.getId());
            if (expertOptional.isPresent()) {
                Expert expert = expertOptional.get();
                expert.setId(expertDTO.getId());
              return iExpertRepository.save(existingExpert);

            }

        }

        throw new ResourceNotFoundException("the expert does not exist");
    }
}



