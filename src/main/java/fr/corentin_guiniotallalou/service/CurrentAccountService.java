package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.CurrentAccount;
import fr.corentin_guiniotallalou.repository.CurrentAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CurrentAccountService {
    private final CurrentAccountRepository currentAccountRepository;

    public CurrentAccountService(CurrentAccountRepository currentAccountRepository) {
        this.currentAccountRepository = currentAccountRepository;
    }

    public List<CurrentAccount> findAll() {
        return currentAccountRepository.findAll();
    }

    public Optional<CurrentAccount> findById(Long id) {
        return currentAccountRepository.findById(id);
    }

    public Optional<CurrentAccount> findByIdWithCard(Long id) {
        return currentAccountRepository.findByIdWithCard(id);
    }

    public CurrentAccount save(CurrentAccount account) {
        return currentAccountRepository.save(account);
    }

    public void deleteById(Long id) {
        currentAccountRepository.deleteById(id);
    }
}