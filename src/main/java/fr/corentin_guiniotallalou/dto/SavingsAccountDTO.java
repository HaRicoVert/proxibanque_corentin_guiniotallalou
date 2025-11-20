package fr.corentin_guiniotallalou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavingsAccountDTO {
    private Long id;
    private Long accountNumber;
    private Double balance;
    private LocalDate openingDate;
    private Long clientId;
    private CardDTO card;
    private Double interestRate;
}