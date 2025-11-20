package fr.corentin_guiniotallalou.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;

    @ManyToOne
    @JsonIgnoreProperties({"advisors", "manager"})
    private Agency agency;

    @OneToMany(mappedBy = "advisor")
    @JsonIgnoreProperties({"advisor", "currentAccounts", "savingsAccounts"})
    private List<Client> clients = new ArrayList<>();
}