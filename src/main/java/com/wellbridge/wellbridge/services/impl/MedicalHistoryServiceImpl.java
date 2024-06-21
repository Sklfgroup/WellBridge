package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.patient.MedicalHistory;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfo;
import com.wellbridge.wellbridge.dao.entities.repository.MedicalHistoryRepository;
import com.wellbridge.wellbridge.dao.entities.repository.MedicalInfoRepository;
import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateMedicalHistoryRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.MedicalHistoryResponse;
import com.wellbridge.wellbridge.services.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private MedicalInfoRepository medicalInfoRepository;

    @Override
    public MedicalHistoryResponse createMedicalHistory(CreateMedicalHistoryRequest request) {
        Optional<MedicalHistory> existingHistory = medicalHistoryRepository.findByName(request.getName());
        if (existingHistory.isPresent()) {
            throw new IllegalArgumentException("An antecedent with the same name already exists");
        }

        MedicalHistory medicalHistory = new MedicalHistory(request.getName(), request.getImageUrl());
        medicalHistoryRepository.save(medicalHistory);

        // Ajouter cet antécédent à tous les dossiers médicaux
        List<MedicalInfo> medicalInfos = medicalInfoRepository.findAll();
        for (MedicalInfo medicalInfo : medicalInfos) {
            medicalInfo.getMedicalHistories().add(medicalHistory);
            medicalInfoRepository.save(medicalInfo);
        }

        return new MedicalHistoryResponse(medicalHistory.getId(), medicalHistory.getName(), medicalHistory.getImageUrl());
    }

    @Override
    public List<MedicalHistoryResponse> getAllMedicalHistories() {
        return medicalHistoryRepository.findAll().stream()
                .map(mh -> new MedicalHistoryResponse(mh.getId(), mh.getName(), mh.getImageUrl()))
                .collect(Collectors.toList());
    }

}