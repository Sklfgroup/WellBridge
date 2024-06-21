package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.rest.api.MedicalHistoryControllerApi;
import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateMedicalHistoryRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalHistoryResponse;
import com.wellbridge.wellbridge.services.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medical-history")
public class MedicalHistoryController implements MedicalHistoryControllerApi {

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @Override
    public ResponseEntity<MedicalHistoryResponse> createMedicalHistory(CreateMedicalHistoryRequest request) {
        MedicalHistoryResponse response = medicalHistoryService.createMedicalHistory(request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MedicalHistoryResponse>> getAllMedicalHistories() {
        List<MedicalHistoryResponse> responses = medicalHistoryService.getAllMedicalHistories();
        return ResponseEntity.ok(responses);
    }
}