package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.model.Agency;
import fr.corentin_guiniotallalou.repository.AgencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgencyServiceImpl implements IAgencyService {
    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> findById(String id) {
        return agencyRepository.findById(id);
    }

    public Optional<Agency> findByIdWithAdvisors(String id) {
        return agencyRepository.findByIdWithAdvisors(id);
    }

    public Agency save(Agency agency) {
        return agencyRepository.save(agency);
    }

    public void deleteById(String id) {
        agencyRepository.deleteById(id);
    }
}