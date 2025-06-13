package com.marketplace.marketplace.itmanagment.Mapper;


import com.marketplace.marketplace.itmanagment.DTO.UtilisateurDTO;
import com.marketplace.marketplace.itmanagment.Entity.Utilisateur;

public class UtilisateurMapper {

    public static UtilisateurDTO toDTO(Utilisateur user) {
        if (user == null) return null;
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }
}
