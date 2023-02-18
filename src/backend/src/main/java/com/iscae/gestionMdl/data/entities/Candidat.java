package com.iscae.gestionMdl.data.entities;

import com.iscae.gestionMdl.referentiel.dtos.Candidat_Dto;
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
public class Candidat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "FK_Etudient", nullable = false)
    private int fkEtudient;
    @Basic
    @Column(name = "FK_Syndicat", nullable = false)
    private int fkSyndicat;

//    private Etudient etudientbyId;
//    private Syndicat syndicatbyId;

    @OneToOne
    @JoinColumn(name = "FK_Etudient", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Etudient etudientByFkEtudient;
    @ManyToOne
    @JoinColumn(name = "FK_Syndicat", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Syndicat syndicatByFkSyndicat;


//    @ManyToOne
//    @JoinColumn(name = "id_professeur", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
//    public ProfesseursEntity getProfesseursByIdProfesseur() {
//        return professeursByIdProfesseur;
//    }
//public void setProfesseursByIdProfesseur(ProfesseursEntity professeursByIdProfesseur) {
//    this.professeursByIdProfesseur = professeursByIdProfesseur;
//}
    public Etudient getEtudientByFkEtudient() {
        return etudientByFkEtudient;
    }

    public void setEtudientByFkEtudient(Etudient etudientByFkEtudient) {
        this.etudientByFkEtudient = etudientByFkEtudient;
    }

    public Syndicat getSyndicatByFkSyndicat() {
        return syndicatByFkSyndicat;
    }

    public void setSyndicatByFkSyndicat(Syndicat syndicatByFkSyndicat) {
        this.syndicatByFkSyndicat = syndicatByFkSyndicat;
    }

    public Candidat_Dto toCandidatDto(Candidat etudient) {
        return Candidat_Dto.builder()
                .id(etudient.getId())
                .FK_Etudient(etudient.getEtudientByFkEtudient().getId())
                .FK_Syndicat(etudient.getSyndicatByFkSyndicat().getId())
                .nomEtud(etudient.getEtudientByFkEtudient().getNom())
                .nomSynd(etudient.getSyndicatByFkSyndicat().getSyndicatNom())
                .build();
    }
}
