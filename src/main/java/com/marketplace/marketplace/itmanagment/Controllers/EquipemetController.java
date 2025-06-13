package com.marketplace.marketplace.itmanagment.Controllers;

import com.marketplace.marketplace.itmanagment.DTO.EquipementDto;
import com.marketplace.marketplace.itmanagment.Services.EquipementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipment")
public class EquipemetController {
    public EquipementService equipementService;

    public EquipemetController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @GetMapping
    public List<EquipementDto> getAll() {
        return equipementService.afficherEquipements();
    }

    @PostMapping
    public EquipementDto create(@RequestBody EquipementDto equipementDto) {
        return equipementService.ajouterEquipement(equipementDto);
    }
    @GetMapping("{id}")
    public EquipementDto getById(@PathVariable("id") Long id) {
        return equipementService.AfficherParid(id);
    }

    @PutMapping("{id}")
    public EquipementDto update(@PathVariable  Long id,@RequestBody EquipementDto equipementDto) {
        return equipementService.ModifierEquipement(id, equipementDto);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
    }
}
