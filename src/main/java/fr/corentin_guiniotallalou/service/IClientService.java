package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Optional<Client> findByIdWithAccounts(Long id);
    Client save(Client client);
    void deleteById(Long id);
}
