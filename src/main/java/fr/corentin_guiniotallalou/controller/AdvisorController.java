package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.dto.AdvisorDTO;
import fr.corentin_guiniotallalou.service.IAdvisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/advisors")
public class AdvisorController {
    private final IAdvisorService advisorService;

    public AdvisorController(IAdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @GetMapping
    public List<AdvisorDTO> getAllAdvisors() {
        return advisorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvisorDTO> getAdvisorById(@PathVariable Long id) {
        return advisorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-clients")
    public ResponseEntity<AdvisorDTO> getAdvisorWithClients(@PathVariable Long id) {
        return advisorService.findByIdWithClients(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdvisorDTO createAdvisor(@RequestBody AdvisorDTO advisorDTO) {
        return advisorService.save(advisorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvisor(@PathVariable Long id) {
        advisorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}