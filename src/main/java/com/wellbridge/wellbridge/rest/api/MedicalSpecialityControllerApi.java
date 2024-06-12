package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.rest.dto.requests.patient.MedicalSpecialityRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalSpecialityResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MedicalSpecialityControllerApi {

    @PostMapping("/create-specialities")
    ResponseEntity<MedicalSpecialityResponseDTO> createMedicalSpeciality(@RequestBody MedicalSpecialityRequestDTO medicalSpecialityRequestDTO);

    @GetMapping("/all-specialities")
    ResponseEntity<List<MedicalSpecialityResponseDTO>> getAllMedicalSpecialities();

    @GetMapping("/{id}")
    ResponseEntity<MedicalSpecialityResponseDTO> getMedicalSpecialityById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    ResponseEntity<MedicalSpecialityResponseDTO> updateMedicalSpeciality(@PathVariable Long id, @RequestBody MedicalSpecialityRequestDTO medicalSpecialityRequestDTO);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteMedicalSpeciality(@PathVariable Long id);
}
