package com.wellbridge.wellbridge.dao.entities.patient;


import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "medical_info_access_request")
public class MedicalInfoAccessRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ajoutez une propriété d'identifiant avec @Id
    @ManyToOne
    @JoinColumn(name = "medecin_id", referencedColumnName = "id")
    private AccountEntity medecin;

    @ManyToOne
    @JoinColumn(name = "medical_info_id", referencedColumnName = "id")
    private MedicalInfo medicalInfo;

    @Enumerated(EnumType.STRING)
    private AccessStatus status = AccessStatus.PENDING;
}
