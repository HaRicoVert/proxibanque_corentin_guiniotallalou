package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.SavingsAccount;
import fr.corentin_guiniotallalou.repository.SavingsAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SavingsAccountService {
    private final SavingsAccountRepository savingsAccountRepository;

    public SavingsAccountService(SavingsAccountRepository savingsAccountRepository) {
        this.savingsAccountRepository = savingsAccountRepository;
    }

    public List<SavingsAccount> findAll() {
        return savingsAccountRepository.findAll();
    }

    public Optional<SavingsAccount> findById(Long id) {
        return savingsAccountRepository.findById(id);
    }

    public Optional<SavingsAccount> findByIdWithCard(Long id) {
        return savingsAccountRepository.findByIdWithCard(id);
    }

    public SavingsAccount save(SavingsAccount account) {
        return savingsAccountRepository.save(account);
    }

    public void deleteById(Long id) {
        savingsAccountRepository.deleteById(id);
    }
}
