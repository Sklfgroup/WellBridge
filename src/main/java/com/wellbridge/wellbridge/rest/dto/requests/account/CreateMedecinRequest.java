package com.wellbridge.wellbridge.rest.dto.requests.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record CreateMedecinRequest(
        @NotBlank(message = "First name is required")
        @JsonProperty("firstname") String firstname,

        @NotBlank(message = "Last name is required")
        @JsonProperty("lastname") String lastname,

        @NotBlank(message = "Username is required")
        @JsonProperty("username") String username,

        @NotBlank(message = "Password is required")
        @JsonProperty("password") String password,

        @NotBlank(message = "Code is required")
        @JsonProperty("code") String code,

        @NotBlank(message = "Number is required")
        @JsonProperty("number") String number,

        @NotNull(message = "Date of birth is required")
        @JsonProperty("dateOfBirth") String dateOfBirth,

        @NotBlank(message = "Address is required")
        @JsonProperty("adresse") String adresse,

        @JsonProperty("registrationNumber") String registrationNumber,
        @NotNull(message = "function is required")
        @JsonProperty(value = "userRole", required = true)
        UserRole userRole
) {

    public AccountEntity toEntity() {
        AccountEntity entity = new AccountEntity();
        entity.setFirstname(firstname);
        entity.setLastname(lastname);
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setCode(code);
        entity.setNumber(number);
        entity.setDateOfBirth(dateOfBirth);
        entity.setAdresse(adresse);
        entity.setRegistrationNumber(registrationNumber);
        entity.setUserRole(userRole);
        return entity;
    }
}
