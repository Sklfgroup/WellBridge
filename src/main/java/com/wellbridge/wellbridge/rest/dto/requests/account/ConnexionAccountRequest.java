package com.wellbridge.wellbridge.rest.dto.requests.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;


import javax.validation.constraints.NotBlank;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ConnexionAccountRequest (

    @NotBlank(message = "username is required")
    @JsonProperty(value = "username", required = true)
    String username,

    @NotBlank(message = "Password is required")
    @JsonProperty(value = "password", required = true)
    String password) {

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }


    public AccountEntity toEntity() {
            AccountEntity entity = new AccountEntity();
            entity.setUsername(username.toLowerCase());
            entity.setPassword(password);
            return entity;
        }
}
