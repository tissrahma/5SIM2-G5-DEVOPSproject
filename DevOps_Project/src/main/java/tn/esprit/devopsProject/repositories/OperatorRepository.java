package tn.esprit.devopsProject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.devopsProject.entities.Operator;

public interface OperatorRepository extends CrudRepository<Operator, Long> {

}
