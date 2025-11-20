package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.AgencyDTO;

import java.util.List;
import java.util.Optional;

public interface IAgencyService {
    List<AgencyDTO> findAll();
    Optional<AgencyDTO> findById(String id);
    Optional<AgencyDTO> findByIdWithAdvisors(String id);
    AgencyDTO save(AgencyDTO agencyDTO);
    void deleteById(String id);
}