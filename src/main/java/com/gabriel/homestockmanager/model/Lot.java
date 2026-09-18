package com.gabriel.homestockmanager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "lots")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    @JsonIgnoreProperties("lots")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "emplacement_id")
    private Emplacement emplacement;

    @Column(name = "date_peremption")
    private LocalDate datePeremption;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantite;

    @Column(name = "date_ajout", insertable = false, updatable = false)
    private LocalDateTime dateAjout;
    
    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mouvement> mouvements;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }

    public Emplacement getEmplacement() { return emplacement; }
    public void setEmplacement(Emplacement emplacement) { this.emplacement = emplacement; }

    public LocalDate getDatePeremption() { return datePeremption; }
    public void setDatePeremption(LocalDate datePeremption) { this.datePeremption = datePeremption; }

    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }

    public LocalDateTime getDateAjout() { return dateAjout; }
    
    public List<Mouvement> getMouvements() { return mouvements; }
    public void setMouvements(List<Mouvement> mouvements) { this.mouvements = mouvements; }
}