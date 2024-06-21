package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.patient.AccessStatus;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfoAccessRequest;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.dao.entities.repository.MedicalInfoRepository;
import com.wellbridge.wellbridge.dao.entities.repository.MedicalInfoAccessRequestRepository;
import com.wellbridge.wellbridge.rest.dto.requests.patient.AccessRequestDto;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AccessResponseDto;
import com.wellbridge.wellbridge.services.MedicalInfoAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalInfoAccessServiceImpl implements MedicalInfoAccessService {
    @Autowired
    private MedicalInfoAccessRequestRepository accessRequestRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MedicalInfoRepository medicalInfoRepository;

    @Override
    public AccessResponseDto requestAccess(AccessRequestDto requestDto) {
        var medecin = accountRepository.findByUuid(requestDto.getMedecinUuid())
                .orElseThrow(() -> new IllegalArgumentException("Medecin not found"));
        var medicalInfo = medicalInfoRepository.findByUuid(requestDto.getMedicalInfoUuid())
                .orElseThrow(() -> new IllegalArgumentException("MedicalInfo not found"));

        var accessRequest = new MedicalInfoAccessRequest();
        accessRequest.setMedecin(medecin);
        accessRequest.setMedicalInfo(medicalInfo);
        accessRequest.setStatus(AccessStatus.PENDING);

        accessRequestRepository.save(accessRequest);

        // Envoi de la notification au patient (à implémenter)

        return new AccessResponseDto(medecin.getUuid(), medicalInfo.getUuid(), accessRequest.getStatus());
    }

    @Override
    public AccessResponseDto approveAccess(String requestUuid) {
        var accessRequest = accessRequestRepository.findByUuid(requestUuid)
                .orElseThrow(() -> new IllegalArgumentException("Access request not found"));

        accessRequest.setStatus(AccessStatus.APPROVED);
        accessRequestRepository.save(accessRequest);

        return new AccessResponseDto(accessRequest.getMedecin().getUuid(),
                accessRequest.getMedicalInfo().getUuid(), accessRequest.getStatus());
    }

    @Override
    public AccessResponseDto denyAccess(String requestUuid) {
        var accessRequest = accessRequestRepository.findByUuid(requestUuid)
                .orElseThrow(() -> new IllegalArgumentException("Access request not found"));

        accessRequest.setStatus(AccessStatus.DENIED);
        accessRequestRepository.save(accessRequest);

        return new AccessResponseDto(accessRequest.getMedecin().getUuid(),
                accessRequest.getMedicalInfo().getUuid(), accessRequest.getStatus());
    }
}
