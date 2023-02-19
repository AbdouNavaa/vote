package com.iscae.gestionMdl.referentiel.services;

import com.iscae.gestionMdl.data.entities.Etudient;
import com.iscae.gestionMdl.data.repository.EtudRepo;
import com.iscae.gestionMdl.referentiel.dtos.EtudDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class EtudService {
    private final EtudRepo etudRepo;

    public EtudService(EtudRepo etudRepo) {

        this.etudRepo = etudRepo;
    }

    public List<EtudDto> getEtudiants() {
        return etudRepo.findAll().stream()
                .map(m -> m.toEtudDto(m))
                .collect(Collectors.toList());
    }


    public void add(EtudDto etudDto) {
        etudRepo.save(etudDto.toEtudEntity(etudDto));
    }

    public void update(EtudDto etudDto, Integer id) {
        Etudient etudient = etudRepo.findById(id).orElseThrow();
        etudRepo.save(etudDto.toEtudEntity(etudDto, etudient));
    }

    public void delete(Integer id) {
        etudRepo.deleteById(id);
    }

}
