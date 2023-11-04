package tn.esprit.devopsProject.services.Iservices;

import tn.esprit.devopsProject.entities.Product;
import tn.esprit.devopsProject.entities.ProductCategory;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product, Long idStock);
    Product retrieveProduct(Long id);
    List<Product> retreiveAllProduct();
    List<Product> retrieveProductByCategory(ProductCategory category);
    void deleteProduct(Long id);
    List<Product> retreiveProductStock(Long id);


}
