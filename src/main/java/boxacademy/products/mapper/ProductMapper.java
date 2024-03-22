package boxacademy.products.mapper;

import boxacademy.products.entity.Product;
import io.tej.SwaggerCodgen.model.ProductDto;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static java.util.Objects.nonNull;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    String OFFSET_ID = "+00:00";
    Product productDtoToProduct(ProductDto roleDto);
    ProductDto productToProductDto(Product role);
    default LocalDateTime map(OffsetDateTime value){
        return nonNull(value) ? value.toLocalDateTime() : null;
    }
    default OffsetDateTime map(LocalDateTime value){
        return nonNull(value) ? value.atOffset(ZoneOffset.of(OFFSET_ID)) : null;
    }
}
