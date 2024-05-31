package com.wellbridge.wellbridge.rest.dto.requests.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateAccountRequest(

        @NotBlank(message = "First name is required")
        @JsonProperty(value = "firstname", required = true)
        String firstname,

        @NotBlank(message = "Last name is required")
        @JsonProperty(value = "lastname", required = true)
        String lastname,
        @NotBlank(message = "username is required")
        @JsonProperty(value = "username", required = true)
        String username,

        @NotBlank(message = "Password is required")
        @JsonProperty(value = "password", required = true)
        String password,

        @NotBlank(message = "Code is required")
        @JsonProperty(value = "code", required = true)
        String code,

        @NotBlank(message = "Number is required")
        @JsonProperty(value = "number", required = true)
        String number,

        @NotNull(message = "Date of birth is required")
        @JsonProperty(value = "dateOfBirth", required = true)
        Date dateOfBirth,

        @NotBlank(message = "Address is required")
        @JsonProperty(value = "adresse", required = true)
        String adresse,

        @JsonProperty(value = "registrationNumber")
        String registrationNumber,

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
