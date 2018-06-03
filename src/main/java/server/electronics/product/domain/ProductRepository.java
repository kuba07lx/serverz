package server.electronics.product.domain;


import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface ProductRepository extends Repository<Product, Long> {
    Product save(Product product);
    List<Product> findAll();
    void deleteById(Long id);
    Optional<Product> findById(Long id);
}
