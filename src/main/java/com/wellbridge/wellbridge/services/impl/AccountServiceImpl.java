package com.wellbridge.wellbridge.services.impl;



import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.exceptions.ResourceNotFoundException;

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
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AccountEntity createSuperAdmin(AccountEntity account) {
        if (account.getUserRole() != UserRole.SUPERADMINISTRATOR) {
            throw new IllegalArgumentException("Only SUPERADMINISTRATOR can be created with this method");
        }
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public AccountEntity createAccount(AccountEntity account, UserRole creatorRole) {
        // Vérifier si le nom d'utilisateur existe déjà
        Optional<AccountEntity> existingAccount = accountRepository.findByUsername(account.getUsername());
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (creatorRole != UserRole.ADMINISTRATOR) {
            throw new SecurityException("Only ADMINISTRATOR can create accounts");
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
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
