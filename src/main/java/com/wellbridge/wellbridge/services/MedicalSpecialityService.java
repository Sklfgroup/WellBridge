package com.wellbridge.wellbridge.services;

import com.wellbridge.wellbridge.dao.entities.patient.MedicalSpeciality;
import com.wellbridge.wellbridge.rest.dto.requests.patient.MedicalSpecialityRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalSpecialityResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MedicalSpecialityService {
    MedicalSpecialityResponseDTO createMedicalSpeciality(MedicalSpecialityRequestDTO medicalSpecialityRequestDTO);
    List<MedicalSpecialityResponseDTO> getAllMedicalSpecialities();
    Optional<MedicalSpecialityResponseDTO> getMedicalSpecialityById(Long id);
    MedicalSpecialityResponseDTO updateMedicalSpeciality(Long id, MedicalSpecialityRequestDTO medicalSpecialityRequestDTO);
    void associateSpecialityToAllMedicalRecords(Long specialityId);
    void deleteMedicalSpeciality(Long id);
}