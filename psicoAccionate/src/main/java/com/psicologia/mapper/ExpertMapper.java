package com.psicologia.mapper;

import com.psicologia.dto.ExpertDTO;
import com.psicologia.model.Expert;
import org.springframework.stereotype.Component;

@Component
public class ExpertMapper {

    public Expert mapToEntity(ExpertDTO expertDTO){
        if (expertDTO == null){
            return null;
        }
        Expert expertEntity = new Expert();
        expertEntity.setId(expertDTO.getId());
        expertEntity.setName(expertDTO.getName());
        expertEntity.setLastname(expertDTO.getLastname());
        expertEntity.setEmail(expertDTO.getEmail());
        expertEntity.setBirthdate(expertDTO.getBirthdate());
        expertEntity.setDocumentType(expertDTO.getDocumentType());
        expertEntity.setDocument(expertDTO.getDocument());
        expertEntity.setCountry(expertDTO.getCountry());
        expertEntity.setCity(expertDTO.getCity());
        expertEntity.setZipcode(expertDTO.getZipcode());
        expertEntity.setAddress(expertDTO.getAddress());
        expertEntity.setPhone(expertDTO.getPhone());
        expertEntity.setGender(expertDTO.getGender());
        expertEntity.setArea(expertDTO.getArea());
        expertEntity.setProfession(expertDTO.getProfession());
        expertEntity.setStatus(expertDTO.isStatus());
        return expertEntity;
    }

    public ExpertDTO mapToDTO(Expert expert){
        if (expert == null){
            return null;
        }

        ExpertDTO expertDTO = new ExpertDTO();
        expertDTO.setId(expert.getId());
        expertDTO.setName(expert.getName());
        expertDTO.setLastname(expert.getLastname());
        expertDTO.setEmail(expert.getEmail());
        expertDTO.setBirthdate(expert.getBirthdate());
        expertDTO.setDocumentType(expert.getDocumentType());
        expertDTO.setDocument(expert.getDocument());
        expertDTO.setCountry(expert.getCountry());
        expertDTO.setCity(expert.getCity());
        expertDTO.setZipcode(expert.getZipcode());
        expertDTO.setAddress(expert.getAddress());
        expertDTO.setPhone(expert.getPhone());
        expertDTO.setGender(expert.getGender());
        expertDTO.setArea(expert.getArea());
        expertDTO.setProfession(expert.getProfession());
        expertDTO.setStatus(expert.isStatus());
        return expertDTO;

    }


}
