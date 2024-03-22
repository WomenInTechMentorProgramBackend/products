package boxacademy.products.service;


import boxacademy.products.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductByProductCode(String productCode);

    Optional<Product> getProductById(UUID id);

    Product saveProduct(Product product);

    Product updateProduct(UUID id, Product product);

    void deleteProductById(UUID id);
}
