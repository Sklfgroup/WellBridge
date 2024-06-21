package com.wellbridge.wellbridge.rest.dto.responses.patient;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistoryResponse {
    private Long id;
    private String name;
    private String imageUrl;

    // getters et setters
}
