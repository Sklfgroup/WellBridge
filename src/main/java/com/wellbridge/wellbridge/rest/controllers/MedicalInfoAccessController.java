package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.rest.api.MedicalInfoAccessControllerApi;
import com.wellbridge.wellbridge.rest.dto.requests.patient.AccessRequestDto;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AccessResponseDto;
import com.wellbridge.wellbridge.services.MedicalInfoAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medical-info-access")
public class MedicalInfoAccessController implements MedicalInfoAccessControllerApi {

    @Autowired
    private MedicalInfoAccessService accessService;

    @Override
    public ResponseEntity<AccessResponseDto> requestAccess(AccessRequestDto requestDto) {
        AccessResponseDto responseDto = accessService.requestAccess(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<AccessResponseDto> approveAccess(String uuid) {
        AccessResponseDto responseDto = accessService.approveAccess(uuid);
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<AccessResponseDto> denyAccess(String uuid) {
        AccessResponseDto responseDto = accessService.denyAccess(uuid);
        return ResponseEntity.ok(responseDto);
    }
}
