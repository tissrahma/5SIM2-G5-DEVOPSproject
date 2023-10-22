import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class operatortest {

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Mock
    private OperatorRepository operatorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddOperator() {
        Operator operatorToAdd = new Operator();
        operatorToAdd.setIdOperateur(1L);
        operatorToAdd.setFname("John");
        operatorToAdd.setLname("Doe");
        operatorToAdd.setPassword("password");

        when(operatorRepository.save(operatorToAdd)).thenReturn(operatorToAdd);

        Operator savedOperator = operatorService.addOperator(operatorToAdd);

        assertEquals(operatorToAdd, savedOperator);
    }

    @Test
    public void testRetrieveOperator() {
        Long operatorId = 1L;
        Operator operator = new Operator();
        operator.setIdOperateur(operatorId);
        operator.setFname("John");
        operator.setLname("Doe");
        operator.setPassword("password");

        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));

        Operator retrievedOperator = operatorService.retrieveOperator(operatorId);

        assertEquals(operator, retrievedOperator);
    }

    @Test
    public void testRetrieveOperatorNotFound() {
        Long nonExistentOperatorId = 2L;

        when(operatorRepository.findById(nonExistentOperatorId)).thenReturn(Optional.empty());

        assertThrows(NullPointerException.class, () -> operatorService.retrieveOperator(nonExistentOperatorId));
    }

    @Test
    public void testRetrieveAllOperators() {
        List<Operator> operatorList = new ArrayList<>();
        operatorList.add(new Operator(1L, "John", "Doe", "password"));
        operatorList.add(new Operator(2L, "Alice", "Smith", "password"));

        when(operatorRepository.findAll()).thenReturn(operatorList);

        List<Operator> retrievedOperators = operatorService.retrieveAllOperators();

        assertEquals(operatorList, retrievedOperators);
    }
}
