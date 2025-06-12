package com.marketplace.marketplace.itmanagment.Repositorie;

import com.marketplace.marketplace.itmanagment.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {
}
