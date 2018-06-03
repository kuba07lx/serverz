package server.electronics.product.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import server.electronics.product.dto.ProductTypeDto;

import java.util.Arrays;

enum ProductType {
    NOTEBOOK, SMARTPHONE, CAMERA;

    ProductTypeDto dto() {
        return ProductTypeDto.valueOf(name());
    }
}
