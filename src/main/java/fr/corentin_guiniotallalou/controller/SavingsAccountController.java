package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.model.SavingsAccount;
import fr.corentin_guiniotallalou.service.SavingsAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savings-accounts")
public class SavingsAccountController {
    private final SavingsAccountService savingsAccountService;

    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    @GetMapping
    public List<SavingsAccount> getAllSavingsAccounts() {
        return savingsAccountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsAccount> getSavingsAccountById(@PathVariable Long id) {
        return savingsAccountService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-card")
    public ResponseEntity<SavingsAccount> getSavingsAccountWithCard(@PathVariable Long id) {
        return savingsAccountService.findByIdWithCard(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SavingsAccount createSavingsAccount(@RequestBody SavingsAccount account) {
        return savingsAccountService.save(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Long id) {
        savingsAccountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
