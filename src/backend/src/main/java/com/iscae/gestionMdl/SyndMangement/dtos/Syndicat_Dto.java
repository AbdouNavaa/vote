package com.iscae.gestionMdl.SyndMangement.dtos;

import com.iscae.gestionMdl.data.entities.SyndicatEntity;
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


     public Syndicat_Dto() {
    }
//
    public Syndicat_Dto(int id, String syndicat_type, String syndicat_nom, String logo) {
        this.id = id;
        this.syndicat_type = syndicat_type;
        this.syndicat_nom = syndicat_nom;
        this.logo = logo;
    }
//
    private static SyndicatEntity toSyndicatDto_(Syndicat_Dto syndicatDto, SyndicatEntity syndicat) {
        return syndicat.toBuilder()
                .syndicat_type(syndicatDto.getSyndicat_type())
                .syndicat_nom(syndicatDto.getSyndicat_nom())
                .logo(syndicatDto.getLogo())
                .build();
    }
    public SyndicatEntity toSyndicatDto(Syndicat_Dto syndicatDto) {

        return toSyndicatDto_(syndicatDto, new SyndicatEntity());
    }
//
    public SyndicatEntity toSyndicatDto(Syndicat_Dto syndicatDto, SyndicatEntity syndicat) {
        return toSyndicatDto_(syndicatDto, syndicat);
    }
//    public static SyndicatEntity toSyndicatEntity_(Syndicat_Dto mdlDto, SyndicatEntity syndicat) {
//        return syndicat.toBuilder()
//                .id(mdlDto.getId())
//                .syndicat_nom(mdlDto.getSyndicat_nom())
//                .syndicat_type(mdlDto.getSyndicat_type())
//                .logo(mdlDto.getLogo())
//                .build();
//    }
//
//
//    public SyndicatEntity toSyndicatEntity(Syndicat_Dto syndicatDto) {
//
//        return toSyndicatEntity_(syndicatDto, new SyndicatEntity());
//    }
//
//    public SyndicatEntity toSyndicatEntity(Syndicat_Dto syndicatDto, SyndicatEntity syndicat) {
//        return toSyndicatEntity_(syndicatDto, syndicat);
//    }
}
