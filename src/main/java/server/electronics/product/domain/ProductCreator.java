package server.electronics.product.domain;

import server.electronics.product.dto.ProductDto;

import static java.util.Objects.requireNonNull;

class ProductCreator {

    Product from(ProductDto productDto){
        requireNonNull(productDto);
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .type(ProductType.valueOf(productDto.getType().name()))
                .description(productDto.getDescription())
                .inStockNumber(productDto.getInStockNumber())
                .active(productDto.getActive())
                .build();
    }
}
