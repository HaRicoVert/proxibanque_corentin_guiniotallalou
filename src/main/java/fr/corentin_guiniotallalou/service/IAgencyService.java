package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.Agency;

import java.util.List;
import java.util.Optional;

public interface IAgencyService {
    List<Agency> findAll();
    Optional<Agency> findById(String id);
    Optional<Agency> findByIdWithAdvisors(String id);
    Agency save(Agency agency);
    void deleteById(String id);
}
