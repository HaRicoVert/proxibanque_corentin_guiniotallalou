package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.AdvisorDTO;
import fr.corentin_guiniotallalou.mapper.AdvisorMapper;
import fr.corentin_guiniotallalou.model.Advisor;
import fr.corentin_guiniotallalou.repository.AdvisorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdvisorServiceImpl implements IAdvisorService {
    private final AdvisorRepository advisorRepository;
    private final AdvisorMapper advisorMapper;

    public AdvisorServiceImpl(AdvisorRepository advisorRepository, AdvisorMapper advisorMapper) {
        this.advisorRepository = advisorRepository;
        this.advisorMapper = advisorMapper;
    }

    public List<AdvisorDTO> findAll() {
        return advisorRepository.findAll().stream()
                .map(advisorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AdvisorDTO> findById(Long id) {
        return advisorRepository.findById(id)
                .map(advisorMapper::toDTO);
    }

    public Optional<AdvisorDTO> findByIdWithClients(Long id) {
        return advisorRepository.findByIdWithClients(id)
                .map(advisorMapper::toDTO);
    }

    public AdvisorDTO save(AdvisorDTO advisorDTO) {
        Advisor advisor = advisorMapper.toEntity(advisorDTO);
        Advisor savedAdvisor = advisorRepository.save(advisor);
        return advisorMapper.toDTO(savedAdvisor);
    }

    public void deleteById(Long id) {
        advisorRepository.deleteById(id);
    }
}