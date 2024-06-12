package com.wellbridge.wellbridge.dao.entities.repository;

import com.wellbridge.wellbridge.dao.entities.patient.MedicalSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalSpecialityRepository extends JpaRepository<MedicalSpeciality, Long> {
    Optional<MedicalSpeciality> findByName(String name);
}