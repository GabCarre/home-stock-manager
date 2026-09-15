package com.gabriel.homestockmanager.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "mouvements")
public class Mouvement {

    public enum Type { entree, sortie }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lot_id", nullable = false)
    private Lot lot;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantite;

    @Column(name = "date_mouvement", insertable = false, updatable = false)
    private LocalDateTime dateMouvement;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Lot getLot() { return lot; }
    public void setLot(Lot lot) { this.lot = lot; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }

    public LocalDateTime getDateMouvement() { return dateMouvement; }
}
