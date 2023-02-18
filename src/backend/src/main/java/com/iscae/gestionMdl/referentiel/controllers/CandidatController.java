package com.iscae.gestionMdl.referentiel.controllers;

import com.iscae.gestionMdl.referentiel.dtos.Candidat_Dto;
import com.iscae.gestionMdl.referentiel.dtos.SyndicatDto;
import com.iscae.gestionMdl.referentiel.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abderrahmane
 */
@RestController
@RequestMapping("candidat")
public class CandidatController {
    @Autowired
    private final CandidatService service;

    public CandidatController(CandidatService service) {
        this.service = service;
    }

    @GetMapping
    public List<Candidat_Dto> getSyndicats() {
        return service.getCandidats();
    }

    @PostMapping
    public void add(@RequestBody Candidat_Dto candidatDto) {
        service.add(candidatDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Candidat_Dto candidatDto, @PathVariable("id") Integer id) {
        service.update(candidatDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
