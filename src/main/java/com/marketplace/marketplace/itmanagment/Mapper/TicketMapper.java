package com.marketplace.marketplace.itmanagment.Mapper;

import com.marketplace.marketplace.itmanagment.DTO.TicketDTO;
import com.marketplace.marketplace.itmanagment.Entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    TicketDTO ticketToDto(Ticket ticket);
    Ticket dtoToTicket(TicketDTO ticketDTO);
}
