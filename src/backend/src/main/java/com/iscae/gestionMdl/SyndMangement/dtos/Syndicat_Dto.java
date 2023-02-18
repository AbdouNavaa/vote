package com.iscae.gestionMdl.SyndMangement.dtos;

import com.iscae.gestionMdl.data.entities.Syndicat;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abderrahmane
 */
@Data
@Builder
public class Syndicat_Dto {
    private Integer id;
    private String syndicat_type;
    private String syndicat_nom;
    private String logo;

    public static Syndicat toSyndicatEntity(Syndicat_Dto mdlDto) {
        return Syndicat.builder()
                .id(mdlDto.getId())
                .syndicatNom(mdlDto.getSyndicat_nom())
                .syndicatType(mdlDto.getSyndicat_type())
                .build();
    }





}
