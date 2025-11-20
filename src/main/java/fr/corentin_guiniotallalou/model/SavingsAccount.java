package fr.corentin_guiniotallalou.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SavingsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountNumber;
    private Double balance;
    private LocalDate openingDate;

    @ManyToOne
    @JsonIgnoreProperties({"currentAccounts", "savingsAccounts", "advisor"})
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    private Double interestRate = 3.0;

    @Override
    public String toString() {
        return "SavingsAccount{" + "id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + ", openingDate=" + openingDate + ", client=" + client + ", card=" + card + ", interestRate=" + interestRate + '}';
    }
}