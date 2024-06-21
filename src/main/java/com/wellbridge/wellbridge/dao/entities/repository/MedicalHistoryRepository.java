package com.wellbridge.wellbridge.dao.entities.repository;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    Optional<MedicalHistory> findByName(String name);
}