package com.marketplace.marketplace.itmanagment.Services;

import com.marketplace.marketplace.itmanagment.DTO.TicketDTO;
import com.marketplace.marketplace.itmanagment.Entity.Ticket;
import com.marketplace.marketplace.itmanagment.Mapper.TicketMapper;
import com.marketplace.marketplace.itmanagment.Repositorie.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    private final TicketRepo ticketRepo;


    private TicketMapper ticketMapper ;

    public TicketService(TicketRepo ticketRepo, TicketMapper ticketMapper) {
        this.ticketRepo = ticketRepo;
        this.ticketMapper = ticketMapper;
    }
    public TicketDTO ajouterTicket(TicketDTO tickerDto) {
       Ticket ticket = ticketMapper.dtoToTicket(tickerDto);
       Ticket ticket1 = ticketRepo.save(ticket);
       return ticketMapper.ticketToDto(ticket1);
    }

    public List<TicketDTO> listeTicket() {
        return ticketRepo.findAll().stream()
                .map(ticketMapper::ticketToDto)
                .collect(Collectors.toList());
    }

    public TicketDTO getEvenementById(Long id) {
        return ticketRepo.findById(id)
                .stream().map(ticketMapper::ticketToDto)
                .findAny().orElseThrow();
    }

    public TicketDTO updateTicket(Long id,TicketDTO ticketDTO) {
        Ticket ticket = (Ticket) ticketRepo.findById(id).get();
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setStatut(ticketDTO.getStatut());
        ticket.setPriority(ticketDTO.getPriority());
        return ticketMapper.ticketToDto(ticketRepo.save(ticket));

    }

    public void deleteTicket(Long id) {
        ticketRepo.deleteById(id);
    }
}
