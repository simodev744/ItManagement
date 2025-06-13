package com.marketplace.marketplace.itmanagment.Controllers;


import com.marketplace.marketplace.itmanagment.DTO.TicketDTO;
import com.marketplace.marketplace.itmanagment.Services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/ticket")

public class TicketController {

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    private final TicketService ticketService;


    @PostMapping
    public TicketDTO addTicket(@RequestBody TicketDTO ticketdto) {
        return ticketService.ajouterTicket(ticketdto);
    }
    @GetMapping
    public List<TicketDTO> getAllTicket(){
        return ticketService.listeTicket();
    }
    @GetMapping("/{id}")
    public TicketDTO getTicketById(@PathVariable Long id ) {
        return  ticketService.getEvenementById(id);
    }
    @PutMapping("/{id}")
    public TicketDTO updatTicket(@PathVariable Long id ,@RequestBody TicketDTO ticketdto) {
        return ticketService.updateTicket(id,ticketdto);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id ) {
        ticketService.deleteTicket(id);
    }


}
