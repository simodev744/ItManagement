package com.marketplace.marketplace.itmanagment.Services;

import com.marketplace.marketplace.itmanagment.DTO.PanneDTO;
import com.marketplace.marketplace.itmanagment.Entity.Panne;
import com.marketplace.marketplace.itmanagment.Mapper.PanneMapper;
import com.marketplace.marketplace.itmanagment.Repositorie.PanneRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PanneService {
    private final PanneRepo panneRepo;
    private PanneMapper panneMapper;

    public PanneService(PanneMapper panneMapper, PanneRepo panneRepo) {
        this.panneMapper = panneMapper;
        this.panneRepo = panneRepo;
    }

    @Transactional
    public PanneDTO savePanne(PanneDTO panneDTO) {
        Panne panne = panneMapper.toPanne(panneDTO);
        Panne savedPanne = panneRepo.save(panne);
        return panneMapper.toPanneDTO(savedPanne);
    }

    public List<PanneDTO> getAllPannes() {
        return panneRepo.findAll().stream()
                .map(panneMapper::toPanneDTO)
                .collect(Collectors.toList());
    }

    public PanneDTO updatePanne(Long id, PanneDTO panneDTO) {
        Panne panne = panneRepo.findById(id).get();
        panne.setDescription(panneDTO.getDescription());
        panne.setDate(panneDTO.getDate());
        panne.setStatus(panneDTO.getStatus());
        panne.setEquipementId(panneDTO.getEquipementId());
        panneRepo.save(panne);
        return panneMapper.toPanneDTO(panne);
    }

    public void deletePanne(Long id) {
        panneRepo.deleteById(id);
    }


    public PanneDTO getPanneById(Long id) {
        return panneRepo.findById(id).map(panneMapper::toPanneDTO).orElse(null);
    }
}
