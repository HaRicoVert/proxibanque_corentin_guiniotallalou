package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.model.CurrentAccount;
import fr.corentin_guiniotallalou.service.CurrentAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/current-accounts")
public class CurrentAccountController {
    private final CurrentAccountService currentAccountService;

    public CurrentAccountController(CurrentAccountService currentAccountService) {
        this.currentAccountService = currentAccountService;
    }

    @GetMapping
    public List<CurrentAccount> getAllCurrentAccounts() {
        return currentAccountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrentAccount> getCurrentAccountById(@PathVariable Long id) {
        return currentAccountService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-card")
    public ResponseEntity<CurrentAccount> getCurrentAccountWithCard(@PathVariable Long id) {
        return currentAccountService.findByIdWithCard(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CurrentAccount createCurrentAccount(@RequestBody CurrentAccount account) {
        return currentAccountService.save(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrentAccount(@PathVariable Long id) {
        currentAccountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}