package com.marketplace.marketplace.itmanagment.Repositorie;


import com.marketplace.marketplace.itmanagment.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministrateurRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}
