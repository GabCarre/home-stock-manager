package com.gabriel.homestockmanager.controller;

import com.gabriel.homestockmanager.model.Produit;
import com.gabriel.homestockmanager.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin
public class ProduitController {

    private final ProduitRepository produitRepository;

    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping
    public List<Produit> lister() {
        return produitRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produit obtenir(@PathVariable Integer id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable : " + id));
    }

    @PostMapping
    public Produit creer(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @PutMapping("/{id}")
    public Produit modifier(@PathVariable Integer id, @RequestBody Produit donnees) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable : " + id));

        produit.setNom(donnees.getNom());
        produit.setCodeBarre(donnees.getCodeBarre());
        produit.setCategorie(donnees.getCategorie());
        produit.setUnite(donnees.getUnite());
        produit.setSeuilAlerte(donnees.getSeuilAlerte());

        return produitRepository.save(produit);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Integer id) {
        produitRepository.deleteById(id);
    }
}