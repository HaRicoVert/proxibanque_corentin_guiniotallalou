package fr.corentin_guiniotallalou.service;

import fr.corentin_guiniotallalou.dto.ClientDTO;
import fr.corentin_guiniotallalou.mapper.ClientMapper;
import fr.corentin_guiniotallalou.model.Client;
import fr.corentin_guiniotallalou.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ClientDTO> findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDTO);
    }

    public Optional<ClientDTO> findByIdWithAccounts(Long id) {
        return clientRepository.findByIdWithAccounts(id)
                .map(clientMapper::toDTO);
    }

    public ClientDTO save(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDTO(savedClient);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}