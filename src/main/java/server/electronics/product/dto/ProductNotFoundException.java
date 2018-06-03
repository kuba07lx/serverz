package server.electronics.product.dto;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("No product of id " + id + " found", null,false,false);
    }
}
