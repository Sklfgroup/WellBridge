package com.wellbridge.wellbridge.rest.dto.requests.patient;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMedicalHistoryRequest {
    private String name;
    private String imageUrl;

    // getters et setters
}
