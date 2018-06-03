package server.electronics.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import server.electronics.product.dto.ProductDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private ProductType type;
    private Double price;
    private Integer inStockNumber;
    private String description;
    private Boolean active;

    ProductDto dto(){
        return ProductDto.builder()
                .id(id)
                .name(name)
                .price(price)
                .type(type.dto())
                .description(description)
                .inStockNumber(inStockNumber)
                .active(active)
                .build();
    }

}
