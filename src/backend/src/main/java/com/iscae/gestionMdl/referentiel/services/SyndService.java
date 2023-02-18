package com.iscae.gestionMdl.referentiel.services;

import com.iscae.gestionMdl.data.entities.Syndicat;
import com.iscae.gestionMdl.data.repository.SyndicatRepo;
import com.iscae.gestionMdl.referentiel.dtos.SyndicatDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class SyndService {
    private final SyndicatRepo syndicatrepo;

    public SyndService(SyndicatRepo syndicatrepo) {

        this.syndicatrepo = syndicatrepo;
    }

    public List<SyndicatDto> getSyndicats() {
        return syndicatrepo.findAll().stream()
                .map(m -> m.toSyndicatDto(m))
                .collect(Collectors.toList());
    }


    public void add(SyndicatDto syndicatDto) {
        syndicatrepo.save(syndicatDto.toSyndicatDto(syndicatDto));
    }

    public void update(SyndicatDto syndicatDto, Integer id) {
        Syndicat syndicat = syndicatrepo.findById(id).orElseThrow();
        syndicatrepo.save(syndicatDto.toSyndicatDto(syndicatDto, syndicat));
    }

    public void delete(Integer id) {
        syndicatrepo.deleteById(id);
    }

}
