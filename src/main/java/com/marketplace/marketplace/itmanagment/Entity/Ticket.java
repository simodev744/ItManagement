package com.marketplace.marketplace.itmanagment.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String description;
    private String statut;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @ManyToOne
    private Technicien technicien;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Admin admin;






}
