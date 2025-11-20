package fr.corentin_guiniotallalou.mapper;

import fr.corentin_guiniotallalou.dto.ClientDTO;
import fr.corentin_guiniotallalou.dto.CurrentAccountDTO;
import fr.corentin_guiniotallalou.dto.SavingsAccountDTO;
import fr.corentin_guiniotallalou.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    private final CurrentAccountMapper currentAccountMapper;
    private final SavingsAccountMapper savingsAccountMapper;

    public ClientMapper(CurrentAccountMapper currentAccountMapper, SavingsAccountMapper savingsAccountMapper) {
        this.currentAccountMapper = currentAccountMapper;
        this.savingsAccountMapper = savingsAccountMapper;
    }

    public ClientDTO toDTO(Client client) {
        if (client == null) return null;

        Long advisorId = null;
        if (client.getAdvisor() != null) advisorId = client.getAdvisor().getId();

        List<CurrentAccountDTO> currentAccounts = null;
        if (client.getCurrentAccounts() != null)
            currentAccounts = client.getCurrentAccounts().stream().map(currentAccountMapper::toDTO).collect(Collectors.toList());

        List<SavingsAccountDTO> savingsAccounts = null;
        if (client.getSavingsAccounts() != null)
            savingsAccounts = client.getSavingsAccounts().stream().map(savingsAccountMapper::toDTO).collect(Collectors.toList());

        return new ClientDTO(client.getId(), client.getLastName(), client.getFirstName(), client.getAddress(), client.getPostalCode(), client.getCity(), client.getPhone(), advisorId, currentAccounts, savingsAccounts);
    }

    public Client toEntity(ClientDTO dto) {
        if (dto == null) return null;

        return new Client(dto.getId(), dto.getLastName(), dto.getFirstName(), dto.getAddress(), dto.getPostalCode(), dto.getCity(), dto.getPhone(), null, null, null);
    }
}
