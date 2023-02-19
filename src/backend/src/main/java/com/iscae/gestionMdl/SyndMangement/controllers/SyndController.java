package com.iscae.gestionMdl.SyndMangement.controllers;

import com.iscae.gestionMdl.SyndMangement.dtos.Syndicat_Dto;
import com.iscae.gestionMdl.SyndMangement.services.SyndicatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abderrahmane
 */
@RestController
@RequestMapping("gest-synd")
public class SyndController {
    @Autowired
    private final SyndicatService service;

    public SyndController(SyndicatService service) {
        this.service = service;
    }

    @GetMapping
    public List<Syndicat_Dto> getModules() {
        return service.getSynds();
    }



    @PostMapping
    public void add(@RequestBody Syndicat_Dto syndicat_Dto) {
        service.add(syndicat_Dto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Syndicat_Dto syndicat_Dto, @PathVariable("id") Integer id) {
        service.update(syndicat_Dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
