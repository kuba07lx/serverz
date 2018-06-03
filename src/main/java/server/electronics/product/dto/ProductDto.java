package server.electronics.product.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private ProductTypeDto type;
    private Double price;
    private Integer inStockNumber;
    private String description;
    private Boolean active;
}
