package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.SavingsAccount;

import java.util.List;
import java.util.Optional;

public interface ISavingsAccountService {
    List<SavingsAccount> findAll();
    Optional<SavingsAccount> findById(Long id);
    Optional<SavingsAccount> findByIdWithCard(Long id);
    SavingsAccount save(SavingsAccount account);
    void deleteById(Long id);
}
