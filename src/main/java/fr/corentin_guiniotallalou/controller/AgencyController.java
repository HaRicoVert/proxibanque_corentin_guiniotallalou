package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.dto.AgencyDTO;
import fr.corentin_guiniotallalou.service.IAgencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {
    private final IAgencyService agencyService;

    public AgencyController(IAgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public List<AgencyDTO> getAllAgencies() {
        return agencyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgencyDTO> getAgencyById(@PathVariable String id) {
        return agencyService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-advisors")
    public ResponseEntity<AgencyDTO> getAgencyWithAdvisors(@PathVariable String id) {
        return agencyService.findByIdWithAdvisors(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AgencyDTO createAgency(@RequestBody AgencyDTO agencyDTO) {
        return agencyService.save(agencyDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable String id) {
        agencyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}