package com.wellbridge.wellbridge.rest.dto.responses.patient;

import com.wellbridge.wellbridge.dao.entities.patient.AccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccessResponseDto {
    private String medecinUuid;
    private String medicalInfoUuid;
    private AccessStatus status;
}
