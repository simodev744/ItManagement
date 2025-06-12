package com.marketplace.marketplace.itmanagment.Services;

import com.marketplace.marketplace.itmanagment.Mapper.EquipementMapper;
import com.marketplace.marketplace.itmanagment.Repositorie.EquipementRepo;
import org.springframework.stereotype.Service;

@Service
public class EquipementService {

    private final EquipementRepo equipementRepo;
    private final EquipementMapper equipementMapper;

    public EquipementService(EquipementRepo equipementRepo, EquipementMapper equipementMapper) {
        this.equipementRepo = equipementRepo;
        this.equipementMapper = equipementMapper;
    }
}
