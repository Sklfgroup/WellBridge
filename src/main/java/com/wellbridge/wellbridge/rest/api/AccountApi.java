package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.requests.account.ConnexionAccountRequest;
import com.wellbridge.wellbridge.rest.dto.responses.account.ConnexionAccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AccountApi {

    @PostMapping("/authenticate")
    ResponseEntity<ConnexionAccountResponse> authenticate(@RequestBody ConnexionAccountRequest request);
    ResponseEntity<AccountEntity> createPatientAccount(@RequestBody AccountEntity patientAccount);
    ResponseEntity<AccountEntity> createMedecinAccount(@RequestBody AccountEntity medecinAccount);

   // ResponseEntity<AccountEntity> createAccount(AccountEntity account);


    ResponseEntity<AccountEntity> getAccountById(Long id);

    ResponseEntity<AccountEntity> getAccountByUsername(String username);

    ResponseEntity<List<AccountEntity>> getAllAccounts();

    ResponseEntity<List<AccountEntity>> getAccountsByRole(UserRole role);
}
