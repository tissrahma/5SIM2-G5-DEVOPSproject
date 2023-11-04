package tn.esprit.devopsProject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devopsProject.entities.Supplier;
import tn.esprit.devopsProject.repositories.SupplierRepository;
import tn.esprit.devopsProject.services.SupplierServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SupplierTest {

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    @Test
    public void testRetrieveAllSuppliers() {
        List<Supplier> supplierList = new ArrayList<>();
        Supplier supplier1 = new Supplier();
        supplier1.setIdSupplier(1L);
        supplier1.setCode("S1");
        supplier1.setLabel("Label 1");

        Supplier supplier2 = new Supplier();
        supplier2.setIdSupplier(2L);
        supplier2.setCode("S2");
        supplier2.setLabel("Label 2");


        when(supplierRepository.findAll()).thenReturn(supplierList);

        List<Supplier> retrievedSupplierList = supplierService.retrieveAllSuppliers();

        assertEquals(supplierList, retrievedSupplierList);
    }

    @Test
    public void testAddSupplier() {
        Supplier supplierToAdd = new Supplier();
        supplierToAdd.setIdSupplier(1L);
        supplierToAdd.setCode("S1");

        when(supplierRepository.save(supplierToAdd)).thenReturn(supplierToAdd);

        Supplier savedSupplier = supplierService.addSupplier(supplierToAdd);

        assertEquals(supplierToAdd, savedSupplier);
    }

    @Test
    public void testRetrieveSupplier() {
        Long supplierId = 1L;
        Supplier supplier = new Supplier();
        supplier.setIdSupplier(supplierId);
        supplier.setCode("S1");

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));

        Supplier retrievedSupplier = supplierService.retrieveSupplier(supplierId);

        assertEquals(supplier, retrievedSupplier);
    }

    @Test
    public void testRetrieveSupplierNotFound() {
        Long nonExistentSupplierId = 2L;

        when(supplierRepository.findById(nonExistentSupplierId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> supplierService.retrieveSupplier(nonExistentSupplierId));
    }

    @Test
    public void testUpdateSupplier() {
        Supplier supplierToUpdate = new Supplier();
        supplierToUpdate.setIdSupplier(1L);
        supplierToUpdate.setCode("S1");

        when(supplierRepository.save(supplierToUpdate)).thenReturn(supplierToUpdate);

        Supplier updatedSupplier = supplierService.updateSupplier(supplierToUpdate);

        assertEquals(supplierToUpdate, updatedSupplier);
    }

    @Test
    public void testDeleteSupplier() {
        Long supplierIdToDelete = 1L;

        supplierService.deleteSupplier(supplierIdToDelete);

        // Verify that the delete method was called on the repository
        verify(supplierRepository).deleteById(supplierIdToDelete);
    }
}
