package fr.corentin_guiniotallalou.repository;

import fr.corentin_guiniotallalou.model.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
    @Query("SELECT account FROM CurrentAccount account LEFT JOIN FETCH account.card WHERE account.id = :id")
    Optional<CurrentAccount> findByIdWithCard(Long id);

    @Query("SELECT account FROM CurrentAccount account JOIN FETCH account.client WHERE account.id = :id")
    Optional<CurrentAccount> findByIdWithClient(Long id);
}