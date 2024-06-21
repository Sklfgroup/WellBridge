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
@Table(name = "medical_history")
public class MedicalHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    // Constructeur
    public MedicalHistory(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
