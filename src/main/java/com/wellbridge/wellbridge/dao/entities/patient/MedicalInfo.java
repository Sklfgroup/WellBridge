package com.wellbridge.wellbridge.dao.entities.patient;

import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
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
@Table(name = "medical_info")
public class MedicalInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity account;

    @OneToOne(mappedBy = "medicalInfo", cascade = CascadeType.ALL)
    private DossierMedical dossierMedical;

    @ManyToMany
    @JoinTable(name = "medical_info_history",
            joinColumns = @JoinColumn(name = "medical_info_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_history_id"))
    private Set<MedicalHistory> medicalHistories = new HashSet<>();
}
