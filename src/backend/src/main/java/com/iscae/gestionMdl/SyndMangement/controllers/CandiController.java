package com.iscae.gestionMdl.SyndMangement.controllers;

import com.iscae.gestionMdl.SyndMangement.dtos.CandidatDto;
import com.iscae.gestionMdl.SyndMangement.services.CandiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abderrahmane
 */
@RestController
@RequestMapping("gest-candidat")
public class CandiController {
    @Autowired
    private final CandiService candidatService;

    public CandiController(CandiService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping
    public List<CandidatDto> getMatieres(@RequestParam("idSynd") Integer idSynd) {
        return candidatService.getCandidats(idSynd);
    }

    @PostMapping
    public void add(@RequestBody CandidatDto candidatDto) {
        candidatService.add(candidatDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CandidatDto candidatDto, @PathVariable("id") Integer id) {
        candidatService.update(candidatDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        candidatService.delete(id);
    }



}
