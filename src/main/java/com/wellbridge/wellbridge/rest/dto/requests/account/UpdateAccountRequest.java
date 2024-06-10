package com.wellbridge.wellbridge.rest.dto.requests.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAccountRequest {

    @NotBlank(message = "First name is required")
    @JsonProperty("firstname")
    private String firstname;

    @NotBlank(message = "Last name is required")
    @JsonProperty("lastname")
    private String lastname;

    @NotBlank(message = "Username is required")
    @JsonProperty("username")
    private String username;

    @NotBlank(message = "Number is required")
    @JsonProperty("number")
    private String number;

    @NotBlank(message = "Address is required")
    @JsonProperty("adresse")
    private String adresse;
}



