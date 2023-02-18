package com.iscae.gestionMdl.referentiel.services;

import com.iscae.gestionMdl.data.entities.Candidat;
import com.iscae.gestionMdl.data.repository.CandidatRepo;
import com.iscae.gestionMdl.referentiel.dtos.Candidat_Dto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class CandidatService {
    private final CandidatRepo candidatrepo;

    public CandidatService(CandidatRepo candidatrepo) {

        this.candidatrepo = candidatrepo;
    }

    public List<Candidat_Dto> getCandidats() {
        return candidatrepo.findAll().stream()
                .map(m -> m.toCandidatDto(m))
                .collect(Collectors.toList());
    }


    public void add(Candidat_Dto candidatDto) {
        candidatrepo.save(candidatDto.toCandidatEntity(candidatDto));
    }

    public void update(Candidat_Dto candidatDto, Integer id) {
        Candidat candidat = candidatrepo.findById(id).orElseThrow();
        candidatrepo.save(candidatDto.toCandidatEntity(candidatDto, candidat));
    }

    public void delete(Integer id) {
        candidatrepo.deleteById(id);
    }

}
