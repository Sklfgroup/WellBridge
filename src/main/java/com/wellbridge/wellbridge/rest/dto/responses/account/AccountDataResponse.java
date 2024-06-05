package com.wellbridge.wellbridge.rest.dto.responses.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.responses.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDataResponse extends BaseDto {
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String code;
    private String number;
    private Date dateOfBirth;
    private String adresse;
    private String registrationNumber;
    private UserRole function;


    public AccountDataResponse(AccountEntity entity) {
        this.uuid = entity.getUuid();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.username = entity.getUsername();
        this.code = entity.getCode();
        this.number = entity.getNumber();
        this.dateOfBirth = entity.getDateOfBirth();
        this.function = entity.getUserRole();
        this.adresse = entity.getAdresse();
        this.registrationNumber = entity.getRegistrationNumber();

    }
}
