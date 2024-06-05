package com.wellbridge.wellbridge.services;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;

import java.util.List;

import java.util.Optional;


public interface AccountService {
    AccountEntity createAdminAccount(AccountEntity adminAccount);
    AccountEntity createPatientAccount(AccountEntity patientAccount);
    AccountEntity createMedecinAccount(AccountEntity medecinAccount);
    AccountEntity getAccountById(Long id);
    AccountEntity getAccountByUsername(String username);
    List<AccountEntity> getAllAccounts();
    List<AccountEntity> getAccountsByRole(UserRole role);
    AccountEntity authenticate(String username, String password);
}
