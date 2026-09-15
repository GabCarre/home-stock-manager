package com.gabriel.homestockmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.homestockmanager.model.Mouvement;

public interface MouvementRepository extends JpaRepository<Mouvement, Integer> {
}