    package com.marketplace.marketplace.itmanagment.Mapper;

    import com.marketplace.marketplace.itmanagment.DTO.EquipementDto;
    import com.marketplace.marketplace.itmanagment.Entity.Equipement;
    import org.mapstruct.Mapper;

    @Mapper
    public interface EquipementMapper {
            EquipementDto toDto(Equipement equipment);
            Equipement toEntity(EquipementDto equipmentDto);
    }
