package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.CurrentAccount;

import java.util.List;
import java.util.Optional;

public interface ICurrentAccountService {
    List<CurrentAccount> findAll();
    Optional<CurrentAccount> findById(Long id);
    Optional<CurrentAccount> findByIdWithCard(Long id);
    CurrentAccount save(CurrentAccount account);
    void deleteById(Long id);
}
