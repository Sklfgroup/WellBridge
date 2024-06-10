package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.rest.api.AccountApi;
import com.wellbridge.wellbridge.rest.dto.requests.account.*;
import com.wellbridge.wellbridge.rest.dto.responses.account.*;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.security.jwt.JwtTokenUtil;
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
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AccountController(AccountService accountService, JwtTokenUtil jwtTokenUtil,  PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.jwtTokenUtil =jwtTokenUtil;
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

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDataResponse> updateAccount(@PathVariable Long id, @RequestBody UpdateAccountRequest request) {
        AccountEntity account = accountService.getAccountById(id);
        if (account != null) {
            if (request.getFirstname() != null) account.setFirstname(request.getFirstname());
            if (request.getLastname() != null) account.setLastname(request.getLastname());
            if (request.getUsername() != null) account.setUsername(request.getUsername());
            if (request.getNumber() != null) account.setNumber(request.getNumber());
            if (request.getAdresse() != null) account.setAdresse(request.getAdresse());

            AccountEntity updatedAccount = accountRepository.save(account);
            return ResponseEntity.ok(new AccountDataResponse(updatedAccount));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('SUPERADMINISTRATOR')")
    @PostMapping("/create-admin")
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody CreateAdminRequest adminRequest) {
        AccountEntity adminAccount = adminRequest.toEntity();
        AccountEntity createdAdmin = accountService.createAdminAccount(adminAccount);
        return ResponseEntity.ok(new AdminResponse(createdAdmin));
    }



    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping("/create-patient")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody CreatePatientRequest patientRequest) {
        AccountEntity patientAccount = patientRequest.toEntity();
        AccountEntity createdPatient = accountService.createPatientAccount(patientAccount);
        return ResponseEntity.ok(new PatientResponse(createdPatient));
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping("/create-medecin")
    public ResponseEntity<MedecinResponse> createMedecin(@RequestBody CreateMedecinRequest medecinRequest) {
        AccountEntity medecinAccount = medecinRequest.toEntity();
        AccountEntity createdMedecin = accountService.createMedecinAccount(medecinAccount);
        return ResponseEntity.ok(new MedecinResponse(createdMedecin));
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
