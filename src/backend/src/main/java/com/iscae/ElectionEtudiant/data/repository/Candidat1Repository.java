package com.iscae.gestionMdl.data.repository;

import com.iscae.gestionMdl.data.entities.CandidatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface Candidat1Repository
        extends JpaRepository<CandidatEntity, Integer> {

    List<CandidatEntity> findAllByIdSyndicat(Integer idSynd);

}
