package com.wellbridge.wellbridge.services.impl;


import com.wellbridge.wellbridge.dao.entities.patient.DossierMedical;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalSpeciality;
import com.wellbridge.wellbridge.dao.entities.repository.DossierMedicalRepository;
import com.wellbridge.wellbridge.dao.entities.repository.MedicalSpecialityRepository;
import com.wellbridge.wellbridge.rest.dto.requests.patient.MedicalSpecialityRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalSpecialityResponseDTO;
import com.wellbridge.wellbridge.services.MedicalSpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicalSpecialityServiceImpl implements MedicalSpecialityService {

    @Autowired
    private MedicalSpecialityRepository medicalSpecialityRepository;
    @Autowired
    private DossierMedicalRepository dossierMedicalRepository;


    private MedicalSpecialityResponseDTO convertToDTO(MedicalSpeciality medicalSpeciality) {
        MedicalSpecialityResponseDTO dto = new MedicalSpecialityResponseDTO();
        dto.setId(medicalSpeciality.getId());
        dto.setName(medicalSpeciality.getName());
        return dto;
    }

    private MedicalSpeciality convertToEntity(MedicalSpecialityRequestDTO dto) {
        MedicalSpeciality entity = new MedicalSpeciality();
        entity.setName(dto.getName());
        return entity;
    }


    @Override
    public MedicalSpecialityResponseDTO createMedicalSpeciality(MedicalSpecialityRequestDTO medicalSpecialityRequestDTO) {
        String specialityName = medicalSpecialityRequestDTO.getName();
        Optional<MedicalSpeciality> existingSpecialityOptional = medicalSpecialityRepository.findByName(specialityName);
        if (existingSpecialityOptional.isPresent()) {
            throw new IllegalArgumentException("The spécialities exist in the BD");
        }
        MedicalSpeciality medicalSpeciality = convertToEntity(medicalSpecialityRequestDTO);
        return convertToDTO(medicalSpecialityRepository.save(medicalSpeciality));
    }

    @Override
    public List<MedicalSpecialityResponseDTO> getAllMedicalSpecialities() {
        return medicalSpecialityRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MedicalSpecialityResponseDTO> getMedicalSpecialityById(Long id) {
        return medicalSpecialityRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public MedicalSpecialityResponseDTO updateMedicalSpeciality(Long id, MedicalSpecialityRequestDTO medicalSpecialityRequestDTO) {
        MedicalSpeciality medicalSpeciality = medicalSpecialityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Speciality not found"));

        medicalSpeciality.setName(medicalSpecialityRequestDTO.getName());
        return convertToDTO(medicalSpecialityRepository.save(medicalSpeciality));
    }

    @Override
    public void deleteMedicalSpeciality(Long id) {
        medicalSpecialityRepository.deleteById(id);
    }

    @Override
    public void associateSpecialityToAllMedicalRecords(Long specialityId) {
        Optional<MedicalSpeciality> specialityOptional = medicalSpecialityRepository.findById(specialityId);
        if (specialityOptional.isPresent()) {
            MedicalSpeciality speciality = specialityOptional.get();
            List<DossierMedical> allMedicalRecords = dossierMedicalRepository.findAll();
            allMedicalRecords.forEach(record -> {
                record.getMedicalSpecialities().add(speciality);
                dossierMedicalRepository.save(record);
            });
        } else {
            throw new IllegalArgumentException("Speciality not found");
        }
    }


}