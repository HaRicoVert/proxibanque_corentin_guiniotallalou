package fr.corentin_guiniotallalou;

import fr.corentin_guiniotallalou.model.*;
import fr.corentin_guiniotallalou.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class ProxiBanqueApplicationTests {
    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private AdvisorRepository advisorRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CurrentAccountRepository currentAccountRepository;
    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @Test
    void testCreateClientWithAccounts() {
        Manager manager = new Manager(null, "ROGER", "ROGER");
        managerRepository.save(manager);

        Agency agency = new Agency("PAR01", LocalDate.of(2003, 11, 6), manager, null);
        agencyRepository.save(agency);

        Advisor advisor = new Advisor(null, "ROGER", "ROGER", agency, null);
        advisorRepository.save(advisor);

        Client client = new Client(null, "ROGER", "ROGER", "1 allé berlioz", "92320", "Châtillon", "0102030405", advisor, null, null);
        clientRepository.save(client);

        Card card1 = new Card(null, 1234567890123456L, CardType.VISA_PREMIER, true);
        CurrentAccount currentAccount = new CurrentAccount(null, 1001L, 1500.0, LocalDate.now(), client, card1, 1000L);
        currentAccountRepository.save(currentAccount);

        Card card2 = new Card(null, 6543210987654321L, CardType.VISA_ELECTRON, true);
        SavingsAccount savingsAccount = new SavingsAccount(null, 2001L, 5000.0, LocalDate.now(), client, card2, 3.0);
        savingsAccountRepository.save(savingsAccount);

        System.out.println(client);
        System.out.println(currentAccount);
        System.out.println(savingsAccount);
    }
}
