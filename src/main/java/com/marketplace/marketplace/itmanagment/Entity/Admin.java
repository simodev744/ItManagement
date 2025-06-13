package com.marketplace.marketplace.itmanagment.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin extends Utilisateur{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String role;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Ticket> ticket;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Panne> panne;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipement> equipement;
}
