package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.model.Agency;
import fr.corentin_guiniotallalou.service.AgencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public List<Agency> getAllAgencies() {
        return agencyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable String id) {
        return agencyService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-advisors")
    public ResponseEntity<Agency> getAgencyWithAdvisors(@PathVariable String id) {
        return agencyService.findByIdWithAdvisors(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agency createAgency(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable String id) {
        agencyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}