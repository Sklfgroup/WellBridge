package com.wellbridge.wellbridge.rest.api;



import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateMedicalHistoryRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalHistoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface MedicalHistoryControllerApi {

    @PostMapping("/create-medical-history")
    ResponseEntity<MedicalHistoryResponse> createMedicalHistory(@RequestBody CreateMedicalHistoryRequest request);

    @GetMapping("/getAll-medical-history")
    ResponseEntity<List<MedicalHistoryResponse>> getAllMedicalHistories();
}
