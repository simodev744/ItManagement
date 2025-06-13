package com.marketplace.marketplace.itmanagment.Mapper;


import com.marketplace.marketplace.itmanagment.DTO.AdministrateurDTO;
import com.marketplace.marketplace.itmanagment.Entity.Admin;

public class AdministrateurMapper {

    public static AdministrateurDTO toDTO(Admin admin) {
        if (admin == null) return null;
        AdministrateurDTO dto = new AdministrateurDTO();
        dto.setId(admin.getId());
        dto.setNom(admin.getNom());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());
        return dto;
    }

    public Admin toEntity(AdministrateurDTO dto) {
        if (dto == null) return null;
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setNom(dto.getNom());
        admin.setEmail(dto.getEmail());
        admin.setRole(dto.getRole());
        return admin;
    }
}
