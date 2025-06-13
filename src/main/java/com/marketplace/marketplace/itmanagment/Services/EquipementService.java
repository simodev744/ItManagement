package com.marketplace.marketplace.itmanagment.Services;

import com.marketplace.marketplace.itmanagment.DTO.EquipementDto;
import com.marketplace.marketplace.itmanagment.Entity.Equipement;
import com.marketplace.marketplace.itmanagment.Mapper.EquipementMapper;
import com.marketplace.marketplace.itmanagment.Repositorie.EquipementRepo;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EquipementService {

    private final EquipementRepo equipementRepo;
    private final EquipementMapper equipementMapper;

    public EquipementService(EquipementRepo equipementRepo, EquipementMapper equipementMapper) {
        this.equipementRepo = equipementRepo;
        this.equipementMapper = equipementMapper;
    }
    public EquipementDto ajouterEquipement(EquipementDto equipementDto) {
        Equipement equipement = equipementMapper.toEntity(equipementDto);
        Equipement ajouterEquipment = equipementRepo.save(equipement);
        return equipementMapper.toDto(ajouterEquipment);
    }

    public List<EquipementDto> afficherEquipements() {
        return StreamSupport.stream(equipementRepo.findAll().spliterator(), false)
                .map(equipementMapper::toDto)
                .collect(Collectors.toList());
    }

    public EquipementDto AfficherParid(Long equipementId) {
        return equipementRepo.findById(equipementId).map(equipementMapper::toDto).orElse(null);
    }
    public EquipementDto ModifierEquipement(Long equipementId, EquipementDto equipementDto) {
        Equipement equipement = equipementRepo.findById(equipementId).get();
        equipement.setName(equipementDto.getName());
        equipement.setType(equipementDto.getType());
        equipement.setUtilisateurAffected(equipementDto.getUtilisateurAffected());
        equipementRepo.save(equipement);
        return equipementMapper.toDto(equipement);
    }
    public void deleteEquipement(Long equipementId) {
        equipementRepo.deleteById(equipementId);
    }
}
