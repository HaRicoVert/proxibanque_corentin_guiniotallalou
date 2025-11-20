package fr.corentin_guiniotallalou.repository;

import fr.corentin_guiniotallalou.model.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    @Query("SELECT advisor FROM Advisor advisor LEFT JOIN FETCH advisor.clients WHERE advisor.id = :id")
    Optional<Advisor> findByIdWithClients(Long id);

    @Query("SELECT advisor FROM Advisor advisor JOIN FETCH advisor.agency WHERE advisor.id = :id")
    Optional<Advisor> findByIdWithAgency(Long id);
}
