package tn.esprit.devopsProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devopsProject.entities.Stock;


public interface StockRepository extends JpaRepository<Stock, Long> {}

