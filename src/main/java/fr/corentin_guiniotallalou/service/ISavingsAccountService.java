package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.SavingsAccountDTO;

import java.util.List;
import java.util.Optional;

public interface ISavingsAccountService {
    List<SavingsAccountDTO> findAll();
    Optional<SavingsAccountDTO> findById(Long id);
    Optional<SavingsAccountDTO> findByIdWithCard(Long id);
    SavingsAccountDTO save(SavingsAccountDTO accountDTO);
    void deleteById(Long id);
}