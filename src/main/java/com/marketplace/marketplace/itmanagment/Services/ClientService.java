package com.marketplace.marketplace.itmanagment.Services;



import com.marketplace.marketplace.itmanagment.DTO.ClientDTO;
import com.marketplace.marketplace.itmanagment.Entity.Client;
import com.marketplace.marketplace.itmanagment.Mapper.ClientMapper;
import com.marketplace.marketplace.itmanagment.Repositorie.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO obtenirParId(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDTO)
                .orElse(null);
    }

    public List<ClientDTO> listerClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO creerClient(Client client) {
        Client saved = clientRepository.save(client);
        return ClientMapper.toDTO(saved);
    }

    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }
}
