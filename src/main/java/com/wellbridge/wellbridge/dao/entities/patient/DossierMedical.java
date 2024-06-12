package com.wellbridge.wellbridge.dao.entities.patient;


import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dossier_medical")
public class DossierMedical extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "medical_info_id", referencedColumnName = "id")
    private MedicalInfo medicalInfo;

    @Column(name = "details")
    private String details;

    @ManyToMany
    @JoinTable(name = "dossier_medical_speciality",
            joinColumns = @JoinColumn(name = "dossier_medical_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_speciality_id"))
    private Set<MedicalSpeciality> medicalSpecialities = new HashSet<>();
}