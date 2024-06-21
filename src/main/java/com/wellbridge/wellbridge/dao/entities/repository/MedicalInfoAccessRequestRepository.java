package com.wellbridge.wellbridge.dao.entities.repository;


import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfoAccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalInfoAccessRequestRepository extends JpaRepository<MedicalInfoAccessRequest, Long> {
    Optional<MedicalInfoAccessRequest> findByUuid(String uuid);
}
