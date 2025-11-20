package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<ClientDTO> findAll();
    Optional<ClientDTO> findById(Long id);
    Optional<ClientDTO> findByIdWithAccounts(Long id);
    ClientDTO save(ClientDTO clientDTO);
    void deleteById(Long id);
}