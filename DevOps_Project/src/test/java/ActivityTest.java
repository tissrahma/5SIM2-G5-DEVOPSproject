
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ActivitySectorImpl;
import tn.esprit.devops_project.services.StockServiceImpl;
import org.mockito.Mockito.*;
import javax.transaction.Transactional;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest(classes = ActivitySector.class)


public class ActivityTest {

    @InjectMocks
    private ActivitySectorImpl activitySectorService;

    @Mock
    private ActivitySectorRepository activitySectorRepository;
//
    @Test
    public void testAddActivity() {

        ActivitySector activityToAdd = new ActivitySector();
        activityToAdd.setIdSecteurActivite(1L);
        activityToAdd.setCodeSecteurActivite("Test CodeSecteurActivite");
        activityToAdd.setLibelleSecteurActivite("Test LibelleSecteurActivite");
        Set<Supplier> supplierSet = new HashSet<>();

        activityToAdd.setSuppliers(supplierSet);
        when(activitySectorRepository.save(activityToAdd)).thenReturn(activityToAdd);

        ActivitySector savedActivity = activitySectorService.addActivitySector(activityToAdd);

        System.out.println("Expected Stock: " + activityToAdd);
        System.out.println("Actual Stock: " + savedActivity);

        assertEquals(activityToAdd, savedActivity);
    }

    @Test
    public void testRetrieveActivity() {
        Long activityId = 1L;
        ActivitySector activitySector = new ActivitySector();
        activitySector.setIdSecteurActivite(activityId);
        activitySector.setCodeSecteurActivite("Test CodeSecteurActivite");
        activitySector.setLibelleSecteurActivite("Test LibelleSecteurActivite");
        Set<Supplier> supplierSet = new HashSet<>();

        activitySector.setSuppliers(supplierSet);
        when(activitySectorRepository.findById(activityId)).thenReturn(Optional.of(activitySector));

        ActivitySector retrieveActivitySector = activitySectorService.retrieveActivitySector(activityId);

        assertEquals(activitySector, retrieveActivitySector);
    }

    @Test
    public void testRetrieveActivityNotFound() {
        Long nonExistentActivityId = 2L;

        when(activitySectorRepository.findById(nonExistentActivityId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> activitySectorService.retrieveActivitySector(nonExistentActivityId));
    }


    @Test
    public void testRetrieveAllActivity() {
        Set<Supplier> supplierSet = new HashSet<>();


        List<ActivitySector> activitySectorList = new ArrayList<>();
        activitySectorList.add(new ActivitySector(1L, "Activity 1", "LibelleSecteurActivite", supplierSet));
        activitySectorList.add(new ActivitySector(2L, "Activity 2", "LibelleSecteurActivite",supplierSet));

        when(activitySectorRepository.findAll()).thenReturn(activitySectorList);

        List<ActivitySector> retrievedActivityList = activitySectorService.retrieveAllActivitySectors();

        assertEquals(activitySectorList, retrievedActivityList);
    }


}
