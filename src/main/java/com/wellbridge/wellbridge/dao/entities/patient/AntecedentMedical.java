package com.wellbridge.wellbridge.dao.entities.patient;

import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "antecedent_medical")
public class AntecedentMedical extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "medical_info_id", referencedColumnName = "id")
    private MedicalInfo medicalInfo;

    @Column(name = "details")
    private String details;
}
