package com.iscae.gestionMdl.referentiel.dtos;

import com.iscae.gestionMdl.data.entities.MatiereEntity;
import com.iscae.gestionMdl.data.entities.ProfesseursEntity;
import com.iscae.gestionMdl.mdlMangement.dtos.MatiereDto;
import lombok.Builder;
import lombok.Data;

import java.sql.Ref;

/**
 * @author Abderrahmane
 */
@Builder
@Data
public class RefDto {
   private Integer id;
   private String nom;
   private String prenom;

   private static ProfesseursEntity toProfesseurEntity_(RefDto refDto, ProfesseursEntity professeursEntity) {
      return professeursEntity.toBuilder()
              .nom(refDto.getNom())
              .prenom(refDto.getPrenom())
              .build();
   }
   public ProfesseursEntity toProfesseurEntity(RefDto refDto) {
      return toProfesseurEntity_(refDto, new ProfesseursEntity());
   }

   public ProfesseursEntity toProfesseurEntity(RefDto refDto, ProfesseursEntity professeursEntity) {
      return toProfesseurEntity_(refDto, professeursEntity);
   }


}
