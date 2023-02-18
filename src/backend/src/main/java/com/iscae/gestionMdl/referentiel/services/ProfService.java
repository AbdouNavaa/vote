package com.iscae.gestionMdl.referentiel.services;

import com.iscae.gestionMdl.data.entities.MatiereEntity;
import com.iscae.gestionMdl.data.entities.ProfesseursEntity;
import com.iscae.gestionMdl.data.repository.MatiereRepository;
import com.iscae.gestionMdl.data.repository.ProfesseurRepository;
import com.iscae.gestionMdl.mdlMangement.dtos.MatiereDto;
import com.iscae.gestionMdl.referentiel.dtos.RefDto;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@Service
public class ProfService {
    private final ProfesseurRepository professeurRepository;

    public ProfService(ProfesseurRepository professeurRepository) {

        this.professeurRepository = professeurRepository;
    }

    public List<RefDto> getProfs() {
        return professeurRepository.findAll().stream()
                .map(m -> m.toProfesseurDto(m))
                .collect(Collectors.toList());
    }

// public void add(MatiereDto matiereDto) {
//        matiereRepository.save(matiereDto.toMatierEntity(matiereDto));
//    }
//
//    public void update(MatiereDto matiereDto, Integer id) {
//        MatiereEntity matiereEntity = matiereRepository.findById(id).orElseThrow();
//        matiereRepository.save(matiereDto.toMatierEntity(matiereDto, matiereEntity));
//    }

    public void add(RefDto refDto) {
        professeurRepository.save(refDto.toProfesseurEntity(refDto));
    }

    public void update(RefDto refDto, Integer id) {
        ProfesseursEntity professeursEntity = professeurRepository.findById(id).orElseThrow();
        professeurRepository.save(refDto.toProfesseurEntity(refDto, professeursEntity));
    }

    public void delete(Integer id) {
        professeurRepository.deleteById(id);
    }

}
