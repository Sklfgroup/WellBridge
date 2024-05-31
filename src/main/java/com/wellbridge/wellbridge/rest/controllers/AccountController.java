package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.rest.api.AccountApi;
import com.wellbridge.wellbridge.rest.dto.requests.account.ConnexionAccountRequest;
import com.wellbridge.wellbridge.rest.dto.responses.account.ConnexionAccountResponse;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController implements AccountApi {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @PostMapping("/superadmin")
    public ResponseEntity<AccountEntity> createSuperAdmin(@RequestBody AccountEntity account) {
        if (account.getUserRole() != UserRole.SUPERADMINISTRATOR) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        AccountEntity createdAccount = accountService.createSuperAdmin(account);
        return createdAccount != null ? ResponseEntity.status(HttpStatus.CREATED).body(createdAccount) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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
    @PostMapping
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity account) {
        // Obtenez le rôle de l'utilisateur actuellement connecté à partir de la session ou du token
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        String roleName = authentication.getAuthorities().iterator().next().getAuthority();
        UserRole creatorRole = UserRole.valueOf(roleName.replace("ROLE_", ""));

        AccountEntity createdAccount = accountService.createAccount(account, creatorRole);
        if (createdAccount != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Retourner une erreur 403 si l'utilisateur n'est pas autorisé à créer ce type de compte
        }
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