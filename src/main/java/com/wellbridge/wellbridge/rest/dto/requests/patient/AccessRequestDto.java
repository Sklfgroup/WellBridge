package com.wellbridge.wellbridge.rest.dto.requests.patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessRequestDto {
    private String medecinUuid;
    private String medicalInfoUuid;
}