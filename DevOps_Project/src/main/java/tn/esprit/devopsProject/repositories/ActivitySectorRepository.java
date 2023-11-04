package tn.esprit.devopsProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsProject.entities.ActivitySector;

public interface ActivitySectorRepository extends JpaRepository<ActivitySector, Long> {
}
