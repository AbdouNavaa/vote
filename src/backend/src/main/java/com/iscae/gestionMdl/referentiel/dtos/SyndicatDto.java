package com.iscae.gestionMdl.referentiel.dtos;
import com.iscae.gestionMdl.data.entities.Syndicat;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class SyndicatDto {
    private int id;
    private String syndicat_type;
    private String syndicat_nom;
    private String logo;

    public SyndicatDto() {
    }

    public SyndicatDto(int id, String syndicat_type, String syndicat_nom, String logo) {
        this.id = id;
        this.syndicat_type = syndicat_type;
        this.syndicat_nom = syndicat_nom;
        this.logo = logo;
    }

    private static Syndicat toSyndicatDto_(SyndicatDto syndicatDto, Syndicat syndicat) {
        return syndicat.toBuilder()
                .syndicatType(syndicatDto.getSyndicat_type())
                .syndicatNom(syndicatDto.getSyndicat_nom())
                .logo(syndicatDto.getLogo())
                .build();
    }
    public Syndicat toSyndicatDto(SyndicatDto syndicatDto) {

        return toSyndicatDto_(syndicatDto, new Syndicat());
    }

    public Syndicat toSyndicatDto(SyndicatDto syndicatDto, Syndicat syndicat) {
        return toSyndicatDto_(syndicatDto, syndicat);
    }

}
