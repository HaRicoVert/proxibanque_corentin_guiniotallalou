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
public class CurrentAccount {
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

    private Long overdraftLimit = 1000L;

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                ", client=" + client +
                ", card=" + card +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}