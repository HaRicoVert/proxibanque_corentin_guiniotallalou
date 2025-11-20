package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.CurrentAccountDTO;

import java.util.List;
import java.util.Optional;

public interface ICurrentAccountService {
    List<CurrentAccountDTO> findAll();
    Optional<CurrentAccountDTO> findById(Long id);
    Optional<CurrentAccountDTO> findByIdWithCard(Long id);
    CurrentAccountDTO save(CurrentAccountDTO accountDTO);
    void deleteById(Long id);
}