package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.dto.CurrentAccountDTO;
import fr.corentin_guiniotallalou.service.ICurrentAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/current-accounts")
public class CurrentAccountController {
    private final ICurrentAccountService currentAccountService;

    public CurrentAccountController(ICurrentAccountService currentAccountService) {
        this.currentAccountService = currentAccountService;
    }

    @GetMapping
    public List<CurrentAccountDTO> getAllCurrentAccounts() {
        return currentAccountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrentAccountDTO> getCurrentAccountById(@PathVariable Long id) {
        return currentAccountService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-card")
    public ResponseEntity<CurrentAccountDTO> getCurrentAccountWithCard(@PathVariable Long id) {
        return currentAccountService.findByIdWithCard(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CurrentAccountDTO createCurrentAccount(@RequestBody CurrentAccountDTO accountDTO) {
        return currentAccountService.save(accountDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrentAccount(@PathVariable Long id) {
        currentAccountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}