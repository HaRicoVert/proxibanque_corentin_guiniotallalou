package fr.corentin_guiniotallalou.model;

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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private String address;
    private String postalCode;
    private String city;
    private String phone;

    @ManyToOne
    private Advisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurrentAccount> currentAccounts = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavingsAccount> savingsAccounts = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastName='" + lastName + '\'' + ", firstName='" + firstName + '\'' + ", address='" + address + '\'' + ", postalCode='" + postalCode + '\'' + ", city='" + city + '\'' + ", phone='" + phone + '\'' + ", advisor=" + advisor + ", currentAccounts=" + currentAccounts + ", savingsAccounts=" + savingsAccounts + '}';
    }
}