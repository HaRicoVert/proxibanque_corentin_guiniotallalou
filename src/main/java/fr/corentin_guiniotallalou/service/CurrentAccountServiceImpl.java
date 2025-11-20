package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.CurrentAccountDTO;
import fr.corentin_guiniotallalou.mapper.CurrentAccountMapper;
import fr.corentin_guiniotallalou.model.CurrentAccount;
import fr.corentin_guiniotallalou.repository.CurrentAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CurrentAccountServiceImpl implements ICurrentAccountService {
    private final CurrentAccountRepository currentAccountRepository;
    private final CurrentAccountMapper currentAccountMapper;

    public CurrentAccountServiceImpl(CurrentAccountRepository currentAccountRepository, CurrentAccountMapper currentAccountMapper) {
        this.currentAccountRepository = currentAccountRepository;
        this.currentAccountMapper = currentAccountMapper;
    }

    public List<CurrentAccountDTO> findAll() {
        return currentAccountRepository.findAll().stream()
                .map(currentAccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CurrentAccountDTO> findById(Long id) {
        return currentAccountRepository.findById(id)
                .map(currentAccountMapper::toDTO);
    }

    public Optional<CurrentAccountDTO> findByIdWithCard(Long id) {
        return currentAccountRepository.findByIdWithCard(id)
                .map(currentAccountMapper::toDTO);
    }

    public CurrentAccountDTO save(CurrentAccountDTO accountDTO) {
        CurrentAccount account = currentAccountMapper.toEntity(accountDTO);
        CurrentAccount savedAccount = currentAccountRepository.save(account);
        return currentAccountMapper.toDTO(savedAccount);
    }

    public void deleteById(Long id) {
        currentAccountRepository.deleteById(id);
    }
}