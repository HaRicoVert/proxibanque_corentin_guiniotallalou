package fr.corentin_guiniotallalou.repository;

import fr.corentin_guiniotallalou.model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
    @Query("SELECT account FROM SavingsAccount account LEFT JOIN FETCH account.card WHERE account.id = :id")
    Optional<SavingsAccount> findByIdWithCard(Long id);

    @Query("SELECT account FROM SavingsAccount account JOIN FETCH account.client WHERE account.id = :id")
    Optional<SavingsAccount> findByIdWithClient(Long id);
}
