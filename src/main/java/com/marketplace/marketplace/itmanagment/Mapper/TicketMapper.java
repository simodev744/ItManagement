package com.marketplace.marketplace.itmanagment.Mapper;

import com.marketplace.marketplace.itmanagment.DTO.TicketDTO;
import com.marketplace.marketplace.itmanagment.Entity.Ticket;

public interface TicketMapper {
    TicketDTO tickerToDto(Ticket ticket);
    Ticket dtoToTicker(TicketDTO ticketDTO);
}
