package com.marketplace.marketplace.itmanagment.Controllers;


import com.marketplace.marketplace.itmanagment.DTO.UtilisateurDTO;
import com.marketplace.marketplace.itmanagment.Entity.Utilisateur;
import com.marketplace.marketplace.itmanagment.Services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/inscription")
    public UtilisateurDTO inscrire(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.inscrire(utilisateur);
    }

    @GetMapping("/email")
    public UtilisateurDTO getByEmail(@RequestParam String email) {
        return utilisateurService.trouverParEmail(email);
    }

    @PutMapping("/{id}")
    public UtilisateurDTO mettreAJour(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.mettreAJourProfil(id, utilisateur);
    }
}
