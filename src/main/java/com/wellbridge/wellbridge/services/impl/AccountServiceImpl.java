package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.exceptions.ResourceNotFoundException;
import com.wellbridge.wellbridge.rest.dto.requests.account.UpdateAccountRequest;
import com.wellbridge.wellbridge.security.jwt.JwtTokenUtil;
import com.wellbridge.wellbridge.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder,JwtTokenUtil jwtTokenUtil) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }
    @Override
    public AccountEntity createAdminAccount(AccountEntity adminAccount) {
        if (adminAccount.getUserRole() != UserRole.ADMINISTRATOR) {
            throw new IllegalArgumentException("Only ADMINISTRATOR accounts can be created with this method");
        }
        if (accountRepository.existsByUsername(adminAccount.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        adminAccount.setPassword(passwordEncoder.encode(adminAccount.getPassword()));
        return accountRepository.save(adminAccount);
    }

    @Override
    public AccountEntity updateAccount(Long id, UpdateAccountRequest request) {
        AccountEntity account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (request.getFirstname() != null) account.setFirstname(request.getFirstname());
        if (request.getLastname() != null) account.setLastname(request.getLastname());
        if (request.getUsername() != null) account.setUsername(request.getUsername());
        if (request.getNumber() != null) account.setNumber(request.getNumber());
        if (request.getAdresse() != null) account.setAdresse(request.getAdresse());

        return accountRepository.save(account);
    }

    @Override
    public AccountEntity createPatientAccount(AccountEntity patientAccount) {
        if (patientAccount.getUserRole() != UserRole.PATIENT) {
            throw new IllegalArgumentException("Only PATIENT accounts can be created with this method");
        }
        if (accountRepository.existsByUsername(patientAccount.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        patientAccount.setPassword(passwordEncoder.encode(patientAccount.getPassword()));
        return accountRepository.save(patientAccount);
    }

    @Override
    public AccountEntity createMedecinAccount(AccountEntity medecinAccount) {
        if (medecinAccount.getUserRole() != UserRole.MEDECIN) {
            throw new IllegalArgumentException("Only MEDECIN accounts can be created with this method");
        }
        if (accountRepository.existsByUsername(medecinAccount.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        medecinAccount.setPassword(passwordEncoder.encode(medecinAccount.getPassword()));
        return accountRepository.save(medecinAccount);
    }


    @Override
    public AccountEntity getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
    }

    @Override
    public AccountEntity getAccountByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with username " + username));
    }

    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<AccountEntity> getAccountsByRole(UserRole role) {
        return accountRepository.findByUserRole(role);
    }



    @Override
    public AccountEntity authenticate(String username, String password) {
        AccountEntity account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with username " + username));

        if (passwordEncoder.matches(password, account.getPassword())) {
            account.setToken(jwtTokenUtil.generateToken(account));
            return account;
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }
}
