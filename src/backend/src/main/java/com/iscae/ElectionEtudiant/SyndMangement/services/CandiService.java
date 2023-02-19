package com.iscae.gestionMdl.SyndMangement.services;

import com.iscae.gestionMdl.data.entities.CandidatEntity;
import com.iscae.gestionMdl.data.repository.Candidat1Repository;
import com.iscae.gestionMdl.SyndMangement.dtos.CandidatDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class CandiService {
    private final Candidat1Repository candidatRepo;

    public CandiService(Candidat1Repository candidatRepo) {

        this.candidatRepo = candidatRepo;
    }

    public List<CandidatDto> getCandidats(Integer idSynd) {
        return candidatRepo.findAllByIdSyndicat(idSynd).stream()
                .map(m -> m.toCandidatDto(m))
                .collect(Collectors.toList());
    }


    public void add(CandidatDto candidatDto) {

        candidatRepo.save(candidatDto.toCandidatEntity(candidatDto));
    }

    public void update(CandidatDto candidatDto, Integer id) {
        CandidatEntity candidat = candidatRepo.findById(id).orElseThrow();
        candidatRepo.save(candidatDto.toCandidatEntity(candidatDto, candidat));
    }

    public void delete(Integer id) {
        candidatRepo.deleteById(id);
    }
}
