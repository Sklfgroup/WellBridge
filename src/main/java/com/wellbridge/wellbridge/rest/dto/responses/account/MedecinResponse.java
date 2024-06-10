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
public class MedecinResponse {
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String code;
    private String number;
    private String dateOfBirth;
    private String adresse;
    private String registrationNumber;
    private UserRole userRole;

    public MedecinResponse(AccountEntity entity) {
        this.uuid = entity.getUuid();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.username = entity.getUsername();
        this.code = entity.getCode();
        this.number = entity.getNumber();
        this.dateOfBirth = entity.getDateOfBirth();
        this.adresse = entity.getAdresse();
        this.registrationNumber = entity.getRegistrationNumber();
        this.userRole = entity.getUserRole();
    }
}
