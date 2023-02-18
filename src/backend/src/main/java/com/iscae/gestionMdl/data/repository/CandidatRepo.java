package com.iscae.gestionMdl.data.repository;

import com.iscae.gestionMdl.data.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface CandidatRepo
        extends JpaRepository<Candidat, Integer> {


}
