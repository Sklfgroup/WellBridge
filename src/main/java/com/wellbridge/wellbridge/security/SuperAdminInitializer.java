package com.wellbridge.wellbridge.security;


import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class SuperAdminInitializer {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SuperAdminInitializer(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initializeSuperAdmin() {
        return args -> {
            if (!accountRepository.existsByUsername("superadmin")) {
                AccountEntity superAdmin = new AccountEntity();
                superAdmin.setFirstname("Super");
                superAdmin.setLastname("Admin");
                superAdmin.setUsername("superadmin");
                superAdmin.setPassword(passwordEncoder.encode("superadminpassword"));  // Changez le mot de passe pour quelque chose de sécurisé
                superAdmin.setUserRole(UserRole.SUPERADMINISTRATOR);
                accountRepository.save(superAdmin);
            }
        };
    }
}
