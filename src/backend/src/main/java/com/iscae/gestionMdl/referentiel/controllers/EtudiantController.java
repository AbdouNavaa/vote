package com.iscae.gestionMdl.referentiel.controllers;

import com.iscae.gestionMdl.referentiel.dtos.EtudDto;
import com.iscae.gestionMdl.referentiel.services.EtudService;
import com.iscae.gestionMdl.referentiel.services.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abderrahmane
 */
@RestController
@RequestMapping("etudiant")
public class EtudiantController {
    @Autowired
    private final EtudService service;

    public EtudiantController(EtudService service) {
        this.service = service;
    }

    @GetMapping
    public List<EtudDto> getEtudiants() {
        return service.getEtudiants();
    }

    @PostMapping
    public void add(@RequestBody EtudDto etudDto) {
        service.add(etudDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody EtudDto etudDto, @PathVariable("id") Integer id) {
        service.update(etudDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
