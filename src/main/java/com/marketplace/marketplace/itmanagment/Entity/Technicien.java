package com.marketplace.marketplace.itmanagment.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Technicien extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String role;
    @OneToMany(mappedBy = "technicien", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Ticket> ticket;
}
