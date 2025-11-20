package fr.corentin_guiniotallalou.controller;

import fr.corentin_guiniotallalou.dto.SavingsAccountDTO;
import fr.corentin_guiniotallalou.service.ISavingsAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/savings-accounts")
public class SavingsAccountController {
    private final ISavingsAccountService savingsAccountService;

    public SavingsAccountController(ISavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }

    @GetMapping
    public List<SavingsAccountDTO> getAllSavingsAccounts() {
        return savingsAccountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsAccountDTO> getSavingsAccountById(@PathVariable Long id) {
        return savingsAccountService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/with-card")
    public ResponseEntity<SavingsAccountDTO> getSavingsAccountWithCard(@PathVariable Long id) {
        return savingsAccountService.findByIdWithCard(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SavingsAccountDTO createSavingsAccount(@RequestBody SavingsAccountDTO accountDTO) {
        return savingsAccountService.save(accountDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable Long id) {
        savingsAccountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}