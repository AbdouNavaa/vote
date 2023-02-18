package com.iscae.gestionMdl.referentiel.controllers;

import com.iscae.gestionMdl.referentiel.dtos.SyndicatDto;
import com.iscae.gestionMdl.referentiel.services.SyndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abderrahmane
 */
@RestController
@RequestMapping("synducat")
public class SyndicatController {
    @Autowired
    private final SyndService service;

    public SyndicatController(SyndService service) {
        this.service = service;
    }

    @GetMapping
    public List<SyndicatDto> getSyndicats() {
        return service.getSyndicats();
    }

    @PostMapping
    public void add(@RequestBody SyndicatDto syndicatDto) {
        service.add(syndicatDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody SyndicatDto syndicatDto, @PathVariable("id") Integer id) {
        service.update(syndicatDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
