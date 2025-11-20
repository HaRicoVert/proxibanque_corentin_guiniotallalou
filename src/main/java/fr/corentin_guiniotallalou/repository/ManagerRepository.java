package fr.corentin_guiniotallalou.repository;

import fr.corentin_guiniotallalou.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
