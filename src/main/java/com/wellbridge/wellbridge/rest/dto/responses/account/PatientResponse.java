package com.wellbridge.wellbridge.rest.dto.responses.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientResponse {
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String number;
    private String dateOfBirth;
    private String adresse;
    private UserRole userRole;
    private String BloodGroup;

    public PatientResponse(AccountEntity entity) {
        this.uuid = entity.getUuid();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.username = entity.getUsername();
        this.number = entity.getNumber();
        this.dateOfBirth = entity.getDateOfBirth();
        this.adresse = entity.getAdresse();
        this.BloodGroup = entity.getBloodGroup();
        this.userRole = entity.getUserRole();
    }
}
