package com.iscae.gestionMdl.SyndMangement.dtos;

import com.iscae.gestionMdl.data.entities.CandidatEntity;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abderrahmane
 */
@Data
@Builder
public class CandidatDto {
    private Integer id;
    private Integer idSyndicat;
    private String poste;
    private Integer idEtudiant;
    private String nomEtud;

    public CandidatEntity toCandidatEntity(CandidatDto candidatDto) {
        return toCandidatEntity_(candidatDto, new CandidatEntity());
    }

    public CandidatEntity toCandidatEntity(CandidatDto candidatDto, CandidatEntity candidat) {
        return toCandidatEntity_(candidatDto, candidat);
    }

    private static CandidatEntity toCandidatEntity_(CandidatDto candidatDto, CandidatEntity candidat) {
        return candidat.toBuilder()
                .idSyndicat(candidatDto.getIdSyndicat())
                .poste(candidatDto.getPoste())
                .idEtudient(candidatDto.getIdEtudiant())
                .build();
    }
}
