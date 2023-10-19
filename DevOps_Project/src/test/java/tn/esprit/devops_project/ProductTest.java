package tn.esprit.devops_project;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private StockRepository stockRepository;
    @Mock
    private ProductRepository productRepository;
    @Test
    public void addProductTest() {
      //  Long stockId = 0L;
        Stock stock = new Stock();
        when(stockRepository.findById(eq(stock.getIdStock()))).thenReturn(Optional.of(stock));
        Product newProduct = new Product(0L, "new Product", 10, 10, ProductCategory.ELECTRONICS, stock);
        when(productRepository.save(eq(newProduct))).thenReturn(newProduct);
        Product result = productService.addProduct(newProduct, stock.getIdStock());
        assertThat(result).isNotNull();
        assertThat(result).isNotNull();
        assertThat(result.getIdProduct()).isNotNull();
        assertThat(result.getTitle()).isEqualTo("new Product");
        verify(productRepository, times(1)).save(eq(newProduct));
    }
    @Test
    public void retrieveAllProductTest() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", 20, 5, ProductCategory.ELECTRONICS, new Stock()));
        productList.add(new Product(2L, "Product 2", 15, 8, ProductCategory.CLOTHING, new Stock()));
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> result = productService.retreiveAllProduct();
        System.out.println("............................."+result);
        assertThat(result).isNotNull();
        assertThat(result.get(0).getIdProduct()).isEqualTo(1L);
        assertThat(result.get(0).getTitle()).isEqualTo("Product 1");
        assertThat(result.get(1).getIdProduct()).isEqualTo(2L);
        assertThat(result.get(1).getTitle()).isEqualTo("Product 2");
        verify(productRepository, times(1)).findAll();
    }
    @Test
    public void deleteProductTest() {
        Long productIdToDelete = 5L;
        doNothing().when(productRepository).deleteById(productIdToDelete);
        productService.deleteProduct(productIdToDelete);
        verify(productRepository, times(1)).deleteById(productIdToDelete);
    }
    @Test
    public void retrieveProductTest() {
        Long productIdToRetrieve = 1L;
        Product expectedProduct = new Product(productIdToRetrieve, "Sample Product", 10, 10, ProductCategory.ELECTRONICS, new Stock());
        when(productRepository.findById(productIdToRetrieve)).thenReturn(Optional.of(expectedProduct));
        Product result = productService.retrieveProduct(productIdToRetrieve);
        verify(productRepository, times(1)).findById(productIdToRetrieve);
        assertEquals(expectedProduct, result);
    }


}
