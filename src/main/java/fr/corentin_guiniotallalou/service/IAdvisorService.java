package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.AdvisorDTO;

import java.util.List;
import java.util.Optional;

public interface IAdvisorService {
    List<AdvisorDTO> findAll();
    Optional<AdvisorDTO> findById(Long id);
    Optional<AdvisorDTO> findByIdWithClients(Long id);
    AdvisorDTO save(AdvisorDTO advisorDTO);
    void deleteById(Long id);
}