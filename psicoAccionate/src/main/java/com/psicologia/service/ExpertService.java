package com.psicologia.service;

import com.psicologia.dto.ExpertDTO;
import com.psicologia.exception.ResourceNotFoundException;
import com.psicologia.mapper.ExpertMapper;
import com.psicologia.model.Expert;
import com.psicologia.repository.IExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpertService {
    @Autowired
    private IExpertRepository iExpertRepository;
    private ExpertMapper expertMapper;

    public ExpertService(IExpertRepository iExpertRepository, ExpertMapper expertMapper){
        this.iExpertRepository = iExpertRepository;
        this.expertMapper = expertMapper;
    }

    public List<ExpertDTO> getAllExperts() {
        List<Expert> experts = iExpertRepository.findAll();
        return experts.stream()
                .map(expertMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public ExpertDTO saveExpert(ExpertDTO expertDTO) {
        if (expertDTO == null) {
            throw new ResourceNotFoundException("Expert cannot be null");
        }
        Expert expertEntity = expertMapper.mapToEntity(expertDTO);
        Expert savedExpert= iExpertRepository.save(expertEntity);

        return expertMapper.mapToDTO(savedExpert);
    }

    public Expert findById(Long id) {
        return iExpertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expert not found with id: " + id));
    }

    public String deleteByIdExpert(Long id) {
        Expert expert = iExpertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no registered expert with the id: " + id));

        iExpertRepository.delete(expert);
        return "The expert registered with the id was successfully deleted: " + id;
    }


    public Expert updateExpert(Long id, ExpertDTO expertDTO) {
        return iExpertRepository.findById(id)
                .map(existingExpert -> {
                    existingExpert.setProfession(expertDTO.getProfession());
                    existingExpert.setArea(expertDTO.getArea());
                    existingExpert.setStatus(expertDTO.isStatus());
                    return iExpertRepository.save(existingExpert);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Expert not found with id: " + id));
    }
}



