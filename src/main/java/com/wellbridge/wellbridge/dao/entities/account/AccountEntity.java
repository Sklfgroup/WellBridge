package com.wellbridge.wellbridge.dao.entities.account;

import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AccountEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="firstname")
    private String firstname;

    @Column (name ="lastname")
    private String lastname;

    @Column(name ="password")
    private String password;

    @Column(name ="username")
    private String username;  // Utilisé pour l'authentification

    @Column(name="code")
    private String code;

    @Column(name="number")
    private String number;

    @Column(name="dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "adresse")
    private String adresse; // Correction de l'orthographe de "adresse"

    @Column(name="registrationNumber")
    private String registrationNumber;

    @JoinColumn(name="user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public void setUsername(String username) {
        this.username = username;
    }


    @Transient
    private String token;
}