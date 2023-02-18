package com.iscae.gestionMdl.data.entities;

import com.iscae.gestionMdl.mdlMangement.dtos.MatiereDto;
import com.iscae.gestionMdl.referentiel.dtos.RefDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Abderrahmane
 */
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@Table(name = "professeurs", schema = "iscae_sb_db", catalog = "")
public class ProfesseursEntity {
    private Integer id;
    private String nom;
    private String prenom;
    private Collection<MatiereEntity> matieresById;

    public ProfesseursEntity() {

    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesseursEntity that = (ProfesseursEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom)
                && Objects.equals(prenom, that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom,prenom);
    }

    @OneToMany(mappedBy = "professeursByIdProfesseur")
    public Collection<MatiereEntity> getMatieresById() {
        return matieresById;
    }

    public void setMatieresById(Collection<MatiereEntity> matieresById) {
        this.matieresById = matieresById;
    }

    public RefDto toProfesseurDto(ProfesseursEntity professeursEntity) {
        return RefDto.builder()
                .id(professeursEntity.getId())
                .nom(professeursEntity.getNom())
                .prenom(professeursEntity.getPrenom())
                .build();
    }


}
