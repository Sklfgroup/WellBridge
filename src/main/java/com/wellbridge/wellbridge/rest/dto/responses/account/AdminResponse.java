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
public class AdminResponse {
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String number;
    private String dateOfBirth;
    private String adresse;
    private UserRole userRole;

    public AdminResponse(AccountEntity entity) {
        this.uuid = entity.getUuid();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.username = entity.getUsername();
        this.number = entity.getNumber();
        this.adresse = entity.getAdresse();
        this.userRole = entity.getUserRole();
    }
}
