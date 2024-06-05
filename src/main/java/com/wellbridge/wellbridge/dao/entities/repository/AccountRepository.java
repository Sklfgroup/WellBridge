package com.wellbridge.wellbridge.dao.entities.repository;


import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findById(Long id);
    Optional<AccountEntity> findByUsername(String username);
    List<AccountEntity> findByUserRole(UserRole userRole);
    boolean existsByUsername(String username);
}