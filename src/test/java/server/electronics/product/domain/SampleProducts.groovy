package server.electronics.product.domain

import groovy.transform.CompileStatic
import server.electronics.product.domain.ProductType
import server.electronics.product.dto.ProductDto
import server.electronics.product.dto.ProductTypeDto

trait SampleProducts {
    ProductDto predator = createProductDto(1l, "Acer Predator", ProductTypeDto.NOTEBOOK, 399,5,"lol")
    ProductDto iphoneX = createProductDto(2l, "Iphone X", ProductTypeDto.SMARTPHONE, 296, 2, "Super Laptop")


    static private ProductDto createProductDto(Long id, String name, ProductTypeDto type, Double price, Integer inStockNumber, String description){
        return ProductDto.builder()
                .id(id)
                .name(name)
                .type(type)
                .price(price)
                .description(description)
                .inStockNumber(inStockNumber)
                .build()
    }
}