package boxacademy.products.controller;

import boxacademy.products.facades.ProductFacade;
import io.tej.SwaggerCodgen.api.ProductsApi;
import io.tej.SwaggerCodgen.model.ProductDto;
import io.tej.SwaggerCodgen.model.ProductsModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
@Transactional
public class ProductController implements ProductsApi {
    private final ProductFacade productFacade;

    @Override
    public ResponseEntity<ProductDto> addProduct(ProductDto productDto) {
        return new ResponseEntity<>(productFacade.addProduct(productDto), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<Void> deleteProductById(String productId) {
        productFacade.deleteProductById(productId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<ProductsModel> getAllProducts() {
        System.out.println("Hello!!!");
        return new ResponseEntity<>(productFacade.getAllRoles(), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<ProductDto> getProductByProductCode(String productCode) {
        return new ResponseEntity<>(productFacade.getProductByProductCode(productCode), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<ProductDto> getProductByProductId(String productId) {
        return new ResponseEntity<>(productFacade.getProductById(productId), HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(String productId, ProductDto productDto) {
        return new ResponseEntity<>(productFacade.updateProduct(productId, productDto), HttpStatusCode.valueOf(200));
    }
}
