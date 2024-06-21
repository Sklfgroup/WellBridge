package com.wellbridge.wellbridge.services;

import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateMedicalHistoryRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalHistoryResponse;

import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryResponse createMedicalHistory(CreateMedicalHistoryRequest request);
    List<MedicalHistoryResponse> getAllMedicalHistories();
}