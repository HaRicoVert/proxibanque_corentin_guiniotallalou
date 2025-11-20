package fr.corentin_guiniotallalou.mapper;

import fr.corentin_guiniotallalou.dto.CardDTO;
import fr.corentin_guiniotallalou.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDTO toDTO(Card card) {
        if (card == null) return null;

        return new CardDTO(card.getId(), card.getCardNumber(), card.getType(), card.getActive());
    }

    public Card toEntity(CardDTO dto) {
        if (dto == null) return null;

        return new Card(dto.getId(), dto.getCardNumber(), dto.getType(), dto.getActive());
    }
}
