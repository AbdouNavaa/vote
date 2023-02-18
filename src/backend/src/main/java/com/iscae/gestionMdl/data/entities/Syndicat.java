package com.iscae.gestionMdl.data.entities;

import com.iscae.gestionMdl.referentiel.dtos.SyndicatDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Syndicat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "syndicat_type", nullable = true, length = 100)
    private String syndicatType;
    @Basic
    @Column(name = "syndicat_nom", nullable = true, length = 100)
    private String syndicatNom;
    @Basic
    @Column(name = "logo", nullable = true, length = 100)
    private String logo;

    public SyndicatDto toSyndicatDto(Syndicat syndicat) {
        return SyndicatDto.builder()
                .id(syndicat.getId())
                .syndicat_type(syndicat.getSyndicatType())
                .syndicat_nom(syndicat.getSyndicatNom())
                .logo(syndicat.getLogo())
                .build();
    }
}
