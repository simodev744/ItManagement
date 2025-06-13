package com.marketplace.marketplace.itmanagment.Repositorie;

import com.marketplace.marketplace.itmanagment.Entity.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
    // Additional query methods can be defined here if needed
}
