package com.gabriel.homestockmanager.controller;

import com.gabriel.homestockmanager.model.Categorie;
import com.gabriel.homestockmanager.repository.CategorieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategorieController {

    private final CategorieRepository categorieRepository;

    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @GetMapping
    public List<Categorie> lister() {
        return categorieRepository.findAll();
    }

    @PostMapping
    public Categorie creer(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Integer id) {
        categorieRepository.deleteById(id);
    }
}