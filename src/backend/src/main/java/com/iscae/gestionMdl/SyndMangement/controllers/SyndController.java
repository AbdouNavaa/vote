package com.iscae.gestionMdl.SyndMangement.controllers;

import com.iscae.gestionMdl.SyndMangement.dtos.Syndicat_Dto;
import com.iscae.gestionMdl.SyndMangement.services.SyndicatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
