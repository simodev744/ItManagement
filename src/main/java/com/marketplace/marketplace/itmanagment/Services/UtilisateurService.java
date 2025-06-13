package com.marketplace.marketplace.itmanagment.Services;

import com.marketplace.marketplace.itmanagment.DTO.UtilisateurDTO;
import com.marketplace.marketplace.itmanagment.Entity.Utilisateur;
import com.marketplace.marketplace.itmanagment.Mapper.UtilisateurMapper;
import com.marketplace.marketplace.itmanagment.Repositorie.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public UtilisateurDTO inscrire(Utilisateur utilisateur) {
        Utilisateur saved = utilisateurRepository.save(utilisateur);
        return UtilisateurMapper.toDTO(saved);
    }

    public UtilisateurDTO trouverParEmail(String email) {
        Optional<Utilisateur> opt = utilisateurRepository.findByEmail(email);
        return opt.map(UtilisateurMapper::toDTO).orElse(null);
    }

    public UtilisateurDTO mettreAJourProfil(Long id, Utilisateur utilisateurMisAJour) {
        return utilisateurRepository.findById(id).map(utilisateur -> {
            utilisateur.setNom(utilisateurMisAJour.getNom());
            utilisateur.setEmail(utilisateurMisAJour.getEmail());
            utilisateur.setMotDePasse(utilisateurMisAJour.getMotDePasse());
            Utilisateur updated = utilisateurRepository.save(utilisateur);
            return UtilisateurMapper.toDTO(updated);
        }).orElse(null);
    }

}
