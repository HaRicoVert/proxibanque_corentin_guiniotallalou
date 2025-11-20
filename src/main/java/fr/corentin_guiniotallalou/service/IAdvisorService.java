package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.Advisor;

import java.util.List;
import java.util.Optional;

public interface IAdvisorService {
    List<Advisor> findAll();
    Optional<Advisor> findById(Long id);
    Optional<Advisor> findByIdWithClients(Long id);
    Advisor save(Advisor advisor);
    void deleteById(Long id);
}
