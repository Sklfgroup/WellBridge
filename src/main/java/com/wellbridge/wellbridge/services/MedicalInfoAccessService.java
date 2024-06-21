package com.wellbridge.wellbridge.services;

import com.wellbridge.wellbridge.rest.dto.requests.patient.AccessRequestDto;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AccessResponseDto;

public interface MedicalInfoAccessService {
    AccessResponseDto requestAccess(AccessRequestDto requestDto);
    AccessResponseDto approveAccess(String requestUuid);
    AccessResponseDto denyAccess(String requestUuid);
}
