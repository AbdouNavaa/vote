package com.iscae.gestionMdl.referentiel.controllers;

import com.iscae.gestionMdl.data.entities.ProfesseursEntity;
import com.iscae.gestionMdl.mdlMangement.dtos.MdlDto;
import com.iscae.gestionMdl.referentiel.dtos.RefDto;
import com.iscae.gestionMdl.referentiel.services.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Ref;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abderrahmane
 */
@RestController
@RequestMapping("referentiel")
public class ReferentielController {
    @Autowired
    private final ProfService service;

    public ReferentielController(  ProfService service) {
        this.service = service;
    }

    @GetMapping("professeurs")
//    public List<ProfesseursEntity> getProfesseurs() {
//        return service.getProfs().stream()
//                .map(p -> p.toProfesseurEntity(p)).collect(Collectors.toList());
//    }
    public List<RefDto> getProfesseurs() {
        return service.getProfs();
    }

    @PostMapping
    public void add(@RequestBody RefDto refDto) {
        service.add(refDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody RefDto refDto, @PathVariable("id") Integer id) {
        service.update(refDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
