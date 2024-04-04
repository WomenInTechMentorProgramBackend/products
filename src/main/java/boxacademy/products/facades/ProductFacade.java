package boxacademy.products.facades;

import boxacademy.products.exception.ResourceNotFoundException;
import boxacademy.products.mapper.ProductMapper;
import boxacademy.products.service.impl.ProductServiceImpl;
import io.tej.SwaggerCodgen.model.ProductDto;
import io.tej.SwaggerCodgen.model.ProductsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductFacade {
    private final ProductServiceImpl productService;

    private final ProductMapper productMapper;


    public ProductDto addProduct(ProductDto roleDto) {
        var product = productMapper.productDtoToProduct(roleDto);
        product.setId(UUID.randomUUID());
        product.setCreatedAt(LocalDateTime.now());
        product.setCreatedBy("admin");
        product = productService.saveProduct(product);
        return productMapper.productToProductDto(product);
    }

    public void deleteProductById(String productId) {
        productService.deleteProductById(UUID.fromString(productId));
    }

    public ProductsModel getAllRoles() {
        var products = productService.getAllProducts();
       return new ProductsModel()
                .products(products.stream()
                        .map(productMapper::productToProductDto)
                        .toList());
    }

    public ProductDto getProductById(String productId) {
        var product = productService.getProductById(UUID.fromString(productId)).orElseThrow(() -> new ResourceNotFoundException("Product with ID " + productId + " not found"));
        return productMapper.productToProductDto(product);
    }

    public ProductDto getProductByProductCode(String productCode) {
        var product = productService.getProductByProductCode(productCode);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with productCode=" + productCode + " not found");
        }
        return productMapper.productToProductDto(product.get());
    }

    public ProductDto updateProduct(String productId, ProductDto productDto) {
        var product = productMapper.productDtoToProduct(productDto);
        product = productService.updateProduct(UUID.fromString(productId), product);
        return productMapper.productToProductDto(product);
    }

}
