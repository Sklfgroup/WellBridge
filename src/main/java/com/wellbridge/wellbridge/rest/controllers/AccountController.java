package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.rest.api.AccountApi;
import com.wellbridge.wellbridge.rest.dto.requests.account.ConnexionAccountRequest;
import com.wellbridge.wellbridge.rest.dto.responses.account.ConnexionAccountResponse;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController implements AccountApi {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountService accountService, PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }


    @Override
    @PostMapping("/authenticate")
    public ResponseEntity<ConnexionAccountResponse> authenticate(@RequestBody ConnexionAccountRequest request) {
        AccountEntity account = accountService.authenticate(request.getUsername(), request.getPassword());
        ConnexionAccountResponse response = new ConnexionAccountResponse(account);
        response.setToken(account.getToken());
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('SUPERADMINISTRATOR')")
    @PostMapping("/create-admin")
    public AccountEntity createAdmin(@RequestBody AccountEntity adminAccount) {
        return accountService.createAdminAccount(adminAccount);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping("/create-patient")
    public ResponseEntity<AccountEntity> createPatientAccount(@RequestBody AccountEntity patientAccount) {
        return ResponseEntity.ok(accountService.createPatientAccount(patientAccount));
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping("/create-medecin")
    public ResponseEntity<AccountEntity> createMedecinAccount(@RequestBody AccountEntity medecinAccount) {
        return ResponseEntity.ok(accountService.createMedecinAccount(medecinAccount));
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AccountEntity> getAccountById(@PathVariable Long id) {
        AccountEntity account = accountService.getAccountById(id);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    @Override
    @GetMapping("/username/{username}")
    public ResponseEntity<AccountEntity> getAccountByUsername(@PathVariable String username) {
        AccountEntity account = accountService.getAccountByUsername(username);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @Override
    @GetMapping("/role/{role}")
    public ResponseEntity<List<AccountEntity>> getAccountsByRole(@PathVariable UserRole role) {
        return ResponseEntity.ok(accountService.getAccountsByRole(role));
    }
}
