package fr.corentin_guiniotallalou.repository;

import fr.corentin_guiniotallalou.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT client FROM Client client LEFT JOIN FETCH client.currentAccounts LEFT JOIN FETCH client.savingsAccounts WHERE client.id = :id")
    Optional<Client> findByIdWithAccounts(Long id);

    @Query("SELECT client FROM Client client JOIN FETCH client.advisor WHERE client.id = :id")
    Optional<Client> findByIdWithAdvisor(Long id);
}