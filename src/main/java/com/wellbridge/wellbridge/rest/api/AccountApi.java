package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.requests.account.*;
import com.wellbridge.wellbridge.rest.dto.responses.account.*;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AccountApi {

    @PostMapping("/authenticate")
    ResponseEntity<ConnexionAccountResponse> authenticate(@RequestBody ConnexionAccountRequest request);
    ResponseEntity<AdminResponse> createAdmin(CreateAdminRequest request);

    ResponseEntity<MedecinResponse> createMedecin(CreateMedecinRequest request);

    ResponseEntity<PatientResponse> createPatient(CreatePatientRequest request);
    @PutMapping("/update/{id}")
    ResponseEntity<AccountDataResponse> updateAccount(@PathVariable Long id, @RequestBody UpdateAccountRequest request);

    ResponseEntity<AccountEntity> getAccountById(Long id);

    ResponseEntity<AccountEntity> getAccountByUsername(String username);

    ResponseEntity<List<AccountEntity>> getAllAccounts();

    ResponseEntity<List<AccountEntity>> getAccountsByRole(UserRole role);
}
