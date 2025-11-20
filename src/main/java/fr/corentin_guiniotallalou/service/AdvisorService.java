package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.Advisor;
import fr.corentin_guiniotallalou.repository.AdvisorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdvisorService {
    private final AdvisorRepository advisorRepository;

    public AdvisorService(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    public List<Advisor> findAll() {
        return advisorRepository.findAll();
    }

    public Optional<Advisor> findById(Long id) {
        return advisorRepository.findById(id);
    }

    public Optional<Advisor> findByIdWithClients(Long id) {
        return advisorRepository.findByIdWithClients(id);
    }

    public Advisor save(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    public void deleteById(Long id) {
        advisorRepository.deleteById(id);
    }
}