package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.AgencyDTO;
import fr.corentin_guiniotallalou.mapper.AgencyMapper;
import fr.corentin_guiniotallalou.model.Agency;
import fr.corentin_guiniotallalou.repository.AgencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AgencyServiceImpl implements IAgencyService {
    private final AgencyRepository agencyRepository;
    private final AgencyMapper agencyMapper;

    public AgencyServiceImpl(AgencyRepository agencyRepository, AgencyMapper agencyMapper) {
        this.agencyRepository = agencyRepository;
        this.agencyMapper = agencyMapper;
    }

    public List<AgencyDTO> findAll() {
        return agencyRepository.findAll().stream()
                .map(agencyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AgencyDTO> findById(String id) {
        return agencyRepository.findById(id)
                .map(agencyMapper::toDTO);
    }

    public Optional<AgencyDTO> findByIdWithAdvisors(String id) {
        return agencyRepository.findByIdWithAdvisors(id)
                .map(agencyMapper::toDTO);
    }

    public AgencyDTO save(AgencyDTO agencyDTO) {
        Agency agency = agencyMapper.toEntity(agencyDTO);
        Agency savedAgency = agencyRepository.save(agency);
        return agencyMapper.toDTO(savedAgency);
    }

    public void deleteById(String id) {
        agencyRepository.deleteById(id);
    }
}