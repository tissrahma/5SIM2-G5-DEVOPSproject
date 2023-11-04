package tn.esprit.devopsProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsProject.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
