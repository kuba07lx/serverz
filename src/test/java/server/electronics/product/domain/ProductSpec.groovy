package server.electronics.product.domain

import org.springframework.boot.context.annotation.UserConfigurations
import server.electronics.product.dto.ProductDto
import server.electronics.product.dto.ProductTypeDto
import server.electronics.user.domain.UserFacade
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest

class ProductSpec extends Specification implements SampleProducts {

    ProductFacade productFacade = new ProductConfiguration().productFacade();
    def "Should add product to database"() {

        when: "Product is added"
        productFacade.add(predator)
        List<ProductDto> products = productFacade.findAll()

        then: "List should contain the product"
        products.contains(predator)
        products.size() == 1
    }

    def "Should get list of products"() {

        given: "We have two products in system"
        productFacade.add(predator)
        productFacade.add(iphoneX)

        when: "We ask for all products"
        List<ProductDto> products = productFacade.findAll()

        then: "System returns us the products that we added"
        products.contains(iphoneX)
        products.contains(predator)
    }

    def "Should delete product from system"() {

        given: "We have one products in system"
        productFacade.add(predator)

        when: "We delete given product"
        productFacade.delete(predator.id)

        then: "There are not any products"
        productFacade.findAll().isEmpty()
    }

    def "Should show choosen product"() {

        given: "We have one product in system"
        ProductDto productDto = ProductDto.builder()
                .id(1l)
                .name("Acer Predator")
                .type(ProductTypeDto.NOTEBOOK)
                .price(2999)
                .description("Some description")
                .inStockNumber(25)
                .build()

        when: "We ask for choosen product"
        productFacade.add(productDto)
        ProductDto foundProduct = productFacade.show(1l)

        then: "Found product is equal to given product"
        foundProduct == productDto
    }
}