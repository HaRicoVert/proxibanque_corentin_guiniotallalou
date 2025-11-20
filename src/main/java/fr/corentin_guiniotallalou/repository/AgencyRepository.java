package fr.corentin_guiniotallalou.repository;

import fr.corentin_guiniotallalou.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, String> {
    @Query("SELECT agency FROM Agency agency JOIN FETCH agency.manager WHERE agency.id = :id")
    Optional<Agency> findByIdWithManager(String id);

    @Query("SELECT agency FROM Agency agency LEFT JOIN FETCH agency.advisors WHERE agency.id = :id")
    Optional<Agency> findByIdWithAdvisors(String id);
}
