package com.gabriel.homestockmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.homestockmanager.model.Emplacement;

public interface EmplacementRepository extends JpaRepository<Emplacement, Integer> {
}