package server.electronics.product.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductConfiguration {

    ProductFacade productFacade(){
        return productFacade(new InMemoryProductRepository());
    }

    @Bean
    ProductFacade productFacade(ProductRepository productRepository){
        ProductCreator productCreator = new ProductCreator();
        ImageUploader imageUploader = new ImageUploader();
        return new ProductFacade(productRepository, productCreator, imageUploader);
    }
}
