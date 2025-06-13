package com.marketplace.marketplace.itmanagment.Mapper;


import com.marketplace.marketplace.itmanagment.DTO.ClientDTO;
import com.marketplace.marketplace.itmanagment.Entity.Client;

public class ClientMapper {

    public static ClientDTO toDTO(Client client) {
        if (client == null) return null;
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        dto.setRole(client.getRole());
        return dto;
    }

    public static Client toEntity(ClientDTO dto) {
        if (dto == null) return null;
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        client.setRole(dto.getRole());
        return client;
    }
}
