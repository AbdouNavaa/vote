package com.iscae.gestionMdl.SyndMangement.services;

import com.iscae.gestionMdl.SyndMangement.dtos.Syndicat_Dto;
import com.iscae.gestionMdl.data.repository.SyndRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class SyndicatService {
    private final SyndRepository syndRepo;

    public SyndicatService(SyndRepository syndRepo) {
        this.syndRepo = syndRepo;
    }

    public List<Syndicat_Dto> getSynds() {
        return syndRepo.findAll().stream()
                .map(m -> m.toSyndicatDto(m))
                .collect(Collectors.toList());
    }


}
