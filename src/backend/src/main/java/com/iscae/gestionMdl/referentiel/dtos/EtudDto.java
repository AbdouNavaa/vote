package com.iscae.gestionMdl.referentiel.dtos;

import com.iscae.gestionMdl.data.entities.Etudient;
import com.iscae.gestionMdl.data.entities.Etudient;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abderrahmane
 */
@Builder
@Data
public class EtudDto {
   private Integer id;
   private int ine;
   private String nom;
   private String prenom;
   private String date;
   private String email;
   private String password;
   private String inscription;
   private String niveau;
   private String etablisement;

   private static Etudient toEtudEntity_(EtudDto etudDto, Etudient etudient) {
      return etudient.toBuilder()
              .ine(etudDto.getIne())
              .nom(etudDto.getNom())
              .prenom(etudDto.getPrenom())
              .date(etudDto.getDate())
              .email(etudDto.getEmail())
              .password(etudDto.getPassword())
              .inscription(etudDto.getInscription())
              .niveau(etudDto.getNiveau())
              .etablisement(etudDto.getEtablisement())
              .build();
   }
   public Etudient toEtudEntity(EtudDto etudDto) {
      return toEtudEntity_(etudDto, new Etudient());
   }

   public Etudient toEtudEntity(EtudDto etudDto, Etudient etudient) {
      return toEtudEntity_(etudDto, etudient);
   }


}
