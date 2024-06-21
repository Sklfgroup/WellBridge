package com.wellbridge.wellbridge.dao.entities.repository;

import com.wellbridge.wellbridge.dao.entities.patient.DossierMedical;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
    Optional<DossierMedical> findByCode(String code);
}