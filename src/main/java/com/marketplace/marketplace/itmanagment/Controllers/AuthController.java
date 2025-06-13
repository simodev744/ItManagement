package com.marketplace.marketplace.itmanagment.Controllers;

import com.marketplace.marketplace.itmanagment.DTO.AuthRequest;
import com.marketplace.marketplace.itmanagment.DTO.AuthResponse;
import com.marketplace.marketplace.itmanagment.DTO.RegisterRequest;
import com.marketplace.marketplace.itmanagment.Entity.Admin;
import com.marketplace.marketplace.itmanagment.Entity.Client;
import com.marketplace.marketplace.itmanagment.Entity.Technicien;
import com.marketplace.marketplace.itmanagment.Entity.Utilisateur;
import com.marketplace.marketplace.itmanagment.Repositorie.ClientRepository;
import com.marketplace.marketplace.itmanagment.Repositorie.TechnicienRepository;
import com.marketplace.marketplace.itmanagment.Repositorie.UtilisateurRepository;
import com.marketplace.marketplace.itmanagment.Services.CustomUserDetailsService;
import com.marketplace.marketplace.itmanagment.config.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class AuthController {

 private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final UtilisateurRepository utilisateurRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final TechnicienRepository technicienRepository;



    public AuthController(
            AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService,
            UtilisateurRepository utilisateurRepository,
            JwtUtil jwtUtil, PasswordEncoder passwordEncoder, ClientRepository clientRepository, TechnicienRepository technicienRepository) {
        this.authenticationManager = authenticationManager;

        this.userDetailsService = userDetailsService;
        this.utilisateurRepository = utilisateurRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.clientRepository = clientRepository;
        this.technicienRepository = technicienRepository;
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> getdata() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "data");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        System.out.println(userDetails);
        String token = jwtUtil.generateToken(userDetails);
        System.out.println(token);
        return new AuthResponse(token);
    }

    @PostMapping("/register")
    public  ResponseEntity<Map<String, String>>register(@RequestBody RegisterRequest request) {
        Utilisateur user;
        if ("ADMINISTRATEUR".equals(request.getRole())) {
            user = new Admin();
            user.setNom(request.getNom());
            user.setEmail(request.getEmail());
            user.setMotDePasse(passwordEncoder.encode(request.getPassword()));
            user.setRole(request.getRole());
            utilisateurRepository.save(user);
            Map<String, String> response = new HashMap<>();
            response.put("message", "inscription reussie");
            return ResponseEntity.ok(response);

        }

        if ("CLIENT".equals(request.getRole())) {
            Client client= new Client();
            client.setNom(request.getNom());
            client.setEmail(request.getEmail());
            client.setMotDePasse(passwordEncoder.encode(request.getPassword()));
            client.setRole(request.getRole());

            clientRepository.save(client);
            Map<String, String> response = new HashMap<>();
            response.put("message", "inscription reussie");
            return ResponseEntity.ok(response);

        }


        if ("TECHNICIEN".equals(request.getRole())) {
            Technicien technicien= new Technicien();
            technicien.setNom(request.getNom());
            technicien.setEmail(request.getEmail());
            technicien.setMotDePasse(passwordEncoder.encode(request.getPassword()));
            technicien.setRole(request.getRole());

            technicienRepository.save(technicien);
            Map<String, String> response = new HashMap<>();
            response.put("message", "inscription reussie");
            return ResponseEntity.ok(response);

        }

   return null;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Déconnecté");
    }
}
