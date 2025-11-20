package fr.corentin_guiniotallalou.mapper;

import fr.corentin_guiniotallalou.dto.SavingsAccountDTO;
import fr.corentin_guiniotallalou.model.SavingsAccount;
import org.springframework.stereotype.Component;

@Component
public class SavingsAccountMapper {

    private final CardMapper cardMapper;

    public SavingsAccountMapper(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    public SavingsAccountDTO toDTO(SavingsAccount account) {
        if (account == null) return null;

        Long clientId = null;
        if (account.getClient() != null) clientId = account.getClient().getId();

        return new SavingsAccountDTO(account.getId(), account.getAccountNumber(), account.getBalance(), account.getOpeningDate(), clientId, cardMapper.toDTO(account.getCard()), account.getInterestRate());
    }

    public SavingsAccount toEntity(SavingsAccountDTO dto) {
        if (dto == null) return null;
        return new SavingsAccount(dto.getId(), dto.getAccountNumber(), dto.getBalance(), dto.getOpeningDate(), null, cardMapper.toEntity(dto.getCard()), dto.getInterestRate());
    }
}
