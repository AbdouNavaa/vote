package com.iscae.gestionMdl.data.entities;

import com.iscae.gestionMdl.referentiel.dtos.EtudDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Etudient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "INE", nullable = false)
    private int ine;
    @Basic
    @Column(name = "nom", nullable = false, length = 30)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 30)
    private String prenom;
    @Basic
    @Column(name = "date", nullable = false, length = 100)
    private String date;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "inscription", nullable = false, length = 15)
    private String inscription;
    @Basic
    @Column(name = "niveau", nullable = false, length = 30)
    private String niveau;
    @Basic
    @Column(name = "etablisement", nullable = false, length = 30)
    private String etablisement;

    @OneToOne(mappedBy = "etudiantsByIdEtudient")
    private CandidatEntity candidatsById;
    public EtudDto toEtudDto(Etudient etudient) {
        return EtudDto.builder()
                .id(etudient.getId())
                .ine(etudient.getIne())
                .nom(etudient.getNom())
                .prenom(etudient.getPrenom())
                .date(etudient.getDate())
                .email(etudient.getEmail())
                .password(etudient.getPassword())
                .inscription(etudient.getInscription())
                .niveau(etudient.getNiveau())
                .etablisement(etudient.getEtablisement())
                .build();
    }
}
