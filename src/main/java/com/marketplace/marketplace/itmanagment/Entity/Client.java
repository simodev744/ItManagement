package com.marketplace.marketplace.itmanagment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String role;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Ticket> ticket;
}
