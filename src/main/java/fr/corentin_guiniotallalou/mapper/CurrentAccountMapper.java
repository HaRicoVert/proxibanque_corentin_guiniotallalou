package fr.corentin_guiniotallalou.mapper;

import fr.corentin_guiniotallalou.dto.CurrentAccountDTO;
import fr.corentin_guiniotallalou.model.CurrentAccount;
import org.springframework.stereotype.Component;

@Component
public class CurrentAccountMapper {

    private final CardMapper cardMapper;

    public CurrentAccountMapper(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    public CurrentAccountDTO toDTO(CurrentAccount account) {
        if (account == null) return null;

        Long clientId = null;
        if (account.getClient() != null) clientId = account.getClient().getId();

        return new CurrentAccountDTO(account.getId(), account.getAccountNumber(), account.getBalance(), account.getOpeningDate(), clientId, cardMapper.toDTO(account.getCard()), account.getOverdraftLimit());
    }

    public CurrentAccount toEntity(CurrentAccountDTO dto) {
        if (dto == null) return null;

        return new CurrentAccount(dto.getId(), dto.getAccountNumber(), dto.getBalance(), dto.getOpeningDate(), null, cardMapper.toEntity(dto.getCard()), dto.getOverdraftLimit());
    }
}
