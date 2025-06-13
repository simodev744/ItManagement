package com.marketplace.marketplace.itmanagment.Mapper;


import com.marketplace.marketplace.itmanagment.DTO.PanneDTO;
import com.marketplace.marketplace.itmanagment.Entity.Panne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PanneMapper {
    PanneDTO toPanneDTO(Panne panne);
    Panne toPanne(PanneDTO panneDTO);
}
