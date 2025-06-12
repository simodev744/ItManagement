package com.marketplace.marketplace.itmanagment.DTO;

import java.util.Date;

public class PanneDTO {
    private Long id;
    private String description;
    private Date date;
    private String status;
    private String equipementId;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEquipementId() {
        return equipementId;
    }

    public void setEquipementId(String equipementId) {
        this.equipementId = equipementId;
    }
}
