package fr.corentin_guiniotallalou.dto;

import fr.corentin_guiniotallalou.model.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private Long id;
    private Long cardNumber;
    private CardType type;
    private Boolean active;
}