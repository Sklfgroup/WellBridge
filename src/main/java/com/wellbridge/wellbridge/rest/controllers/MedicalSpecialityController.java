package com.wellbridge.wellbridge.rest.controllers;


import com.wellbridge.wellbridge.rest.api.MedicalSpecialityControllerApi;
import com.wellbridge.wellbridge.rest.dto.requests.patient.MedicalSpecialityRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalSpecialityResponseDTO;
import com.wellbridge.wellbridge.services.MedicalSpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-specialities")
public class MedicalSpecialityController implements MedicalSpecialityControllerApi {

    @Autowired
    private MedicalSpecialityService medicalSpecialityService;

    @Override
    @PreAuthorize("hasAuthority('SUPERADMINISTRATOR')")
    public ResponseEntity<MedicalSpecialityResponseDTO> createMedicalSpeciality(@RequestBody MedicalSpecialityRequestDTO medicalSpecialityRequestDTO) {
        MedicalSpecialityResponseDTO responseDTO = medicalSpecialityService.createMedicalSpeciality(medicalSpecialityRequestDTO);
        medicalSpecialityService.associateSpecialityToAllMedicalRecords(responseDTO.getId());
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<List<MedicalSpecialityResponseDTO>> getAllMedicalSpecialities() {
        return ResponseEntity.ok(medicalSpecialityService.getAllMedicalSpecialities());
    }

    @Override
    public ResponseEntity<MedicalSpecialityResponseDTO> getMedicalSpecialityById(@PathVariable Long id) {
        return medicalSpecialityService.getMedicalSpecialityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<MedicalSpecialityResponseDTO> updateMedicalSpeciality(@PathVariable Long id, @RequestBody MedicalSpecialityRequestDTO medicalSpecialityRequestDTO) {
        return ResponseEntity.ok(medicalSpecialityService.updateMedicalSpeciality(id, medicalSpecialityRequestDTO));
    }

    @Override
    public ResponseEntity<Void> deleteMedicalSpeciality(@PathVariable Long id) {
        medicalSpecialityService.deleteMedicalSpeciality(id);
        return ResponseEntity.noContent().build();
    }

}