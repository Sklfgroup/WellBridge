package com.wellbridge.wellbridge.rest.dto.responses.account;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.responses.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnexionAccountResponse extends BaseDto {
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String code;
    private String number;
    private String dateOfBirth;
    private String BloodGroup;
    private String adresse;
    private String registrationNumber;
    private UserRole function;
    private String token;


    public ConnexionAccountResponse(AccountEntity entity) {
        this.uuid = entity.getUuid();
        this.firstname = entity.getFirstname();
        this.lastname = entity.getLastname();
        this.username = entity.getUsername();
        this.code = entity.getCode();
        this.number = entity.getNumber();
        this.BloodGroup = entity.getBloodGroup();
        this.dateOfBirth = entity.getDateOfBirth();
        this.adresse = entity.getAdresse();
        this.registrationNumber = entity.getRegistrationNumber();
        this.function = entity.getUserRole();
        this.token = entity.getToken(); // Assuming token is set elsewhere
    }
}
