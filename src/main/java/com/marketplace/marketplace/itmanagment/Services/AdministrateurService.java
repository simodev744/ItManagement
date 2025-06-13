package com.marketplace.marketplace.itmanagment.Services;

;
import com.marketplace.marketplace.itmanagment.DTO.AdministrateurDTO;
import com.marketplace.marketplace.itmanagment.Entity.Admin;
import com.marketplace.marketplace.itmanagment.Mapper.AdministrateurMapper;
import com.marketplace.marketplace.itmanagment.Repositorie.AdministrateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministrateurService {

    private final AdministrateurRepository administrateurRepository;

    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public AdministrateurDTO obtenirParId(Long id) {
        return administrateurRepository.findById(id)
                .map(AdministrateurMapper::toDTO)
                .orElse(null);
    }

    public List<AdministrateurDTO> listerAdministrateurs() {
        return administrateurRepository.findAll()
                .stream()
                .map(AdministrateurMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AdministrateurDTO creerAdministrateur(Admin administrateur) {
        Admin saved = administrateurRepository.save(administrateur);
        return AdministrateurMapper.toDTO(saved);
    }

    public void supprimerAdministrateur(Long id) {
        administrateurRepository.deleteById(id);
    }
}
