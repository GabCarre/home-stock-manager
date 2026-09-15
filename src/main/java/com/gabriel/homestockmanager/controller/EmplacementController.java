package com.gabriel.homestockmanager.controller;

import com.gabriel.homestockmanager.model.Emplacement;
import com.gabriel.homestockmanager.repository.EmplacementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplacements")
@CrossOrigin
public class EmplacementController {

    private final EmplacementRepository emplacementRepository;

    public EmplacementController(EmplacementRepository emplacementRepository) {
        this.emplacementRepository = emplacementRepository;
    }

    @GetMapping
    public List<Emplacement> lister() {
        return emplacementRepository.findAll();
    }

    @PostMapping
    public Emplacement creer(@RequestBody Emplacement emplacement) {
        return emplacementRepository.save(emplacement);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Integer id) {
        emplacementRepository.deleteById(id);
    }
}