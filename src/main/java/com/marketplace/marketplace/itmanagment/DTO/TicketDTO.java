package com.marketplace.marketplace.itmanagment.DTO;

import com.marketplace.marketplace.itmanagment.Entity.Priority;

import java.util.Date;

public class TicketDTO {
    Long id;
    String description;
    String statut;
    Priority priority;

    public TicketDTO() {
    }

    public TicketDTO(Long id, String description, String statut) {
        this.id = id;
        this.description = description;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
