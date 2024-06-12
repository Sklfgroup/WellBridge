package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.requests.account.*;
import com.wellbridge.wellbridge.rest.dto.responses.account.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AccountApi {
    @PostMapping("/authenticate")
    ResponseEntity<ConnexionAccountResponse> authenticate(@RequestBody ConnexionAccountRequest request);

    @PutMapping("/update/{uuid}")
    ResponseEntity<AccountDataResponse> updateAccount(@PathVariable String uuid, @RequestBody UpdateAccountRequest request);

    @GetMapping("/uuid/{uuid}")
    ResponseEntity<AccountEntity> getAccountByUuid(@PathVariable String uuid);

    @GetMapping("/username/{username}")
    ResponseEntity<AccountEntity> getAccountByUsername(@PathVariable String username);

    @GetMapping
    ResponseEntity<List<AccountEntity>> getAllAccounts();

    @GetMapping("/role/{role}")
    ResponseEntity<List<AccountEntity>> getAccountsByRole(@PathVariable UserRole role);

    @PostMapping("/create-admin")
    ResponseEntity<AdminResponse> createAdmin(@RequestBody CreateAdminRequest adminRequest);

    @PostMapping("/create-patient")
    ResponseEntity<PatientResponse> createPatient(@RequestBody CreatePatientRequest patientRequest);

    @PostMapping("/create-medecin")
    ResponseEntity<MedecinResponse> createMedecin(@RequestBody CreateMedecinRequest medecinRequest);
}
