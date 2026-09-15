package com.gabriel.homestockmanager.controller;

import com.gabriel.homestockmanager.model.Lot;
import com.gabriel.homestockmanager.model.Mouvement;
import com.gabriel.homestockmanager.repository.LotRepository;
import com.gabriel.homestockmanager.repository.MouvementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lots")
@CrossOrigin
public class LotController {

    private final LotRepository lotRepository;
    private final MouvementRepository mouvementRepository;

    public LotController(LotRepository lotRepository, MouvementRepository mouvementRepository) {
        this.lotRepository = lotRepository;
        this.mouvementRepository = mouvementRepository;
    }

    @GetMapping
    public List<Lot> lister() {
        return lotRepository.findAll();
    }

    @PostMapping
    public Lot creer(@RequestBody Lot lot) {
        Lot lotEnregistre = lotRepository.save(lot);

        // Journalisation automatique de l'entrée en stock
        Mouvement mouvement = new Mouvement();
        mouvement.setLot(lotEnregistre);
        mouvement.setType(Mouvement.Type.entree);
        mouvement.setQuantite(lotEnregistre.getQuantite());
        mouvementRepository.save(mouvement);

        return lotEnregistre;
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Integer id) {
        lotRepository.deleteById(id);
    }
}