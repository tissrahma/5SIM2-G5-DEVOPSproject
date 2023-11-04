package tn.esprit.devopsProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsProject.entities.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {

}
