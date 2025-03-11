package com.psicologia.service;

import com.psicologia.dto.ExpertDTO;
import com.psicologia.exception.ResourceNotFoundException;
import com.psicologia.mapper.ExpertMapper;
import com.psicologia.model.Expert;
import com.psicologia.repository.IExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpertService {

    private IExpertRepository iExpertRepository;
    private ExpertMapper expertMapper;

    @Autowired
    public ExpertService(IExpertRepository iExpertRepository, ExpertMapper expertMapper) {
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
        Expert expertEntity = expertMapper.mapToEntity(expertDTO); //Convertir DTO a entidad
        Expert savedExpert = iExpertRepository.save(expertEntity); //Guardar en bd

        return expertMapper.mapToDTO(savedExpert); //convertir la entidad a DTO y devolverla
    }

    public ExpertDTO findById(Long id) {
        Expert expert = iExpertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expert not found with id: " + id));
        return expertMapper.mapToDTO(expert); //convertir la entidad a DTO
    }

    public String deleteByIdExpert(Long id) {
        if (!iExpertRepository.existsById(id)) {
            throw new ResourceNotFoundException("There is no registered expert with the id: " + id);
        }
        iExpertRepository.deleteById(id);
        return "The expert with id " + id + " was successfully deleted.";
    }

    public ExpertDTO updateExpert(Long id, ExpertDTO expertDTO) {
        Expert expert = iExpertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The expert with ID " + id + " does not exist"));

        expert.setName(expertDTO.getName());
        expert.setLastname(expertDTO.getLastname());
        expert.setEmail(expertDTO.getEmail());
        expert.setBirthdate(expertDTO.getBirthdate());
        expert.setDocumentType(expertDTO.getDocumentType());
        expert.setDocument(expertDTO.getDocument());
        expert.setCountry(expertDTO.getCountry());
        expert.setCity(expertDTO.getCity());
        expert.setZipcode(expertDTO.getZipcode());
        expert.setAddress(expertDTO.getAddress());
        expert.setPhone(expertDTO.getPhone());
        expert.setGender(expertDTO.getGender());
        expert.setProfession(expertDTO.getProfession());
        expert.setArea(expertDTO.getArea());
        expert.setStatus(expertDTO.isStatus());

        Expert updateExpert = iExpertRepository.save(expert);

        return expertMapper.mapToDTO(updateExpert);

    }
}



