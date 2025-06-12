package com.marketplace.marketplace.itmanagment.DTO;



public class EquipementDto   {
    Long id;
    String name;
    String type;
    String UtilisateurAffected;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUtilisateurAffected(String utilisateurAffected) {
        UtilisateurAffected = utilisateurAffected;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUtilisateurAffected() {
        return UtilisateurAffected;
    }
}