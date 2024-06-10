package com.wellbridge.wellbridge.rest.dto.requests.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record CreateAdminRequest(
        @NotBlank(message = "First name is required")
        @JsonProperty("firstname") String firstname,

        @NotBlank(message = "Last name is required")
        @JsonProperty("lastname") String lastname,

        @NotBlank(message = "Username is required")
        @JsonProperty("username") String username,

        @NotBlank(message = "Password is required")
        @JsonProperty("password") String password,


        @NotBlank(message = "Number is required")
        @JsonProperty("number") String number,

        @NotBlank(message = "Address is required")
        @JsonProperty("adresse") String adresse,


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
        entity.setNumber(number);
        entity.setAdresse(adresse);
        entity.setUserRole(userRole);
        return entity;
    }
}
