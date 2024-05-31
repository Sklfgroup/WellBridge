package com.wellbridge.wellbridge.rest.api;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.requests.account.CreateAccountRequest;
import com.wellbridge.wellbridge.rest.dto.requests.account.ConnexionAccountRequest;
import com.wellbridge.wellbridge.rest.dto.responses.account.AccountDataResponse;
import com.wellbridge.wellbridge.rest.dto.responses.account.AccountResponse;
import com.wellbridge.wellbridge.rest.dto.responses.account.ConnexionAccountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface AccountApi {
    ResponseEntity<AccountEntity> createSuperAdmin(AccountEntity account);

    @PostMapping("/authenticate")
    ResponseEntity<ConnexionAccountResponse> authenticate(@RequestBody ConnexionAccountRequest request);

    ResponseEntity<AccountEntity> createAccount(AccountEntity account);

    ResponseEntity<AccountEntity> getAccountById(Long id);

    ResponseEntity<AccountEntity> getAccountByUsername(String username);

    ResponseEntity<List<AccountEntity>> getAllAccounts();

    ResponseEntity<List<AccountEntity>> getAccountsByRole(UserRole role);
}