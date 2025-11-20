package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.SavingsAccountDTO;
import fr.corentin_guiniotallalou.mapper.SavingsAccountMapper;
import fr.corentin_guiniotallalou.model.SavingsAccount;
import fr.corentin_guiniotallalou.repository.SavingsAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SavingsAccountServiceImpl implements ISavingsAccountService {
    private final SavingsAccountRepository savingsAccountRepository;
    private final SavingsAccountMapper savingsAccountMapper;

    public SavingsAccountServiceImpl(SavingsAccountRepository savingsAccountRepository, SavingsAccountMapper savingsAccountMapper) {
        this.savingsAccountRepository = savingsAccountRepository;
        this.savingsAccountMapper = savingsAccountMapper;
    }

    public List<SavingsAccountDTO> findAll() {
        return savingsAccountRepository.findAll().stream()
                .map(savingsAccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<SavingsAccountDTO> findById(Long id) {
        return savingsAccountRepository.findById(id)
                .map(savingsAccountMapper::toDTO);
    }

    public Optional<SavingsAccountDTO> findByIdWithCard(Long id) {
        return savingsAccountRepository.findByIdWithCard(id)
                .map(savingsAccountMapper::toDTO);
    }

    public SavingsAccountDTO save(SavingsAccountDTO accountDTO) {
        SavingsAccount account = savingsAccountMapper.toEntity(accountDTO);
        SavingsAccount savedAccount = savingsAccountRepository.save(account);
        return savingsAccountMapper.toDTO(savedAccount);
    }

    public void deleteById(Long id) {
        savingsAccountRepository.deleteById(id);
    }
}