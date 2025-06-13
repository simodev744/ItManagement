package com.marketplace.marketplace.itmanagment.Controllers;

import com.marketplace.marketplace.itmanagment.DTO.PanneDTO;
import com.marketplace.marketplace.itmanagment.Repositorie.PanneRepo;
import com.marketplace.marketplace.itmanagment.Services.PanneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/panne")
public class PanneController {

    public PanneService panneService;

    public PanneController(PanneService panneService) {
        this.panneService = panneService;
    }
    @GetMapping
    public List<PanneDTO> getAllPannes() {
        return panneService.getAllPannes();
    }

    @PostMapping
    public PanneDTO createPanne(@RequestBody PanneDTO panneDTO) {
        return panneService.savePanne(panneDTO);
    }

    @GetMapping("/{id}")
    public PanneDTO getPanneById(@PathVariable ("id") Long id) {
        return panneService.getPanneById(id);
    }

    @PutMapping("{id}")
    public PanneDTO updatePanne(@PathVariable Long id, @RequestBody PanneDTO panneDTO) {
        return panneService.updatePanne(id, panneDTO);
    }

    @DeleteMapping("{id}")
    public void deletePanne(@PathVariable Long id) {
        panneService.deletePanne(id);
    }
}
