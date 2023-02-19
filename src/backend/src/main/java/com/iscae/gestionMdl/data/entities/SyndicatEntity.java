package com.iscae.gestionMdl.data.entities;

import com.iscae.gestionMdl.SyndMangement.dtos.Syndicat_Dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

/**
 * @author Abderrahmane
 */
//@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@Table(name = "syndicat1", schema = "iscae_sb_db", catalog = "")
public class SyndicatEntity {
    private Integer id;
    private String syndicat_type;
    private String syndicat_nom;
    private String logo;
    private Collection<CandidatEntity> candidatbyId;

    public SyndicatEntity() {

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSyndicat_nom() {
        return syndicat_nom;
    }

    public void setSyndicat_nom(String syndicat_nom) {
        this.syndicat_nom = syndicat_nom;
    }

    public String getSyndicat_type() {
        return syndicat_type;
    }

    public void setSyndicat_type(String syndicat_type) {
        this.syndicat_type = syndicat_type;
    }

    public void setCandidatbyId(Collection<CandidatEntity> candidatbyId) {
        this.candidatbyId = candidatbyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyndicatEntity that = (SyndicatEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(syndicat_nom, that.syndicat_nom)
                && Objects.equals(syndicat_type, that.syndicat_type)
                && Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, syndicat_nom, syndicat_type, logo);
    }

    @OneToMany(mappedBy = "syndicatByIdSynd")
    public Collection<CandidatEntity> getCandidatbyId() {
        return candidatbyId;
    }





    public Syndicat_Dto toSyndicatDto(SyndicatEntity syndicat) {
        return Syndicat_Dto.builder()
                .id(syndicat.getId())
                .syndicat_nom(syndicat.getSyndicat_nom())
                .syndicat_type(syndicat.getSyndicat_type())
                .logo(syndicat.getLogo())
                .build();
    }
}
