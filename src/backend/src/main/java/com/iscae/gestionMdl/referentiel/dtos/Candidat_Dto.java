package com.iscae.gestionMdl.referentiel.dtos;
import com.iscae.gestionMdl.data.entities.Candidat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Candidat_Dto {
    private int id;
    private int FK_Etudient;
    private int FK_Syndicat;
    private String nomEtud;
    private String nomSynd;



    private static Candidat toCandidatEntity_(Candidat_Dto candidat_dto, Candidat candidat) {
        return candidat.toBuilder()
                .id(candidat_dto.getId())
                .fkEtudient(candidat_dto.getFK_Etudient())
                .fkSyndicat(candidat_dto.getFK_Syndicat())
                .build();
    }
    public Candidat toCandidatEntity(Candidat_Dto candidatDto) {
        return toCandidatEntity_(candidatDto, new Candidat());
    }

    public Candidat toCandidatEntity(Candidat_Dto candidatDto, Candidat candidat) {
        return toCandidatEntity_(candidatDto, candidat);
    }


}
