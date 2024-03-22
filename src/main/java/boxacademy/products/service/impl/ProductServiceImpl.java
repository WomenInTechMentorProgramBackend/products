package boxacademy.products.service.impl;


import boxacademy.products.entity.Product;
import boxacademy.products.exception.ObjectAlreadyExistException;
import boxacademy.products.exception.ResourceNotFoundException;
import boxacademy.products.repository.ProductRepository;
import boxacademy.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }
    @Override
    public Optional<Product> getProductByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    @Override
    public Product saveProduct(Product product) {
        if(getProductById(product.getId()).isPresent()) {
            throw new ObjectAlreadyExistException("Product with id=" + product.getId() + " already exists");
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(UUID id, Product product) {
        if(getProductById(product.getId()).isEmpty()) {
            throw new ResourceNotFoundException("Product with id=" + product.getId() + " not found");
        }
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(UUID id) {
        if(getProductById(id).isEmpty()) {
            throw new ResourceNotFoundException("Product with id=" + id + " not found");
        }
        productRepository.deleteById(id);
    }
}
