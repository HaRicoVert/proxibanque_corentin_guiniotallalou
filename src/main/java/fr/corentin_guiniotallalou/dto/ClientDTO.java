package fr.corentin_guiniotallalou.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String address;
    private String postalCode;
    private String city;
    private String phone;
    private Long advisorId;
    private List<CurrentAccountDTO> currentAccounts;
    private List<SavingsAccountDTO> savingsAccounts;
}