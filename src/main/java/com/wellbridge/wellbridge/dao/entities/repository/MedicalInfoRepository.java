package com.wellbridge.wellbridge.dao.entities.repository;


import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalInfoRepository extends JpaRepository<MedicalInfo, Long> {
    Optional<MedicalInfo> findByUuid(String uuid);
}
